package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints.*;
import com.avaje.ebean.*;
import java.util.List;
@Entity
public class Davki extends Model{
    @Id
    public Integer davki_id;

    @Required
    @Min(0)
    @Max(value=100)
    public Double davek;

    public static Finder<Integer, Davki> find = new
            Finder<Integer, Davki>(Integer.class, Davki.class);


    public String toString() {
        return "Davek: " + davek;
    }
}
