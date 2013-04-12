package controllers;

import java.util.List;

import models.Post;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.editPost;
import views.html.index;
import views.html.myIndex;
import views.html.postsIndex;

public class PostsController extends Controller {
	
	public static Result postsIndex(){
		List<Post> posts = new Model.Finder(String.class, Post.class).all();
		return ok(postsIndex.render(posts));
	}
	
	public static Result adminIndex(){
		List<Post> posts = new Model.Finder(String.class, Post.class).all();
		return ok(myIndex.render(posts));
	}
	
	public static Result newPost(){
		String cookieName = request().cookies().get("admin").value();
		if(cookieName.equals("dinesh")){
			return ok(views.html.newPost.render());
		}
		 else return redirect(routes.Application.index());
	}
	
	public static Result addPost(){
		String cookieName = request().cookies().get("admin").value();
		if(cookieName.equals("dinesh")){
		Post post = Form.form(Post.class).bindFromRequest().get();
		post.save();
		return redirect(routes.PostsController.adminIndex());
		}else return
			redirect(routes.Application.index());
		
	}
		
	public static Result editPost(Long id){
		String cookieName = request().cookies().get("admin").value();
		if(cookieName.equals("dinesh")){
		Post post = (Post) new Model.Finder(String.class, Post.class).byId(id);		
		return ok(editPost.render(post));
		}else return
				redirect(routes.Application.index());
	}
	
	public static Result updatePost(Long id){
		String cookieName = request().cookies().get("admin").value();
		if(cookieName.equals("dinesh")){
		Post post1 = (Post) new Model.Finder(String.class, Post.class).byId(id);
		Post post2 = Form.form(Post.class).bindFromRequest().get();
		post1.title = post2.title;
		post1.content = post2.content;
		post1.save();
		return redirect(routes.PostsController.adminIndex());
		}else return
			redirect(routes.Application.index());
	}
	
	public static Result deletePost(Long id){
		String cookieName = request().cookies().get("admin").value();
		if(cookieName.equals("dinesh")){
		 Post post = (Post) new Model.Finder(String.class, Post.class).byId(id);
		 post.delete();
		 return redirect(routes.PostsController.adminIndex());
		}else return
				redirect(routes.Application.index());
	}

}
