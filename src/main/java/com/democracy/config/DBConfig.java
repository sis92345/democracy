package com.democracy.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DBConfig {
		
		private HikariConfig localConfig;
		
		private HikariConfig devConfig;
		
		@Autowired
		@Qualifier( "local-datasource" )
		public void setLocalConfig( HikariConfig hikariConfig ) {
				
				this.localConfig = hikariConfig;
		}
		@Autowired
		@Qualifier( "dev-datasource" )
		public void setDevConfig( HikariConfig hikariConfig ) {
				
				this.devConfig = hikariConfig;
		}
		
		/**
		 * DataSource
		 * */
		@Bean
		public DataSource dataSource(){
				
				return new HikariDataSource( getHikariConfig( System.getProperty( "spring.profiles.active" , "local" ) ) );
		}
		
		/** JPA 관련 BEAN 등록 */
		@Bean
		public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
				return new PersistenceExceptionTranslationPostProcessor();
		}
		
		@Bean
		public PlatformTransactionManager transactionManager() {
				JpaTransactionManager transactionManager = new JpaTransactionManager();
				transactionManager.setEntityManagerFactory( entityManagerFactory().getObject() );
				
				return transactionManager;
		}
		
		/** JPA ENTITY MANAGER FACTORY BEAN 등록*/
		
		@Bean
		public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
				
				LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
				
				em.setDataSource( dataSource() );
				em.setPackagesToScan( new String[] { "com.democracy" } );
				
				JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
				em.setJpaVendorAdapter( vendorAdapter );
				em.setJpaProperties( additionalProperties() );
				return em;
		}
		
		private Properties additionalProperties() {
				Properties props = new Properties();
				
				// System.out으로 sql을 보여줄 지 여부 -> logback으로 분리해서 문제 X
				//props.setProperty("hibernate.show_sql", "true");
				
				//  DataBase dialect 설정 -> mysql 8용
				props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
				
				return props;
		}
		
		private HikariConfig getHikariConfig( String profile ) {
				
				return "local".equals( profile ) ? localConfig : devConfig;
		}
}
