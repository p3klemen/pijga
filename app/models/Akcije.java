package models;
import play.db.ebean.*;
import play.data.format.*;
import javax.persistence.*;
import play.data.validation.Constraints.*;
import com.avaje.ebean.*;
import java.util.*;
import org.joda.time.*;
@Entity
public class Akcije extends Model{
    @Id
    public Integer akcije_id;
    @Required
    public String naziv;
    public String opis;
    @Required
    public LocalDate datum_zacetka;
    @Required
    public LocalDate datum_konca;
    @Required
    public Double popust;

    @ManyToOne
    @JoinColumn(name="artikli_id")
    public Artikli artikel;
    @ManyToOne
    @JoinColumn(name="bari_id")
    public Bari bar;

    public static Finder<Integer, Akcije> find = new
            Finder<Integer, Akcije>(Integer.class, Akcije.class);

    public String toString(){
        return "Akcija: " + naziv + " " + datum_zacetka + " " + datum_konca + " " + popust;
    }
}
