package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints.*;
import com.avaje.ebean.*;
import org.joda.time.*;

@Entity
public class Porabe extends Model{
    @Id
    public Integer porabe_id;
    @Required
    public Integer stevilo;
    @Required
    public LocalDate datum;


    @Required
    @ManyToOne
    @JoinColumn(name="bari_id")
    public Bari bar;
    @Required
    @ManyToOne
    @JoinColumn(name="artikli_id")
    public Artikli artikel;

    public static Finder<Integer, Porabe> find = new
            Finder<Integer, Porabe>(Integer.class, Porabe.class);

    public String toString(){
        return "Poraba: " + porabe_id + " " + datum + " " + stevilo + " " + bar.naziv
            + " " + artikel.naziv;
    }
}
