package typinggame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

/**
 *
 * @author green
 */
public class RandomInsultAPI extends Thread {

    private static String nextInsult;

    public static void initialize() {
        //get first string...
        new RandomInsultAPI().start();
    }

    public static String getInsult() {
        //get next string...
        new RandomInsultAPI().start();

        //returns the current one
        return nextInsult;
    }

    public RandomInsultAPI() {
        //thread constructor
    }

    public void run() {
        //request insult
        //set nextInsult to the response
        nextInsult = doRequest();//String.valueOf((int) Math.floor(Math.random() * 10));   //DA MODIFICARE CON L'INSULTO
    }
    
    public String doRequest(){
        URL server;
        HttpURLConnection service;
        BufferedReader response;
        
        int status;
        try {
            String url = "https://evilinsult.com/generate_insult.php?lang=en"; // costruzione dello URL di interrogazione del servizio
            System.out.println("URL: "+url);
            server = new URL(url);
            service = (HttpURLConnection)server.openConnection();
            //service.setRequestProperty("Host", "127.0.0.1"); // impostazione header richiesta: host
            
            service.setRequestProperty("Accept", "text/plain"); // impostazione header richiesta: formato risposta
            service.setRequestProperty("Accept-Charset", "UTF-8"); // impostazione header richiesta: codifica risposta
            
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
            
            return s;
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
