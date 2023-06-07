/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



/**
 *
 * @author uSER
 */
public class Kalkulator {
    
    public static String[] geocoding(String addr1) throws Exception
{
    // build a URL
    String apiKey="AIzaSyA5eK5tYHl5SoZ-IxLsO7WKCT1mn7DXWPU";

    String s = "https://maps.google.com/maps/api/geocode/json?" +
                    "sensor=false&address=";
    s += URLEncoder.encode(addr1, "UTF-8");
    s +="&key=" + apiKey;
   // System.out.println(s);
    URL url = new URL(s);
 
    // read from the URL
    Scanner scan = new Scanner(url.openStream());
    String str = new String();
    while (scan.hasNext())
        str += scan.nextLine();
    scan.close();
 
    // build a JSON object
    JSONObject obj = new JSONObject(str);
    if (! obj.getString("status").equals("OK"))
        return null;
 
    // get the first result
    JSONObject res = obj.getJSONArray("results").getJSONObject(0);
  //  System.out.println(res.getString("formatted_address"));
    JSONObject loc =
        res.getJSONObject("geometry").getJSONObject("location");
   // System.out.println("lat: " + loc.getDouble("lat") +
         //               ", lng: " + loc.getDouble("lng"));
    
    
    String a[]= new String[2];
    a[0]=Double.toString((loc.getDouble("lat")));
    a[1]=Double.toString((loc.getDouble("lng")));
    
    return a;
     
   
}
    
    
    public static String[] calculateDistance(String a2[], String a1[]) throws IOException, JSONException{
        String api="AIzaSyA5eK5tYHl5SoZ-IxLsO7WKCT1mn7DXWPU";
        String json=new String("");
        String s="https://maps.googleapis.com/maps/api/distancematrix/json?origins=";
        String s1="https://maps.googleapis.com/maps/api/distancematrix/json?origins=44.8063787,20.4728985&destinations=44.7942963,20.4924466&mode=driving&language=en-EN&sensor=false&key=AIzaSyA5eK5tYHl5SoZ-IxLsO7WKCT1mn7DXWPU";
        String a1Lat, a1Lng, a2Lat, a2Lng;
        a1Lat=a1[0];
        a1Lng=a1[1];
        a2Lat=a2[0];
        a2Lng=a2[1];
        s+=a1Lat+","+a1Lng;
        s+="&destinations=";
        s+=a2Lat+","+a2Lng;
        s+="&mode=driving&language=en-EN&sensor=false&key=";
        s+=api;
        //System.out.println(s);
        //System.out.println(s1);
        URL adresa=new URL(s);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(adresa.openStream()));

       // SampleDTO sample = new Gson().fromJson(br, SampleDTO.class);  
        
       
        
        String inputLine;
        int i=0;
        while ((inputLine = in.readLine()) != null){
            json+=inputLine;
            System.out.println(inputLine);
            //System.out.println(i++);
        }
        
        JSONObject obj1=new JSONObject(json);
        JSONArray arr1=obj1.getJSONArray("rows");
       // System.out.println(arr1);
        JSONObject arr2=arr1.getJSONObject(0);
       // System.out.println(arr2);
        JSONArray obj3=arr2.getJSONArray("elements");
       // System.out.println(obj3);
        String vreme = obj3.getJSONObject(0).getJSONObject("duration").getString("text");
        String udaljenost = obj3.getJSONObject(0).getJSONObject("distance").getString("text");
       //String udaljenost = arr2.getJSONArray(0).getString("text");
        //String vreme=arr2.getJSONArray(1).getString("text");
        //System.out.println(udaljenost + " " + vreme);
        
        String rez[] = new String[2];
        rez[0]=udaljenost;
        rez[1]=vreme;
        return rez;
        
        
    }
    
    /*
    public String[] izracunajAB(String lokA, String lokB) throws JSONException, MalformedURLException, IOException, Exception{
        
        
        String api="AIzaSyA5eK5tYHl5SoZ-IxLsO7WKCT1mn7DXWPU";
        String json="";
        String stringAPI="https://maps.googleapis.com/maps/api/distancematrix/json?origins=";
       
        String s1="https://maps.googleapis.com/maps/api/distancematrix/json?origins=44.8063787,20.4728985&destinations=44.7942963,20.4924466&mode=driving&language=en-EN&sensor=false&key=AIzaSyA5eK5tYHl5SoZ-IxLsO7WKCT1mn7DXWPU";
        String[] lokacijaA = new String[2];
        String[] lokacijaB = new String[2];
        
        lokacijaA = geocoding(lokA);
        lokacijaB = geocoding(lokB);
        
        String latA, latB, lngA, lngB;
        
        latA = lokacijaA[0];
        lngA = lokacijaA[1];
        latB = lokacijaB[0];
        lngB = lokacijaB[1];
        
        stringAPI += latA + "," + lngA;
        stringAPI += "&destinations=";
        stringAPI += latB+ "," +lngB;
        stringAPI += "&mode=driving&language=en-EN&sensor=false&key=";
        stringAPI += api;
        
        URL adresa=new URL(stringAPI);
        
        BufferedReader in = new BufferedReader(
        new InputStreamReader(adresa.openStream()));
        
        String inputLine;
       
        while ((inputLine = in.readLine()) != null){
            json+=inputLine;
            //System.out.println(inputLine);
    
        }
        
        JSONObject obj1=new JSONObject(json);
        JSONArray arr1=obj1.getJSONArray("rows");
     
        JSONObject arr2=arr1.getJSONObject(0);

        JSONArray obj3=arr2.getJSONArray("elements");

        String vreme = obj3.getJSONObject(0).getJSONObject("duration").getString("text");
        String udaljenost = obj3.getJSONObject(0).getJSONObject("distance").getString("text");
        
        String rezultat[] = new String[2];
        rezultat[0]=udaljenost;
        rezultat[1]=vreme;
        
        return rezultat;
        
        
    }
    
    private String[] geocoding(String adresa) throws Exception {
   
        String apiKey="AIzaSyA5eK5tYHl5SoZ-IxLsO7WKCT1mn7DXWPU";

        String apiString = "https://maps.google.com/maps/api/geocode/json?" +
                        "sensor=false&address=";
        apiString += URLEncoder.encode(adresa, "UTF-8");
        apiString +="&key=" + apiKey;

        URL url = new URL(apiString);

        String json = new String();
        Scanner scan = new Scanner(url.openStream());
   
        while (scan.hasNext())
                json += scan.nextLine();
        

        scan.close();
        // build a JSON object
        JSONObject obj = new JSONObject(json);
        if (! obj.getString("status").equals("OK"))
            return null;

        // get the first result
        JSONObject res = obj.getJSONArray("results").getJSONObject(0);
      //  System.out.println(res.getString("formatted_address"));
        JSONObject loc =
            res.getJSONObject("geometry").getJSONObject("location");
       // System.out.println("lat: " + loc.getDouble("lat") +
             //               ", lng: " + loc.getDouble("lng"));


        String rezultat[]= new String[2];
        rezultat[0]=Double.toString((loc.getDouble("lat")));
        rezultat[1]=Double.toString((loc.getDouble("lng")));

        return rezultat;
     
   
}*/
}
