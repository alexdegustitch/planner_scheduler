package bentiteti;

import bentiteti.Obaveza;
import bentiteti.Pesma;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-17T03:02:43")
@StaticMetamodel(Korisnik.class)
public class Korisnik_ { 

    public static volatile SingularAttribute<Korisnik, String> ime;
    public static volatile ListAttribute<Korisnik, Obaveza> obaveze;
    public static volatile SingularAttribute<Korisnik, Integer> id;
    public static volatile SingularAttribute<Korisnik, String> prezima;
    public static volatile SingularAttribute<Korisnik, String> godina;
    public static volatile ListAttribute<Korisnik, Pesma> pesme;

}