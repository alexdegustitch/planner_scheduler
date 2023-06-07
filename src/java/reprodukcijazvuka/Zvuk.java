/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reprodukcijazvuka;

import bentiteti.Pesma;
import com.google.gson.Gson;
import static com.google.gson.internal.bind.TypeAdapters.URI;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import javafx.scene.chart.PieChart.Data;
import javax.persistence.TypedQuery;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author uSER
 */
public class Zvuk {
    
    
    
    public void pustiPesmu(String nazivPesme, String izvodjac) throws MalformedURLException, IOException, JSONException, URISyntaxException {
        
        String keyword = nazivPesme + " " + izvodjac;
        keyword = keyword.replace(" ", "+");
        String json="";
        URL adresa=new URL("https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=1&order=rating&type=video&videoDefinition=high&q=" + keyword + "&key=AIzaSyAFgJeDXMXV20vWwcoVQHlULi20hoqskSw");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(adresa.openStream()));
        
        String inputLine;
        
        while ((inputLine = in.readLine()) != null)
            json+=inputLine;
            
        in.close();
        Data data = new Gson().fromJson(json, Data.class);
        JSONObject obj1 = new JSONObject(json);
        JSONArray arr2 = obj1.getJSONArray("items");
        JSONObject obj2 = arr2.getJSONObject(0);
        JSONObject obj3 = obj2.getJSONObject("id");
        String idVideo=(String)obj3.get("videoId");
        
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("https://www.youtube.com/watch?v=" + idVideo));
        
    }
    
    public List<Pesma> posaljiSvePesme(){
        
        TypedQuery<Pesma> query = UredjajZvuk.em.createNamedQuery("SELECT p FROM Pesma", Pesma.class);
        List<Pesma> list = query.getResultList();
        return list;
        
    }
}
