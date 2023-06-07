/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author uSER
 */
public class Planer {

    /**
     * @param args the command line arguments
     */
    
    @Resource(lookup = "jms/__defaultConnectionFactory")
    private static ConnectionFactory conn;
    
    @Resource(lookup = "queue")
    private static Queue queue;
    
    @Resource(lookup = "topic")
    private static Topic topic;
    
    public static void main(String[] args) throws IOException, MalformedURLException, Exception {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PlanerPU");
        EntityManager em = emf.createEntityManager();
        
       // JMSContext context=conn.createContext();
        /*
        Kalkulator k = new Kalkulator();
        String[] a = new String[2];
        a = k.izracunajAB("Milana Rakica 5 Beograd", "Bulevar Oslobodjenja 12 Beograd");
        
        System.out.println("Kilometraza: " + a[0] + "  Vreme: " + a[1]);
        
        String[] a1 = new String[2];
        String[] a2 = new String[2];
        
        a1 = Kalkulator.geocoding("Milana Rakica 4");
        a2 = Kalkulator.geocoding("Bulevar Kralja Aleksandra 132");
        String[] a3 = Kalkulator.calculateDistance(a2, a1);
        
        System.out.println(a3[0] + "   " + a3[1]);*/
        
          String a1[]=new String[2];
        String a2[]=new String[2];
        String a3[]=new String[2];
        Scanner sc=new Scanner(System.in);
        int i=0;
        while(true){
        
        System.out.println("Uneti prvu adresu: ");
        
        String addr1=sc.nextLine();
        System.out.println("Uneti drugu adresu: ");
        String addr2=sc.nextLine();
        a1=Kalkulator.geocoding(addr1);
        a2=Kalkulator.geocoding(addr2);
       // a2=Kalkulator.geocoding(addr1);
        a3=Kalkulator.calculateDistance(a1, a2);
       // System.out.println("");
        System.out.println("");
       // System.out.println("");
       // System.out.println("");
       // System.out.println("");
       // System.out.println("");
        
        System.out.println("Udaljenost izmedju ove dve lokacije je: " + a3[0] + ", a vreme potrebno da se stigne kolima je: " + a3[1]);
       
        System.out.println("");
        System.out.println("");
            
        }
        
    }
    
}
