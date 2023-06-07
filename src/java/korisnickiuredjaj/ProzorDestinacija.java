/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package korisnickiuredjaj;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author uSER
 */
public class ProzorDestinacija extends Frame {
    
    private TextField datum, vreme, trajanje;
    private Label datumL, vremeL, trajanjeL;
    private TextField adresa, grad, drzava, naziv;
    private Label adresaL, gradL, drzavaL, nazivL;
    private Label destinacija;
    
    public ProzorDestinacija(){
        super("Destinacija");
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
        Panel panelGore = new Panel(new GridLayout(3, 2));
        datumL = new Label("datum:");
        datum = new TextField();
        vremeL = new Label("vreme:");
        vreme = new TextField();
        trajanjeL = new Label("trajanje:");
        trajanje = new TextField();
        
        panelGore.add(datumL);
        panelGore.add(datum);
        panelGore.add(vremeL);
        panelGore.add(vreme);
        panelGore.add(trajanjeL);
        panelGore.add(trajanje);
        
        add(panelGore, "North");
        
        Panel panelDole = new Panel(new GridLayout(4, 2));
        
        adresaL = new Label("adresa:");
        adresa = new TextField();
        gradL = new Label("grad:");
        grad = new TextField();
        drzavaL = new Label("drzava:");
        drzava = new TextField();
        nazivL = new Label("naziv:");
        naziv = new TextField();
        
        panelDole.add(adresaL);
        panelDole.add(adresa);
        panelDole.add(gradL);
        panelDole.add(grad);
        panelDole.add(drzavaL);
        panelDole.add(drzava);
        panelDole.add(nazivL);
        panelDole.add(naziv);
        
        add(panelDole, "South");
        
        destinacija =  new Label("Informacije o Destinaciji");
        destinacija.setForeground(Color.RED);
        add(destinacija, "Center");
        
    }
    
    public static void main(String[] args){
        new ProzorDestinacija();
    }
}
