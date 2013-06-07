package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints.*;
import com.avaje.ebean.*;
import java.util.*;
@Entity
public class Vrste extends Model{
    @Id
    public Integer vrste_id;
    @Required
    public String vrsta;

    @Required
    @ManyToOne
    @JoinColumn(name="davki_id")
    public Davki davek;

    public static Finder<Integer, Vrste> find = new
            Finder<Integer, Vrste>(Integer.class, Vrste.class);

    //generira mapo id->davek za @select helper
    public static HashMap<String,String> getOptions(){
    HashMap<String, String> options = new HashMap<String, String>();
        for(models.Davki d : models.Davki.find.all()){
            options.put(d.davki_id.toString(), d.davek.toString());
        }
        return options;
    }

    public String toString() {
        return "Vrsta: " + vrste_id + " " + vrsta + " "+ davek.davek;
    }
}
