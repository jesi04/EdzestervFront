package hu.EdzestervFront;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EdzestervFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdzestervFrontApplication.class, args);
	}

}
