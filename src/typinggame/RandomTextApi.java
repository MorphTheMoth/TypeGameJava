package typinggame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author deste
 */
public class RandomTextApi {
    public static String getText(){
        
        URL server;
        HttpURLConnection service;
        BufferedReader response;
        
        int status;
        try {
            String url = "https://www.randomtextgenerator.com"; // costruzione dello URL di interrogazione del servizio
            //System.out.println("URL: "+url);
            server = new URL(url);
            service = (HttpURLConnection)server.openConnection();
            //service.setRequestProperty("Host", "127.0.0.1"); // impostazione header richiesta:  host
            
            service.setRequestProperty("Accept", "text/html"); // impostazione header richiesta:  formato risposta
            service.setRequestProperty("Accept-Charset", "UTF-8"); // impostazione header richiesta:  codifica risposta
            
            service.setRequestMethod("GET"); // impostazione metodo di richiesta GET
            service.setDoInput(true); // attivazione ricezione
            service.connect(); // connessione al servizio
            status = service.getResponseCode(); // verifica stato risposta
            if (status != 200) {
                return ""; // errore
            }
            // apertura stream di ricezione da risorsa web
            response = new BufferedReader(new InputStreamReader(service.getInputStream(), "UTF-8"));
            
            String s = response.lines().collect(Collectors.joining());
            response.close();
            
            //System.out.println(s);
            
            return s;
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return "";
    }
}
