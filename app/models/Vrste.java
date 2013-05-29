package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints.*;
import com.avaje.ebean.*;
@Entity
public class Vrste extends Model{
    @Id
    public Integer vrste_id;
    @Required
    public String vrsta;
    @Required
    @ManyToOne
    @JoinColumn(name="davki_id")
    public Davki davek;

    public static Finder<Integer, Vrste> find = new
            Finder<Integer, Vrste>(Integer.class, Vrste.class);
}
