package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints.*;
import com.avaje.ebean.*;
@Entity
public class Zaloge extends Model{
    @Id
    public Integer zaloge_id;
    @Required
    public Integer stevilo;
    @Required
    @ManyToOne
    @JoinColumn(name="bari_id")
    public Bari bar;
    @ManyToOne
    @JoinColumn(name="artikli_id")
    public Artikli artikel;

    public static Finder<Integer, Zaloge> find = new
            Finder<Integer, Zaloge>(Integer.class, Zaloge.class);
}
