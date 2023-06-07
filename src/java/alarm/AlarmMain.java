/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarm;

import java.sql.Time;
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
public class AlarmMain {

    /**
     * @param args the command line arguments
     */
    
    @Resource(lookup = "jms/__defaultConnectionFactory")
    private static ConnectionFactory conn;
    
    @Resource(lookup = "queue")
    private static Queue queue;
    
    @Resource(lookup = "topic")
    private static Topic topic;
    
    
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projekatPU");
    static EntityManager em = emf.createEntityManager();
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        AlarmUredjaj alarm=new AlarmUredjaj();
        alarm.navijAlarm(new Time(0, 10, 0));
        alarm.navijAlarm(new Time(2, 15, 0));
        alarm.navijAlarm(new Time(0, 29, 0));
        alarm.navijAlarm(new Time(0, 10, 0));
        alarm.navijPeriodicneAlarme(new Time(10, 10, 0));  
        alarm.navijAlarm(new Time(15, 20, 0));
        
        alarm.ponudjeniTrenuci();
        JMSContext context = conn.createContext();     
    }
    
}