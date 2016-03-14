# Test

O objetivo é criar um fomulário de cadastro e armazenar as informações digitadas no banco de dados, neste projeto, utilize o Spring Framework para o MVC e persistência de dados juntamente com o Hibernate. Após a finalização faça commit e envie o link para esdras.tavares@fiveware.com.br

# Dicas

1 - De um fork neste projeto, clone e importe no eclipse

2 - Crie 2 módulos "maven" com os seguintes nomes:

  - fiveware-test-service (jar)
  - fiveware-test-web (war)
  
Observe que já existe um "parent" e o fiveware-test-model(jar)

3 - Configure o Spring MVC no projeto web(fiveware-test-web), essa configuração deve ser SEM XML.

4 - Crie um formulário qualquer de cadastro que tenha no mínimo os seguintes elementos:

  - Campo de texto
  - Checkbox
  - Combobox
  - radio
  
O envio dos dados do formulário deve ser via AJAX

5 - Crie o modelo de dados para este formulário no MySQL e também a entidade no módulo fiveware-test-model

6 - Implemente todas as camadas, a view chamando o controller, o controller chamando o service e o service invocando o repositório.

# Executando a aplicação

Para executar a aplicação (depois que o banco de dados MySQL estiver configurado e disponível), execute o seguinte comando na pasta **do projeto web** :

	mvn spring-boot:run

Quando a aplicação tiver sido iniciada, ela pode ser acessada no endereço:

	http://localhost:8080/app/rental.html
	
# Executando os testes do projeto

Os testes de integração do projeto usam banco em memória, portanto dispensam a existência de um banco MySQL presente e configurado.

Para executar todos os testes do projeto, execute o seguinte comando a partir da pasta raiz do projeto:

	mvn clean -DskipITs=false -DfailIfNoTests=false  verify
	
Aqui está sendo usada a propriedade skipITs com o valor false porque os testes estão desabilitados por default.


### Executando uma classe de teste do repositório

	mvn clean -Dit.test=RentalRepositoryITT -DskipITs=false -DfailIfNoTests=false  verify
	

### Executando uma classe de teste do controller

	mvn clean -Dit.test=RentalControllerIT -DskipITs=false -DfailIfNoTests=false  verify