package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints.*;
import com.avaje.ebean.*;
import java.util.*;
@Entity
public class Osebe extends Model{
    @Id
    public Integer osebe_id;
    @Required
    public String ime;
    @Required
    public String priimek;
    @Required
    public String email;
    @Required
    public String geslo;
    @Required
    public String telefon;
    @Required
    public String status;

    @ManyToOne
    @JoinColumn(name="naslovi_id")
    public Naslovi naslov;
    @ManyToOne
    @JoinColumn(name="bari_id")
    public Bari bar;

    @OneToMany(mappedBy="oseba")
    public List<Racuni> racuni;
    @OneToMany(mappedBy="oseba")
    public List<Izmene> izmene;

    public static Finder<Integer, Osebe> find = new
            Finder<Integer, Osebe>(Integer.class, Osebe.class);
}
