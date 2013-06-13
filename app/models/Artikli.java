package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints.*;
import com.avaje.ebean.*;
import java.util.*;
import org.joda.time.*;
@Entity
public class Artikli extends Model{
    @Id
    public Integer artikli_id;
    @Required
    public String naziv;
    @Required
    public String proizvajalec;
    @Required
    public Double cena;
    @Required
    @ManyToOne
    @JoinColumn(name="vrste_id")
    public Vrste vrsta;

    @OneToMany(mappedBy="artikel")
    public List<Cene> cene;
    
    public static Finder<Integer, Artikli> find = new
            Finder<Integer, Artikli>(Integer.class, Artikli.class);

    //vrne hashmap [vrsta -> lista artiklov]
    public static Map<String,List<Artikli>> getMapByVrste(){
        Map<String, List<Artikli>> options = new HashMap();
        
        for(Vrste v : Vrste.find.all()){
            options.put(v.vrsta, getListByVrste(v.vrste_id));
        }
        return options;
    }

    public static List<Artikli> getListByVrste(int v){
        return find.where().eq("vrsta.vrste_id", v).findList();
    }

    public String toString() {
        return "Artikel: " + artikli_id + " " + proizvajalec + " "+ naziv + " "+ cena + " " + vrsta.vrsta;
    }
}
