package group3DS.example.restservice;

import group3DS.example.restservice.Banking.BankAccount;
import group3DS.example.restservice.Banking.BankDatabase;
import jakarta.transaction.Transactional;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class BankingController {

    private final BankDatabase database;

    public BankingController(BankDatabase database) {
        this.database = database;
    }

    @GetMapping("/accounts")
    @Transactional
    List<BankAccount> all(){
        return database.findAll();
    }

    @GetMapping("/balance")
    @Transactional
    int getBalance(@RequestParam String name){
        return database.findBankAccountByName(name).getBalance();
    }

    @PutMapping("/deposit")
    @Transactional
    BankAccount deposit(@RequestParam int amount, @RequestParam String name){
        BankAccount account = database.findBankAccountByName(name);
        account.setBalance(account.getBalance()+amount);
        return database.save(account);
    }

    @PutMapping("/withdraw")
    @Transactional
    String withdraw(@RequestParam int amount, @RequestParam String name) {
        BankAccount account = database.findBankAccountByName(name);
        String result = account.withdraw(amount);
        database.save(database.findBankAccountByName(name));
        return result;
    }

    @PostMapping("/newAccount")
    BankAccount newBankAccount(@RequestParam String name, @RequestParam int balance){
        return database.save(new BankAccount(balance, name));
    }
}
