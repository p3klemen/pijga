package controllers;

import play.*;
import play.mvc.*;

import views.html.*;
import models.*;

import java.util.List;

import com.avaje.ebean.*;
public class Application extends Controller {
  
    public static Result index() {

        //racuni join cene
        //Racuni r = Racuni.find.fetch("cene").where().eq("cene.artikel.artikli_id",2).findUnique();
        //racuni join cene join artikli
        Racuni r = Racuni.find
            .fetch("cene",new FetchConfig().query())
            .fetch("cene.artikel",new FetchConfig().query())
            .where().eq("cene.artikel.naziv","lasko").findUnique();
        Logger.warn(r.znesek.toString());
        
       return ok(index.render(Artikli.find.byId(2)));
    }
  
}
