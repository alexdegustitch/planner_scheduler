/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reprodukcijazvuka;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.json.JSONException;
import java.security.cert.*;
import java.util.Iterator;



/**
 *
 * @author aleksandar
 */
public class UredjajZvuk {

    /**
     * @param args the command line arguments
     */
    @Resource(lookup = "jms/__defaultConnectionFactory")
    private static ConnectionFactory conn;
    
    @Resource(lookup = "queue")
    private static Queue queue;
    
    @Resource(lookup = "topic")
    private static Topic topic;
       
    
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ReprodukcijaZvukaPU");
    static EntityManager em = emf.createEntityManager();
    
    public static void main(String[] args) throws IOException, URISyntaxException, JSONException, KeyStoreException, NoSuchAlgorithmException, CertificateException, InvalidAlgorithmParameterException {
        // TODO code application logic here
       
    System.setProperty("javax.net.ssl.trustStore","C:/Program Files/Java/jre1.8.0_171/lib/security/cacerts");
    
    
        /*System.setProperty("javax.net.ssl.keyStore", "C:/keystoreFile.jks");
    System.setProperty("javax.net.ssl.keyStorePassword", "mypassword");
    System.setProperty("javax.net.ssl.trustStore", "C:/missing-keystore.jks");
    System.setProperty("javax.net.ssl.trustStorePassword", "mypassword");*/
        
    
        JMSContext context = conn.createContext();
        Zvuk zvuk = new Zvuk();
        zvuk.pustiPesmu("Born To Die", "Lana Del Rey");
       
        
    
    }
}
