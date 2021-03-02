/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typinggame;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Federico
 */
public class ServerApi {

    public static int registerMethod(String name, String psw) throws IOException {

        URL url = new URL("http://93.56.110.73:3404/users/");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) con;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);
        String json = "{\"name\": \"" + name + "\", \"psw\": \"" + psw + "\"}";
        System.out.println(json);
        byte[] out = json.getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.connect();
        try (OutputStream os = http.getOutputStream()) {
            os.write(out);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            JsonObject jsonObject = new JsonParser().parse(response.toString()).getAsJsonObject();
            //System.out.println(jsonObject.get("statusCode").getAsString()); 
            return Integer.parseInt(jsonObject.get("statusCode").getAsString());

        }

    }

    public static int loginMethod(String name, String psw) throws IOException {
        URL server;
        HttpURLConnection service;
        BufferedReader response;

        int status;
        try {
            String url = "http://93.56.110.73:3404/users/?name=" + name + "&psw=" + psw; // costruzione dello URL di interrogazione del servizio
            System.out.println("URL: " + url);
            server = new URL(url);
            service = (HttpURLConnection) server.openConnection();
            //service.setRequestProperty("Host", "127.0.0.1"); // impostazione header richiesta:  host

            service.setRequestProperty("Accept", "text/plain"); // impostazione header richiesta:  formato risposta
            service.setRequestProperty("Accept-Charset", "UTF-8"); // impostazione header richiesta:  codifica risposta

            service.setRequestMethod("GET"); // impostazione metodo di richiesta GET
            service.setDoInput(true); // attivazione ricezione
            service.connect(); // connessione al servizio
            status = service.getResponseCode(); // verifica stato risposta
            if (status != 200) {
                return 2; // errore
            }
            // apertura stream di ricezione da risorsa web
            response = new BufferedReader(new InputStreamReader(service.getInputStream(), "UTF-8"));

            String s = response.lines().collect(Collectors.joining());
            response.close();

            JsonObject jsonObject = new JsonParser().parse(s.toString()).getAsJsonObject();

            if (jsonObject.get("statusCode").getAsString().equals("true")) {
                return 0;
            } else {
                return 1;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 2;
    }

    public static int uploadInsultMethod(String name, String psw, String title, String data) throws IOException {

        URL url = new URL("http://93.56.110.73:3404/insults/");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) con;
        http.setRequestMethod("PUT");
        http.setDoOutput(true);
        String json = "{\"name\": \"" + name + "\", \"psw\": \"" + psw + "\", \"title\": \"" + title + "\", \"data\": \"" + data + "\"}";
        System.out.println(json);
        byte[] out = json.getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.connect();
        try (OutputStream os = http.getOutputStream()) {
            os.write(out);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            JsonObject jsonObject = new JsonParser().parse(response.toString()).getAsJsonObject();
            //System.out.println(jsonObject.get("statusCode").getAsString()); 

            return Integer.parseInt(jsonObject.get("statusCode").getAsString());
        }
    }

    public static int removeInsultMethod(String name, String psw, String title) throws IOException {

        URL url = new URL("http://93.56.110.73:3404/insults/");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) con;
        http.setRequestMethod("DELETE");
        http.setDoOutput(true);
        String json = "{\"name\": \"" + name + "\", \"psw\": \"" + psw + "\", \"title\": \"" + title + "\"}";
        System.out.println(json);
        byte[] out = json.getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.connect();
        try (OutputStream os = http.getOutputStream()) {
            os.write(out);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            JsonObject jsonObject = new JsonParser().parse(response.toString()).getAsJsonObject();
            //System.out.println(jsonObject.get("statusCode").getAsString()); 

            return Integer.parseInt(jsonObject.get("statusCode").getAsString());
        }
    }

}
