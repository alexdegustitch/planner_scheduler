package bentiteti;

import java.sql.Date;
import java.sql.Time;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-17T03:43:39")
@StaticMetamodel(Alarm.class)
public class Alarm_ { 

    public static volatile SingularAttribute<Alarm, Date> datum;
    public static volatile SingularAttribute<Alarm, Time> vreme;
    public static volatile SingularAttribute<Alarm, Integer> id;
    public static volatile SingularAttribute<Alarm, Boolean> periodicno;
    public static volatile SingularAttribute<Alarm, Boolean> navijen;

}