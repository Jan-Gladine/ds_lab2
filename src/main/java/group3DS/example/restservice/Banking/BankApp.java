package group3DS.example.restservice.Banking;

import java.util.HashMap;

public class BankApp {
    private HashMap<String, Double> balances = new HashMap<>();
    public BankApp() {
        balances.put("default", 300.0);
    }
    public BankTransaction deposit(String name, double amount){
        balances.put(name, balances.get(name) + amount);
        return new BankTransaction(name, amount);
    }
    public BankTransaction retrieve(String name, double amount){
        if(amount > balances.get(name)){
            return new BankTransaction(name, -1);
        }else {
            balances.put(name, balances.get(name) + amount);
            return new BankTransaction(name, amount);
        }
    }
    public BankTransaction getBalance(String name){
        return new BankTransaction(name, balances.get(name));
    }
}
