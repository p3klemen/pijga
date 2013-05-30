package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints.*;
import com.avaje.ebean.*;
@Entity
public class Sistemi extends Model{
    @Id
    public Integer sistemi_id;
    @Required
    public String mac;
    @Required
    @ManyToOne
    @JoinColumn(name="bari_id")
    public Bari bar;

    public static Finder<Integer, Sistemi> find = new
            Finder<Integer, Sistemi>(Integer.class, Sistemi.class);
}
