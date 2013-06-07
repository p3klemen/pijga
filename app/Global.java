import play.*;

import play.data.format.Formatters.SimpleFormatter;
import play.data.format.Formatters;
import org.joda.time.format.DateTimeFormat;
import java.util.regex.*;
import java.text.ParseException;
import org.joda.time.*;
import java.util.*;
public class Global extends GlobalSettings {

  @Override
  public void onStart(Application app) {
    Logger.info("Application has started");
    
        Formatters.register(LocalTime.class, new SimpleFormatter<LocalTime>() {
            //private Pattern timePattern = Pattern.compile(
                //"([012]?\\\\d)(?:[\\\\s:\\\\._\\\\-]+([0-5]\\\\d))?"
            //); 
            
            @Override
            public LocalTime parse(String input, Locale l) throws ParseException {
                //Matcher m = timePattern.matcher(input);
                //if (!m.find()) throw new ParseException("No valid Input",0);
                //int hour = Integer.valueOf(m.group(1));
                //int min = m.group(2) == null ? 0 : Integer.valueOf(m.group(2));
                LocalTime lt = LocalTime.parse(input);
                //return new LocalTime(hour, min);
                return lt;
            }
            
            @Override
            public String print(LocalTime localTime, Locale l) {
                return localTime.toString("HH:mm");
            }
        });
        Formatters.register(LocalDate.class, new SimpleFormatter<LocalDate>() {
            private Pattern timePattern = Pattern.compile(
                "/^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$/"
            ); 
            
            @Override
            public LocalDate parse(String input, Locale l) throws ParseException {
                //Matcher m = timePattern.matcher(input);
                //if (!m.find()) throw new ParseException("No valid Input",0);
                //LocalDate ld = new LocalDate();
                Logger.warn("localdate: " + input);
                LocalDate ld = LocalDate.parse(input, DateTimeFormat.forPattern("dd/MM/yyyy"));
                //LocalDate ld = LocalDate.parse(input);
                Logger.warn("localdate: parsal" + ld.toString());
                return ld;
            }
            
            @Override
            public String print(LocalDate localTime, Locale l) {
                return localTime.toString();
            }
        });
  }  
  
  @Override
  public void onStop(Application app) {
    Logger.info("Application shutdown...");
  }  
    
}
