package tk.chevalclinic.chevalclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ChevalclinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChevalclinicApplication.class, args);
	}

}
