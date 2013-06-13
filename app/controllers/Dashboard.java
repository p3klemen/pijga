package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import play.data.format.Formatters.SimpleFormatter;
import play.data.format.Formatters;
import org.joda.time.format.DateTimeFormat;
import java.util.regex.*;
import java.text.ParseException;


import play.data.validation.ValidationError;
import java.util.*;
import com.avaje.ebean.*;
import org.joda.time.*;

import models.*;

import views.html.dashboard.*;
import views.html.dashboard.form.*;
import views.html.dashboard.panel.*;
//import views.html.projects.*;

/**
 * Manage projects related operations.
 */
//@Security.Authenticated(Secured.class)
public class Dashboard extends Controller {
    /**
     * Drzi izbrane artikle
     */
    public static class Art{
        public List<String> artikli;
    }

    /**
     * Display the dashboard.
     */
    public static Result index() {
        return ok(
            //dashboard.render(
                //Project.findInvolving(request().username()),
                //Task.findTodoInvolving(request().username()),
                //User.find.byId(request().username())
            //)
            index.render()
        );
    }

    public static String dashmenu() {
        return dashmenu.render().body();
    }

    public static Result listDavek(){
        return ok(davki.render(Davki.find.all()));
    }

    public static Result formDavek(){
        return ok(davek.render(form(Davki.class)));
    }
    public static Result addDavek(){
        Form<Davki> eform = form(Davki.class).bindFromRequest();
        if(eform.hasErrors()) {
            for( ValidationError e  : eform.globalErrors()){
                Logger.warn("error  " + e.message());
            }

                Logger.warn("error  " +eform.errors().get("davek"));

            Logger.warn("login form has errors "+eform.errorsAsJson());
            return badRequest(davek.render(eform));
        } else {
            Logger.info("Dodal davek: " + eform.get().davek);
            Ebean.save(eform.bindFromRequest().get());
            return redirect(
                routes.Dashboard.listDavek()
            );
        }
    }
    //Vrste
    public static Result listVrsta(){
        return ok(vrste.render(Vrste.find.all()));
    }

    public static Result formVrsta(){
        return ok(vrsta.render(form(Vrste.class),Davki.find.all()));
    }
    public static Result addVrsta(){
        Form<Vrste> eform = form(Vrste.class).bindFromRequest();
        if(eform.hasErrors()) {
            for( ValidationError e  : eform.globalErrors()){
                Logger.warn("error  " + e.message());
            }

                Logger.warn("error  " +eform.errors().get("davek"));

            Logger.warn("login form has errors "+eform.errorsAsJson());
            return badRequest(vrsta.render(eform, Davki.find.all()));
        } else {
            Logger.info("Dodal davek: " + eform.get().davek);
            Ebean.save(eform.bindFromRequest().get());
            return redirect(
                routes.Dashboard.listVrsta()
            );
        }
    }
    //Bari
    public static Result listBari(){
        return ok(bari.render(Bari.find.all()));
    }

    public static Result formBar(){
        return ok(bar.render(form(Bari.class)));
    }
    //TODO bari error checking
    public static Result addBar(){
        Form<Bari> eform = form(Bari.class).bindFromRequest();
        if(eform.hasErrors()) {
            for( ValidationError e  : eform.globalErrors()){
                Logger.warn("error  " + e.message());
            }

                Logger.warn("error  " +eform.errors().get("naziv"));

            Logger.warn("login form has errors "+eform.errorsAsJson());
            return badRequest(bar.render(eform));
        } else {
            Logger.info("Dodal bar: " + eform.get().naziv);
            Ebean.save(eform.bindFromRequest().get());
            return redirect(
                routes.Dashboard.listBari()
            );
        }
    }
    //Osebe
    public static Result listOsebe(){
        return ok(osebe.render(Osebe.find.all()));
    }

    public static Result formOseba(){
        return ok(oseba.render(form(Osebe.class)));
    }
    public static Result addOseba(){
        Form<Osebe> eform = form(Osebe.class).bindFromRequest();
        if(eform.hasErrors()) {
            for( ValidationError e  : eform.globalErrors()){
                Logger.warn("error  " + e.message());
            }

                //Logger.warn("error  "+eform.errors().get("naziv"));

            Logger.warn("login form has errors "+eform.errorsAsJson());
            return badRequest(oseba.render(eform));
        } else {
            //Logger.info("Dodal bar: " + eform.get().naziv);
            Ebean.save(eform.bindFromRequest().get());
            return redirect(
                routes.Dashboard.listOsebe()
            );
        }
    }
    //Akcije
    public static Result listAkcije(){
        return ok(akcije.render(Akcije.find.all()));
    }

