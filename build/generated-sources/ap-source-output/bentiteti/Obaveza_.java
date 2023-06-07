package bentiteti;

import bentiteti.Destinacija;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-17T03:35:08")
@StaticMetamodel(Obaveza.class)
public class Obaveza_ { 

    public static volatile SingularAttribute<Obaveza, Date> datum;
    public static volatile SingularAttribute<Obaveza, Date> pocetnoVreme;
    public static volatile SingularAttribute<Obaveza, Integer> trajanje;
    public static volatile SingularAttribute<Obaveza, String> naziv;
    public static volatile SingularAttribute<Obaveza, Destinacija> destinacija;
    public static volatile SingularAttribute<Obaveza, Integer> id;

}