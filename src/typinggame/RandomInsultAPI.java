package typinggame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author green
 */
public class RandomInsultAPI extends Thread {

    private static String nextInsult = "";

    private static String temp = "";

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
        //set 'nextInsult' to the response

        do {
            temp = doRequest();
            //System.out.println("ciao - "+temp+"\nlmao - "+nextInsult);
            //System.out.println(!nextInsult.equals(temp));
        } while (nextInsult.equals(temp));

        nextInsult = temp;

    }

    private String urlApi = "https://evilinsult.com/generate_insult.php?lang=en";
    private String urlDatabase = "http://93.56.110.73:3404/insults/random";

    public String doRequest() {
        URL server;
        HttpURLConnection service;
        BufferedReader response;

        int status;
        try {
            //System.out.println("URL: "+url);
            server = new URL(urlRandomizer());
            service = (HttpURLConnection) server.openConnection();
            //service.setRequestProperty("Host", "127.0.0.1"); // impostazione header richiesta:  host

            service.setRequestProperty("Accept", "text/plain"); // impostazione header richiesta:  formato risposta
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

            s = s.replaceAll("&quot;", "\"");
            s = s.replaceAll("&gt;", ">");
            s = s.replaceAll("&amp;", "&");

            return s;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String urlRandomizer() {
        Random r = new Random();

        if (r.nextInt() % 2 == 0) {
            return urlApi;
        } else {
            return urlDatabase;
        }
    }

}
//&gt; &amp;
