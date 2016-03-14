package br.com.cpim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;

/**
 * Classe responsavel por iniciar a aplicação Web
 * 
 * @author Roger
 *
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude=WebSocketAutoConfiguration.class)
public class Application {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
}
