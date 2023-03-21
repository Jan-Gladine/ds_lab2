package group3DS.example.restservice;

import group3DS.example.restservice.Banking.BankApp;
import group3DS.example.restservice.Banking.BankTransaction;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private BankApp bank = new BankApp();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/banking/deposit")
    public BankTransaction Deposit(@RequestParam(value = "name", defaultValue = "default") String name,
    @RequestParam(value = "amount", defaultValue = "0") double amount) {
        return bank.deposit(name, amount);
    }
    @GetMapping("/banking/balance")
    public BankTransaction GetBalance(@RequestParam(value = "name", defaultValue = "default") String name){
        return bank.getBalance(name);
    }
}
