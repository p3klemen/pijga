package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints.*;
import com.avaje.ebean.*;
import java.util.*;
import org.joda.time.*;
@Entity
public class Izmene extends Model{
    @Id
    public Integer izmene_id;
    @Required
    public LocalDate datum;
    @Required
    public LocalTime ura_prijave;
    @Required
    public LocalTime ura_odjave;

    @ManyToOne
    @JoinColumn(name="oseba_id")
    public Osebe oseba;
    @ManyToOne
    @JoinColumn(name="bari_id")
    public Bari bar;

    public static Finder<Integer, Izmene> find = new
            Finder<Integer, Izmene>(Integer.class, Izmene.class);

    public String toString(){
        return "Izmena: " + izmene_id + " " + datum + " " + ura_prijave + " " 
            + ura_odjave + " " + bar.naziv + " " + oseba.ime;
    }
}
