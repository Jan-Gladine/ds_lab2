package group3DS.example.restservice.Banking;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

public interface BankDatabase extends JpaRepository<BankAccount, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    BankAccount findBankAccountByName(String name);
}
