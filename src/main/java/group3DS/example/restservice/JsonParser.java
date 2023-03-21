package group3DS.example.restservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import group3DS.example.restservice.Banking.BankTransaction;

public class JsonParser {
    public static Greeting JSONtogreeting(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Greeting.class);
    }
    public static BankTransaction JSONtoTransaction(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, BankTransaction.class);
    }
}
