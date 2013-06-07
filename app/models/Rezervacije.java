package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints.*;
import com.avaje.ebean.*;
import java.util.*;
import org.joda.time.*;
@Entity
public class Rezervacije extends Model{
    @Id
    public Integer rezervacije_id;
    @Required
    public LocalDate datum;
    @Required
    public LocalTime ura;
    @Required
    public Integer stevilo;

    @Required
    @ManyToOne
    @JoinColumn(name="bari_id")
    public Bari bar;
    @Required
    @ManyToOne
    @JoinColumn(name="osebe_id")
    public Osebe oseba;
    //@Required
    //@ManyToOne
    //@JoinColumn(name="zaloge_id")
    //public Zaloge zaloge;

    public static Finder<Integer, Rezervacije> find = new
            Finder<Integer, Rezervacije>(Integer.class, Rezervacije.class);

    public String toString(){
        return "Rezervacija: " + datum + " " + ura + " " + stevilo;
    }
}
