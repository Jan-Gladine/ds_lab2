package group3DS.example.restservice;

import group3DS.example.restservice.Banking.BankTransaction;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ClientMain {
    public static void main(String[] args) throws IOException, ParseException {
        URL url = new URL("http://localhost:8080/banking/balance");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("param1", "val");
        con.setDoOutput(true);

        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String out = in.readLine();
        BankTransaction balance = JsonParser.JSONtoTransaction(out);
        System.out.println(balance.name() + "\n" + balance.amount());
    }
}
