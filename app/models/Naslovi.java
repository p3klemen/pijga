package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints.*;
import com.avaje.ebean.*;
import java.util.*;
@Entity
public class Naslovi extends Model{
    @Id
    public Integer naslovi_id;
    @Required
    public String naslov;
    @Required
    public String kraj;
    @Required
    public String postna;
    public String geo;

    //@Required
    //@ManyToOne
    //@JoinColumn(name="zaloge_id")
    //public Zaloge zaloge;

    public static Finder<Integer, Naslovi> find = new
            Finder<Integer, Naslovi>(Integer.class, Naslovi.class);
}
