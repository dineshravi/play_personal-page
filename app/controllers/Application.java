package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render("dineshra@buffalo.edu"));
    }
   public static Result tech(){
	   return ok(tech.render());
   }
}