    public static Result formAkcija(){
        return ok(akcija.render(form(Akcije.class)));
    }
    public static Result addAkcija(){
        Form<Akcije> eform = form(Akcije.class).bindFromRequest();



        if(eform.hasErrors()) {
            for( ValidationError e  : eform.globalErrors()){
                Logger.warn("error  " + e.message());
            }

                Logger.warn("error  "+eform.errors().get("datum_konca"));

            Logger.warn("login form has errors "+eform.errorsAsJson());
            return badRequest(akcija.render(eform));
        } else {
            //Logger.info("Dodal bar: " + eform.get().naziv);
            Ebean.save(eform.bindFromRequest().get());
            return redirect(
                routes.Dashboard.listAkcije()
            );
        }
    }
    //Artikli
    public static Result listArtikli(){
        return ok(artikli.render(Artikli.find.all()));
    }

    public static Result formArtikel(){
        return ok(artikel.render(form(Artikli.class)));
    }
    public static Result addArtikel(){
        Form<Artikli> eform = form(Artikli.class).bindFromRequest();
        if(eform.hasErrors()) {
            for( ValidationError e  : eform.globalErrors()){
                Logger.warn("error  " + e.message());
            }

                //Logger.warn("error  "+eform.errors().get("naziv"));

            Logger.warn("login form has errors "+eform.errorsAsJson());
            return badRequest(artikel.render(eform));
        } else {
            //Logger.info("Dodal bar: " + eform.get().naziv);
            Ebean.save(eform.bindFromRequest().get());
            return redirect(
                routes.Dashboard.listArtikli()
            );
        }
    }
    //Rezervacije
    public static Result listRezervacije(){
        return ok(rezervacije.render(Rezervacije.find.all()));
    }

    public static Result formRezervacija(){
        return ok(rezervacija.render(form(Rezervacije.class)));
    }
    public static Result addRezervacija(){
        Form<Rezervacije> eform = form(Rezervacije.class).bindFromRequest();
        if(eform.hasErrors()) {
            for( ValidationError e  : eform.globalErrors()){
                Logger.warn("error  " + e.message());
            }

                //Logger.warn("error  "+eform.errors().get("naziv"));

            Logger.warn("login form has errors "+eform.errorsAsJson());
            return badRequest(rezervacija.render(eform));
        } else {
            //Logger.info("Dodal bar: " + eform.get().naziv);
            Ebean.save(eform.bindFromRequest().get());
            return redirect(
                routes.Dashboard.listRezervacije()
            );
        }
    }

