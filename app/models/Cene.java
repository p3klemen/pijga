package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints.*;
import com.avaje.ebean.*;
import java.util.*;
import org.joda.time.*;

@Entity
public class Cene extends Model{
    @Id
    public Integer cene_id;
    @Required
    public Double cena;
    @Required
    public Integer kolicina;

    @ManyToOne
    @JoinColumn(name="artikli_id")
    public Artikli artikel;
    @ManyToOne
    @JoinColumn(name="racuni_id")
    public Racuni racun;


    public static Finder<Integer, Cene> find = new
            Finder<Integer, Cene>(Integer.class, Cene.class);
}
