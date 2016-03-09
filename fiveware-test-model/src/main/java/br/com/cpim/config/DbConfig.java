package br.com.cpim.config;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@PropertySource(value = "classpath:config/db.properties")
@EnableTransactionManagement
@EnableJpaRepositories("br.com.cpim.repository")
@Configuration
public class DbConfig {
	
	@Autowired
	Environment env;
	
	@Bean
	public BasicDataSource basicDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl(env.getProperty("jdbc.url"));
		basicDataSource.setUsername(env.getProperty("jdbc.username"));
		basicDataSource.setPassword(env.getProperty("jdbc.password"));
		//TODO Completar as propriedades
		
		return basicDataSource;
	}
	
	@Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }
 
    @Bean
    @Autowired
    public EntityManagerFactory entityManagerFactory(BasicDataSource dataSource) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(false);
        vendorAdapter.setShowSql(true);
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
        vendorAdapter.setDatabase(Database.MYSQL);
 
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("br.com.cpim.model");
        factory.setDataSource(dataSource);
 
        //Properties properties = new Properties();
        //properties.setProperty("hibernate.cache.use_second_level_cache", "true");
        //properties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        //properties.setProperty("hibernate.cache.use_query_cache", "true");
        //properties.setProperty("hibernate.generate_statistics", "false");
 
        //factory.setJpaProperties(properties);
 
        factory.afterPropertiesSet();
 
        return factory.getObject();
    }
 
    @Bean
    @Autowired
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        JpaDialect jpaDialect = new HibernateJpaDialect();
        txManager.setEntityManagerFactory(entityManagerFactory);
        txManager.setJpaDialect(jpaDialect);
        return txManager;
    }
	
}
