package controllers;

import java.util.Map;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
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
		
		String cookieName = request().cookies().get("admin").value();
		if(cookieName.equals("dinesh")){
			return ok(myIndex.render(" Cookie :" ,cookieName  ));
		}
		 else return ok(index.render());
			
	}

	public static Result my_login() {
		DynamicForm data = Form.form().bindFromRequest();

		String email = data.get("email");

		String password = data.get("password");
		
		if (email.equals("email") && password.equalsIgnoreCase("one")) {
			response().setCookie("admin", "dinesh");
			return ok(myIndex.render(email, password));
		} else
			return ok(index.render());
	}


}
