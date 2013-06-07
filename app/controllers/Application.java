package controllers;

import play.*;
import play.data.*;
import static play.data.Form.*;
import play.mvc.*;

import views.html.*;
import views.html.dashboard.usermenu;
import models.*;

import java.util.List;

import com.avaje.ebean.*;
public class Application extends Controller {

    public static class Login {
        public String email;
        public String password;
        
        public String validate() {
            Logger.info("Login: " + email + " " + password);
            if(Osebe.authenticate(email, password) == null) {
                return "Nepravilno geslo ali email";
            }
            return null;
        }
    }
    /**
     * Login page.
     */
    //public static Result login() {
        //return ok(
            //login.render(form(Login.class))
        //);
    //}
    public static String login() {
        String user = session("email");
        if(user != null) {
            return usermenu.render(user).body();
        } 
        return login.render(form(Login.class)).body();
    }
    
    /**
     * Handle login form submission.
     */
    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        if(loginForm.hasErrors()) {
            Logger.warn("login form has errors "+loginForm.errorsAsJson());
            Http.Context.current().args.put("loginform", loginForm);
            return badRequest(index.render());
        } else {
            session("email", loginForm.get().email);
            return redirect(
                routes.Dashboard.index()
            );
        }
    }

    /**
     * Logout and clean the session.
     */
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
            routes.Application.index()
        );
    }
  
    public static Result index() {

        //racuni join cene
        //Racuni r = Racuni.find.fetch("cene").where().eq("cene.artikel.artikli_id",2).findUnique();
        //racuni join cene join artikli

        //Racuni r = Racuni.find
            //.fetch("cene",new FetchConfig().query())
            //.fetch("cene.artikel",new FetchConfig().query())
            //.where().eq("cene.artikel.naziv","zlatorog").findUnique();
        //Logger.warn(r.znesek.toString());
        
       return ok(index.render());
    }
    public static Result about() {
       return ok(about.render());
    }
    public static Result artikli() {
       return ok(artikli.render(Artikli.find.all()));
    }
  
}
