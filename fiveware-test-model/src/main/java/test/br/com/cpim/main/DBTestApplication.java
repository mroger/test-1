package test.br.com.cpim.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import br.com.cpim.config.DbConfig;

/**
 * Classe criada para exercitar o banco de dados e os mapeamentos JPA isoladamente da aplicacao.
 * 
 * @author Roger
 *
 */
@Import(DbConfig.class)
@SpringBootApplication
public class DBTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DBTestApplication.class);
	}
}
