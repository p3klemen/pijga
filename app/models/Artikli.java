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
    public Double cena;
    @Required
    @ManyToOne
    @JoinColumn(name="vrste_id")
    public Vrste vrsta;

    @ManyToOne
    @JoinColumn(name="zaloge_id")
    public Zaloge zaloga;

    @OneToMany(mappedBy="artikel")
    public List<Cene> cene;

    public static Finder<Integer, Artikli> find = new
            Finder<Integer, Artikli>(Integer.class, Artikli.class);
}
