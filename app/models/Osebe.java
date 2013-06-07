package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints.*;
import com.avaje.ebean.*;
import java.util.*;
import play.*;
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
    public String kraj;
    @Required
    public String naslov;
    @Required
    public Integer posta;

    public String telefon;
    @Column(nullable = true)
    public String status = "gost";


    @OneToMany(mappedBy="oseba")
    public List<Racuni> racuni;
    @OneToMany(mappedBy="oseba")
    public List<Izmene> izmene;

    public static Finder<Integer, Osebe> find = new
            Finder<Integer, Osebe>(Integer.class, Osebe.class);


    /**
     * Retrieve a Osebe from email.
     */
    public static Osebe findByEmail(String email) {
        return find.where().eq("email", email).findUnique();
    }
    
    /**
     * Authenticate a Osebe.
     */
    public static Osebe authenticate(String email, String password) {
        Logger.info("Osebe: " + email + " " + password);
        return find.where()
            .eq("email", email)
            .eq("geslo", password)
            .findUnique();
    }
    
    
    public String toString() {
        return "Oseba: " + email + " " + status + "";
    }
}
