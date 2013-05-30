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
    public String ddvst;
    @Required
    public Integer stevilo_mest;

    @ManyToOne
    @JoinColumn(name="naslovi_id")
    public Naslovi naslov;

    @OneToMany(mappedBy="bar")
    public List<Akcije> akcije;
    @OneToMany(mappedBy="bar")
    public List<Racuni> racuni;
    @OneToMany(mappedBy="bar")
    public List<Osebe> osebe;

    public static Finder<Integer, Bari> find = new
            Finder<Integer, Bari>(Integer.class, Bari.class);
}
