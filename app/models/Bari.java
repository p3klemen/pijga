package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints.*;
import com.avaje.ebean.*;
import java.util.*;

@Entity
public class Bari extends Model{
    @Id
    public Integer bari_id;
    @Required
    public String naziv;
    @Required
    public String geo;
    @Required
    public String kraj;
    @Required
    public String naslov;
    @Required
    public String davcna;
    @Required
    public Integer posta;
    @Required
    public Integer stevilo_mest;


    @OneToMany(mappedBy="bar")
    public List<Akcije> akcije;
    @OneToMany(mappedBy="bar")
    public List<Racuni> racuni;

    public static Finder<Integer, Bari> find = new
            Finder<Integer, Bari>(Integer.class, Bari.class);

    public String toString() {
        return "Bar: " + bari_id + " " + naziv + " "+ naslov + " "+ kraj + " " + stevilo_mest;
    }
}