    //TODO RACUNI!!!
    public static Result formRacun(){
        return ok(racun.render(form(Racuni.class)));
    }
    public static Result addRacun(){
        Form<Racuni> eform = form(Racuni.class).bindFromRequest();
        if(eform.hasErrors()) {
            for( ValidationError e  : eform.globalErrors()){
                Logger.warn("error  " + e.message());
            }

                //Logger.warn("error  "+eform.errors().get("naziv"));

            Logger.warn("login form has errors "+eform.errorsAsJson());
            return badRequest(racun.render(eform));
        } else {
            //Logger.info("Dodal bar: " + eform.get().naziv);
            //Ebean.save(eform.bindFromRequest().get());
            return redirect(
                routes.Dashboard.listRezervacije()
            );
        }
    }
    //Postopek izdelave racuna
    public static Result formIzbiraArtikli(){
        return ok(izbiraArtiklov.render(Artikli.getMapByVrste()));
    }
    public static Result addRacun3(){
        DynamicForm dform = form().bindFromRequest();
        //pridobimo izbrane vrednosti [artikli_id -> kolicina]
        Map<String,String> mapa = dform.data();
        
        //ustvarimo racun
        Racuni racun = new Racuni();
        Osebe o = new Osebe();
        o.osebe_id = 1;
        racun.oseba = o;
        Bari b = new Bari();
        b.bari_id = 1;
        racun.bar = b;
        racun.znesek = 0.0;
        racun.datum = new LocalDate();
        racun.ura = new LocalTime();
        racun.save();

        List<Cene> cene = new ArrayList();
        List<Integer> ids = new ArrayList();
        //shranimo si idje artiklov
        for (Map.Entry<String, String> entry : mapa.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if(!value.equals("0")){
            Logger.warn(key + " - " + value);
                ids.add(Integer.parseInt(key));
            }
        }
        //pridobimo listo artiklov
        List<Artikli> art = Artikli.find.where().idIn(ids).findList();

        //za vsak artikel izracunamo ceno
        Double znesek = 0.0;
        for(Artikli a : art){
            Cene c = new Cene();
            c.artikel = a;
            c.kolicina = Integer.parseInt(mapa.get(Integer.toString(a.artikli_id)));
            c.cena = c.kolicina * a.cena;
            znesek += c.cena;
            c.racun = racun;
            cene.add(c);
            Logger.info("Dodal ceno: " + c);
        }
        //posodobimo in shranimo racun ter cene
        racun.znesek = znesek;
        racun.update();
        Ebean.save(cene);

        return ok(izdanRacun.render(racun, cene));
    }
    public static Result addRacun2(){
        //Form<Art> eform = form(Art.class).bindFromRequest();
        //Art a = eform.bindFromRequest().get();
        /**
         *Binding to class
         */
        //Art a = form(Art.class).bindFromRequest().get();
        //Logger.info("checkboxs: " + a.artikli.size());
        //for(String s : a.artikli)
        //Logger.info("art id: " + s);

        /**
         * Binding to Map
         */
        Map<String, String[]> map = request().body().asFormUrlEncoded();
        String[] allCheckedData = map.get("artikli[]"); // get all checked question

        List<Integer> ids = new ArrayList();
        for (String t : allCheckedData) {
            Logger.info("Checked data is " + t);
            ids.add(Integer.parseInt(t));
        } 

        List<Artikli> art = Artikli.find.where().idIn(ids).findList();

        for(Artikli a : art)
            Logger.warn(a.naziv);

        //for (Map.Entry<String, String[]> entry : map.entrySet()) {
            //String key = entry.getKey();
            //String[] value = entry.getValue();
            //if(!value[0].equals("0"))
            //Logger.warn(key + " - " + value[0]);
        //}

        //DynamicForm dform = form().bindFromRequest();
        //Map<String,String> mapa = dform.data();
        //for(String key : mapa.keySet()){
            //Logger.warn("key: " + key);
        //}
        //for(String key : mapa.values())
            //Logger.warn("values: " + key);

        //List<String> l = form.bindFromRequest();
        //DynamicForm dform = form().bindFromRequest();
        //if(dform.get("artikli") != null){
            //List<String> first = (List<String>) dform.get("artikli");
            //Logger.info("checkboxs: " + first.size());
        //}
            //Logger.info("checkboxs: " + l.size());

            //Logger.info("checkboxs: empty");

            //Set<String> keys = request().body().asFormUrlEncoded().keySet();
//for (String key : keys) {
     // check if key begin with "param["
            //Logger.info("checkboxs: " + key);
            //Logger.info("kv: " + key.value());
//}
            return ok(izbiraKolicin.render(art));
    }
    //// -- Projects

    /**
     * Add a project.
     */
    //public static Result add() {
        //Project newProject = Project.create(
            //"New project", 
            //form().bindFromRequest().get("group"),
            //request().username()
        //);
        //return ok(item.render(newProject));
    //}
    
    /**
     * Rename a project.
     */
    //public static Result rename(Long project) {
        //if(Secured.isMemberOf(project)) {
            //return ok(
                //Project.rename(
                    //project, 
                    //form().bindFromRequest().get("name")
                //)
            //);
        //} else {
            //return forbidden();
        //}
    //}
    
    /**
     * Delete a project.
     */
    //public static Result delete(Long project) {
        //if(Secured.isMemberOf(project)) {
            //Project.find.ref(project).delete();
            //return ok();
        //} else {
            //return forbidden();
        //}
    //}

    //// -- Project groups

    /**
     * Add a new project group.
     */
    //public static Result addGroup() {
        //return ok(
            //group.render("New group", new ArrayList<Project>())
        //);
    //}
  
    /**
     * Delete a project group.
     */
    //public static Result deleteGroup(String group) {
        //Project.deleteInFolder(group);
        //return ok();
    //}
  
    /**
     * Rename a project group.
     */
    //public static Result renameGroup(String group) {
        //return ok(
            //Project.renameFolder(group, form().bindFromRequest().get("name"))
        //);
    //}
  
    //// -- Members
  
    /**
     * Add a project member.
     */
    //public static Result addUser(Long project) {
        //if(Secured.isMemberOf(project)) {
            //Project.addMember(
                //project,
                //form().bindFromRequest().get("user")
            //);
            //return ok();
        //} else {
            //return forbidden();
        //}
    //}
  
    /**
     * Remove a project member.
     */
    //public static Result removeUser(Long project) {
        //if(Secured.isMemberOf(project)) {
            //Project.removeMember(
                //project,
                //form().bindFromRequest().get("user")
            //);
            //return ok();
        //} else {
            //return forbidden();
        //}
    //}
  
}

