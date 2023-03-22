package group3DS.example.restservice.Banking;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class BankAccount {
    private int balance;
    private String name;
    private @Id @GeneratedValue Long id;

    public BankAccount(int balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public BankAccount() {
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof BankAccount))
            return false;
        BankAccount account = (BankAccount) o;
        return Objects.equals(this.id, account.id) && Objects.equals(this.name, account.name)
                && Objects.equals(this.balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.balance);
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + this.id + ", name='" + this.name + '\'' + ", balance='" + this.balance + '\'' + '}';
    }

    public String withdraw(int amount){
        if (amount <= balance) {
            this.balance -= amount;
            return "success " + balance;
        }else {
            return "fail";
        }
    }
}
