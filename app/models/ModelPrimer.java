package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints.*;

public class ModelPrimer extends Model{
    @Id
    public String id;

    @Required
    public String content;

    public static Finder<String,ModelPrimer> find = new
            Finder<String,ModelPrimer>(String.class,ModelPrimer.class);
}
