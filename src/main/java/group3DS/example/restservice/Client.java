package group3DS.example.restservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Client implements Runnable{
    @Override
    public void run() {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/withdraw?name=Jan&amount=5");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            con.setRequestMethod("PUT");
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        }

        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(in.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
