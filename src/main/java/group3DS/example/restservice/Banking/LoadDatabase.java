package group3DS.example.restservice.Banking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BankDatabase database){

        return args -> {
            log.info("preloading " + database.save(new BankAccount(500, "Jan")));
            log.info("preloading " + database.save(new BankAccount(5000, "Joined")));
        };
    }
}
