package controllers;

import java.util.List;
import java.util.Map;

import models.Post;
import play.data.DynamicForm;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.business;
import views.html.index;
import views.html.myIndex;
import views.html.tech;

public class Application extends Controller {
  
	public static Result index() {
		return ok(index.render());
	}

	public static Result tech() {
		return ok(tech.render());
	}

	public static Result business() {
		return ok(business.render());
					
	}
	
	public static Result my_login() {
		DynamicForm data = Form.form().bindFromRequest();

		String email = data.get("email");

		String password = data.get("password");
		
		if (email.equals("email") && password.equalsIgnoreCase("one")) {
			response().setCookie("admin", "dinesh");
			
			return redirect(routes.PostsController.adminIndex());
		} else
			return ok(index.render());
	}
	
	public static Result logout(){
		response().discardCookie("admin", "dinesh");	
		    return redirect(routes.Application.index());
	}
	
	
}
