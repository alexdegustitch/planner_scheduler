/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarm;
import bentiteti.*;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.emptyType;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;


/**
 *
 * @author uSER
 */
public class AlarmUredjaj {
   
    private int dan, godina, mesec, sekunda, min, sat;
    
    private String izvodjac, nazivPesme; 
    
    public void navijAlarm(Time time){
        
        Date datum=new Date();
       
        dan = datum.getDate();
        godina = datum.getYear();
        mesec = datum.getMonth();
        sekunda=datum.getSeconds();
        min=datum.getMinutes();
        sat= datum.getHours();
        
        if(time.getHours()<sat)
            dodajDan();
        else if(time.getHours()==sat && time.getMinutes()<min)
                dodajDan();
        else if(time.getHours()==sat && time.getMinutes()==min && time.getSeconds()<sekunda)
                dodajDan();
            
        java.sql.Date date = new java.sql.Date(godina, mesec, dan);
        
        bentiteti.Alarm alarm = new bentiteti.Alarm();
        alarm.setDatum(date);
        alarm.setVreme(time);
        alarm.setNavijen(true);
        alarm.setPeriodican(false);
  
        AlarmMain.em.getTransaction().begin();
        AlarmMain.em.persist(alarm);
        AlarmMain.em.getTransaction().commit();
        
     
        System.out.println(dan + "." + mesec + "." + godina+ "   " + sat + ":" + min + ":" + sekunda);
        
 
    }
    
    public void ponudjeniTrenuci(){
        TypedQuery<bentiteti.Alarm> query = AlarmMain.em.createQuery("SELECT DISTINCT a "
                + "FROM Alarm a "
                + "ORDER BY a.vreme", bentiteti.Alarm.class);
        List<bentiteti.Alarm> list = query.getResultList();
        
        for (bentiteti.Alarm alarm : list) {
            System.out.println(alarm.getVreme());
        }
    }
    
    private void podesiZvono(String izvo, String naziv){
        izvodjac = izvo;
        nazivPesme = naziv;
    }
    
    public String getIzvodjac(){
        return izvodjac;
    }
    
    public String getNazivPesme(){
        return nazivPesme;
    }
    
    public void navijPeriodicneAlarme(Time time){
        
        bentiteti.Alarm alarm = new bentiteti.Alarm();
      
        alarm.setVreme(time);
        alarm.setNavijen(false);
        alarm.setPeriodican(true);
  
        AlarmMain.em.getTransaction().begin();
        AlarmMain.em.persist(alarm);
        AlarmMain.em.getTransaction().commit();
    }
    private void dodajDan(){
        if(dan++>=dohvatiBrojDana()) {
            dan=1;
	if(mesec++>=11) {
            mesec=0;
            godina++;							
             }
        }                                                 
    }
    
    private int dohvatiBrojDana(){
        switch(mesec) {
		case 0: return 31;
		case 1: if(isLeep()) return 29; else return 28;
		case 2: return 31;
		case 3: return 30;
		case 4: return 31;
		case 5: return 30;
		case 6: return 31;
		case 7: return 31;
		case 8: return 30;
		case 9: return 31;
		case 10: return 30;
		case 11: return 31;
		}
		
		return 0;
    }
    
    private boolean isLeep(){
	  
    if((godina+1900) % 4 == 0) {
        if( (godina+1900) % 100 == 0) {
	   if ( (godina+1900) % 400 == 0)
	                    return true;
	                else
	                    return false;
	            }
	            else
	                 return true;
	        }
	        else
	            return false;	               
    }            
            
}
