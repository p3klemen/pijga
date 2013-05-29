package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints.*;
import com.avaje.ebean.*;
import java.util.*;
import org.joda.time.*;
@Entity
public class Racuni extends Model{
    @Id
    public Integer racuni_id;
    @Required
    public LocalDate datum;
    @Required
    public LocalTime ura;
    @Required
    public Double znesek;

    @ManyToOne
    @JoinColumn(name="bari_id")
    public Bari bar;

    @OneToMany(mappedBy="racun")
    public List<Cene> cene;

    @ManyToOne
    @JoinColumn(name="osebe_id")
    public Osebe oseba;

    public static Finder<Integer, Racuni> find = new
            Finder<Integer, Racuni>(Integer.class, Racuni.class);
}
