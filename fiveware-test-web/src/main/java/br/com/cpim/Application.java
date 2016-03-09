package br.com.cpim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import br.com.cpim.config.DbConfig;

@Import(DbConfig.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
}
