/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package korisnickiuredjaj;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Border;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.swing.JList;

/**
 *
 * @author uSER
 */

public class UredjajKorisnik extends Frame {

    /**
     * @param args the command line arguments
     */
    
    @Resource(lookup = "jms/__defaultConnectionFactory")
    private static ConnectionFactory conn;
    
    @Resource(lookup = "queue")
    private static Queue queue;
    
    @Resource(lookup = "topic")
    private static Topic topic;
    
    
    
    private TextField alarm, zvonoPesma, zvonoIzvodjac;
    private Label alarmL, zvonoLPesma, periodicanL, zvonoLIzvodjac, listaL;
    private Checkbox periodican;
    private Choice listaTrenuci;
    private Label natpisAlarm;
    private Button krajAlarm;
    Panel panel = new Panel(new BorderLayout());
    private Panel panelDesni = new Panel(new BorderLayout());
    private Panel panelLevi = new Panel(new BorderLayout());
    
    public UredjajKorisnik(){
        super("Pametna Kuca");
        setSize(950, 665);
        
        popuniAlarm();
        popuniObaveza();
        popuniMuzika();
        popuniKalkulator();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
               dispose();
            }
     });
        
        setVisible(true);
    }
    
    private void popuniAlarm(){
        Panel podPanelAlarm = new Panel(new GridLayout(6, 2));
        alarmL = new Label("Uneti vreme:");
        alarm = new TextField();
       // periodicanL = new Label("Da li je periodican?");
        periodican  = new Checkbox("periodican");
        zvonoLPesma = new Label("Uneti naziv pesme:");
        zvonoPesma = new TextField();
        zvonoLIzvodjac = new Label("Uneti ime izvodjaca:");
        zvonoIzvodjac = new TextField();
        listaL = new Label("Izaberi:");
        listaTrenuci = new Choice();
        listaTrenuci.enable(true);
        krajAlarm = new Button("Potvrdi");
        
        Panel vremePanel = new Panel();
        Choice sat, minut, sekunda;
        sat = new Choice();
        for(int i=0;i<24;i++)
            sat.add(Integer.toString(i));
        minut = new Choice();
        for(int i=0;i<60;i++)
            minut.add(Integer.toString(i));
        
        sekunda = new Choice();
        for(int i=0;i<60;i++)
            sekunda.add(Integer.toString(i));
        
        vremePanel.add(alarmL);
        vremePanel.add(sat);
        vremePanel.add(minut); 
        vremePanel.add(sekunda);
        
        //podPanelAlarm.add(alarmL);
        //podPanelAlarm.add(vremePanel);
        podPanelAlarm.add(new Label());
        podPanelAlarm.add(periodican);
        podPanelAlarm.add(listaL);
        podPanelAlarm.add(listaTrenuci);
        podPanelAlarm.add(zvonoLPesma);
        podPanelAlarm.add(zvonoPesma);
        podPanelAlarm.add(zvonoLIzvodjac);
        podPanelAlarm.add(zvonoIzvodjac);
        podPanelAlarm.add(new Label());
        podPanelAlarm.add(krajAlarm);
        
        Panel iznad = new Panel(new BorderLayout());
        iznad.add(vremePanel, "North");
        iznad.add(podPanelAlarm, "Center");
        natpisAlarm = new Label("Alarm");
        //natpisAlarm.setFont(new Font(null, 20, Font.BOLD));
        natpisAlarm.setForeground(Color.RED);
        panelLevi.add(iznad, "South");
        panelLevi.add(natpisAlarm, "North");
       // panelLevi.setBackground(Color.LIGHT_GRAY);
       
        panel.add(panelLevi, "North");
        add(panel, "West");
        
    }
    private void popuniKalkulator(){
        Label naslov = new Label("Kalkulator razdaljine");
        //naslov.setFont(new Font(null, 20, Font.BOLD));
        naslov.setForeground(Color.RED);
        Label naslov1 = new Label("Odredjivanje razdaljine izmedju dve lokacije");
        Label naslov2 = new Label("Odredjivanje razdaljine izmedju trenutne i zadate lokacije");
        Label lokAL = new Label("Uneti adresu prve lokacije:");
        Label lokBL = new Label("Uneti adresu druge lokacije:");
        Label lokL = new Label("Uneti lokaciju:");
        
        TextField lokA = new TextField();
        TextField lokB = new TextField();
        TextField lok = new TextField();
        
        Button trenutna = new Button("trenutna lokacija");
        
        TextField trenutnaTekst = new TextField();
        trenutnaTekst.setEditable(false);
        
        Panel panelGore = new Panel(new GridLayout(6, 2));
        Panel panelDole = new Panel(new GridLayout(6, 2));
        
        panelGore.add(naslov);
        panelGore.add(new Label());
        panelGore.add(naslov1);
        panelGore.add(new Label());
        panelGore.add(lokAL);
        panelGore.add(lokA);
        panelGore.add(lokBL);
        panelGore.add(lokB);
        Panel razdaljina1 = new Panel();
        panelGore.add(razdaljina1);
        Panel vreme1 = new Panel();
        panelGore.add(vreme1);
        Label duzinaL1 = new Label("razdaljina:");
        TextField duzina1 = new TextField();
        duzina1.setColumns(6);
        duzina1.setEditable(false);
        razdaljina1.add(duzinaL1);
        razdaljina1.add(duzina1);
        
        Label vremeL1 = new Label("vreme:");
        TextField vremeT1 = new TextField();
        vremeT1.setColumns(6);
        vremeT1.setEditable(false);
        vreme1.add(vremeL1);
        vreme1.add(vremeT1);
        
        Button izracunaj1 = new Button("izracunaj");
        panelGore.add(new Label());
        panelGore.add(izracunaj1);
        
        panelDole.add(naslov2);
        panelDole.add(new Label());
        Button trenutnaL = new Button("trenutna lokacija");
        panelDole.add(trenutnaL);
        TextField trenutnaTL = new TextField();
        trenutnaTL.setEditable(false);
        panelDole.add(trenutnaTL);
        panelDole.add(lokL);
        panelDole.add(lok);
        
        Panel razdaljina2 = new Panel();
        panelDole.add(razdaljina2);
        Panel vreme2 = new Panel();
        panelDole.add(vreme2);
        Label duzinaL2 = new Label("razdaljina:");
        TextField duzina2 = new TextField();
        duzina2.setEditable(false);
        duzina2.setColumns(6);
        razdaljina2.add(duzinaL2);
        razdaljina2.add(duzina2);
        
        Label vremeL2 = new Label("vreme:");
        TextField vremeT2 = new TextField();
        vremeT2.setEditable(false);
        vremeT2.setColumns(6);
        vreme2.add(vremeL2);
        vreme2.add(vremeT2);
        
        Button izracunaj2 = new Button("izracunaj");
        panelDole.add(new Label());
        panelDole.add(izracunaj2);
        
        
        Panel panelKraj = new Panel(new BorderLayout());
        panelKraj.add(panelGore, "North");
        panelKraj.add(panelDole, "South");
        panelDesni.add(panelKraj, "South");
        
    }
    private void popuniMuzika(){
        Label naslov = new Label("Muzika");
        //naslov.setFont(new Font(null, 20, Font.BOLD));
        naslov.setForeground(Color.RED);
        Label nazivL = new Label("unesi naziv pesme:");
        TextField naziv = new TextField();
        TextField izvodjac = new TextField();
        Label izvodjacL = new Label("unesi naziv izvodjaca:");
        Button reprodukuj = new Button("reprodukuj pesmu");
        Label informacije = new Label("Informacije o pesmi");
        informacije.setForeground(Color.RED);
        Button posaljiPesme = new Button("prikazi pesme");
        List svePesme = new List();
       
        Panel panelGore = new Panel(new GridLayout(0, 1));
        panelGore.add(naslov);
        panelGore.add(informacije);
        Panel pesma = new Panel(new GridLayout(4, 2));

        pesma.add(naslov);
        pesma.add(new Label());
        pesma.add(nazivL);
        pesma.add(naziv);
        pesma.add(izvodjacL);
        pesma.add(izvodjac);
        pesma.add(new Label());
        pesma.add(reprodukuj);
        
        //panelGore.add(pesma);
        
        Panel pesme = new Panel(new BorderLayout());
        Panel zaDugme = new Panel(new GridLayout(1, 2));
        zaDugme.add(new Label());
        zaDugme.add(posaljiPesme);
        pesme.add(zaDugme, "North");
        pesme.add(svePesme, "Center");
        
        Panel krajnji= new Panel(new BorderLayout());
        krajnji.add(pesma, "North");
        krajnji.add(pesme, "Center");
        panel.add(krajnji, "South");
        
        
        
    }
    private void popuniObaveza(){
        Panel podObaveza = new Panel(new BorderLayout());
        Panel natpis = new Panel(new GridLayout(1,1));
       
        Label natpisObaveza = new Label("Obaveza");
        natpisObaveza.setForeground(Color.RED);
        Panel destinacijaPanel = new Panel();
        natpis.add(natpisObaveza);
        Label destL = new Label("Uneti obavezu sa destinacijom");
        Checkbox destinacija = new Checkbox();
        destinacijaPanel.add(destL);
        destinacijaPanel.add(destinacija);
        Button dodajObavezu = new Button("Dodaj obavezu");
        
        dodajObavezu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new ProzorDestinacija().setVisible(true);
               
            }
        });
        
        Label natpisPregled = new Label("Pregled obaveza");
        natpisPregled.setForeground(Color.RED);
        
        Panel obavezePomoc = new Panel(new BorderLayout());
        obavezePomoc.add(natpisPregled, "North");
        Panel izlistavanjeObaveza = new Panel(new BorderLayout());
       
        Label datum  = new Label("Izaberi datum:");
        Panel datumPanel = new Panel();
        Choice dan, mesec, godina;
        dan = new Choice();
        for(int i=1;i<32;i++)
            dan.add(Integer.toString(i));
        mesec = new Choice();
        for(int i=1;i<13;i++)
            mesec.add(Integer.toString(i));
        godina = new Choice();
        godina.add("2018");
        godina.add("2019");
        godina.add("2020");
        datumPanel.add(datum);
        datumPanel.add(dan);
        datumPanel.add(mesec);
        datumPanel.add(godina);
        Button prikazi = new Button("prikazi obaveze");
        datumPanel.add(prikazi);
        izlistavanjeObaveza.add(datumPanel, "North");
        
        
        
        List obaveze = new List();
        
        izlistavanjeObaveza.add(obaveze, "Center");
        obavezePomoc.add(izlistavanjeObaveza, "Center");
        Button promeniObavezu = new Button("Promeni obavezu");
        Button izbrisiObavezu = new Button("Izbrisi obavezu");
        
        Panel podObaveza1 = new Panel(new GridLayout(1, 2));
        Panel podObaveza2 = new Panel(new GridLayout(1, 2));
        podObaveza1.add(destinacijaPanel);
        podObaveza1.add(dodajObavezu);
        podObaveza2.add(promeniObavezu);
        podObaveza2.add(izbrisiObavezu);
        podObaveza.add(podObaveza1, "North");
        podObaveza.add(podObaveza2, "South");  
        podObaveza.add(obavezePomoc, "Center");
        
        Panel krajni = new Panel(new BorderLayout());
        krajni.add(podObaveza, "Center");
        krajni.add(natpis, "North");
        panelDesni.add(krajni, "North");
        add(panelDesni, "East");
        
        
    }
    
    public class ProzorDestinacija extends Frame {
    
    private TextField datum, vreme;
    private Label datumL, vremeL;
    private TextField adresa, grad, drzava, naziv;
    private Label adresaL, gradL, drzavaL, nazivL;
    private Label destinacija;
    
    public ProzorDestinacija(){
        super("Dodavanje Destinacije");
        setBounds(400, 300, 400, 300);
        setSize(300, 300);
        
        popuniProzore();
        addWindowListener(new WindowAdapter() {
            @Override
	    public void windowClosing(WindowEvent e) {
		dispose();
	    }
	});
        setVisible(true);
    }
    
    private void popuniProzore(){
        Panel panelGore = new Panel(new GridLayout(3, 1));
        

        
        add(panelGore, "North");
        
        Panel datumPanel = new Panel();
        Label natpisDatum = new Label("Datum:");
        Choice dan, mesec, godina, sat, minut, sekunda;
        dan = new Choice();
        for(int i=1;i<32;i++)
            dan.add(Integer.toString(i));
        mesec = new Choice();
        for(int i=1;i<13;i++)
            mesec.add(Integer.toString(i));
        godina = new Choice();
        godina.add("2018");
        godina.add("2019");
        godina.add("2020");
        datumPanel.add(natpisDatum);
        datumPanel.add(dan);
        datumPanel.add(mesec);
        datumPanel.add(godina);
        //Panel panelDole = new Panel(new GridLayout(4, 2));
        Panel vremePanel = new Panel();
        Label natpisVreme = new Label("Vreme:");
        sat = new Choice();
        for(int i=0;i<24;i++)
            sat.add(Integer.toString(i));
        minut = new Choice();
        for(int i=0;i<60;i++)
            minut.add(Integer.toString(i));
        
        sekunda = new Choice();
        for(int i=0;i<60;i++)
            sekunda.add(Integer.toString(i));
        
        vremePanel.add(natpisVreme);
        vremePanel.add(sat);
        vremePanel.add(minut); 
        vremePanel.add(sekunda);
        
        Label trajanjeL = new Label("trajanje");
        TextField trajanje = new TextField();
        trajanje.setColumns(3);
        Label min = new Label("[min]");
        
        Panel trajanjePanel = new Panel();
        trajanjePanel.add(trajanjeL);
        trajanjePanel.add(trajanje);
        trajanjePanel.add(min);
        
        panelGore.add(datumPanel);
        panelGore.add(vremePanel);
        panelGore.add(trajanjePanel);
        
        Button potvrdi = new Button("potvrdi");
        Panel panelDole = new Panel(new GridLayout(5, 2));
        
        adresaL = new Label("adresa:");
        adresa = new TextField();
        gradL = new Label("grad:");
        grad = new TextField();
        drzavaL = new Label("drzava:");
        drzava = new TextField();
        nazivL = new Label("naziv:");
        naziv = new TextField();
        
        Panel panel = new Panel(new BorderLayout());
        panelDole.add(adresaL);
        panelDole.add(adresa);
        panelDole.add(gradL);
        panelDole.add(grad);
        panelDole.add(drzavaL);
        panelDole.add(drzava);
        panelDole.add(nazivL);
        panelDole.add(naziv);
        panelDole.add(new Label());
        panelDole.add(potvrdi);
        add(panel, "South");
        panel.add(panelDole, "Center");
        destinacija =  new Label("Informacije o Destinaciji");
        destinacija.setForeground(Color.RED);
        panel.add(destinacija, "North");
        
    }
    
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        JMSContext context = conn.createContext();
        new UredjajKorisnik();
        //System.out.println("korisnickiuredjaj.UredjajKorisnik.main()");
        
    }
    
    
}
