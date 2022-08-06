package com.democracy.config;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
		

		@Bean( name = "local-datasource" )
		public HikariConfig localHikariConfig() {
				
				HikariConfig hikariConfig = new HikariConfig();
				
				hikariConfig.setJdbcUrl( "jdbc:log4jdbc:mysql://democracy.ckkrdzszcxq9.us-west-1.rds.amazonaws.com:3306/democracy" );
				hikariConfig.setUsername( "root" );
				hikariConfig.setPassword( "123456789" );
				hikariConfig.setDriverClassName( "net.sf.log4jdbc.sql.jdbcapi.DriverSpy" );
				
				// MinumumIdle : 일하지 않는 Connection을 유지하는 설정
				hikariConfig.setMinimumIdle( 1 );
				
				// IdleTimeOut : 일하지 않는 Connection Pool을 유지하는 시간
				hikariConfig.setIdleTimeout( 10000 );
				
				// ConnectionTimeout : Connection을 가져오기 위해 기다리는 시간 Timout 되면 SqlException을 던짐
				hikariConfig.setConnectionTimeout( 200000 );
				
				// MaximumPoolSize : Connection Pool에 유지할 Connection의 수 -> 현재 Pool Size가 10 이라면 idle 상태인 pool은 없음
				hikariConfig.setMaximumPoolSize( 10 );
				
				return hikariConfig;
		}

		@Bean( name = "dev-datasource" )
		public HikariConfig devHikariConfig() {
				
				HikariConfig hikariConfig = new HikariConfig();
				
				hikariConfig.setJdbcUrl( "jdbc:log4jdbc:mysql://15.165.158.252:3306/democracy" );
				hikariConfig.setUsername( "democracy" );
				hikariConfig.setPassword( "1234" );
				hikariConfig.setDriverClassName( "net.sf.log4jdbc.sql.jdbcapi.DriverSpy" );
				
				// MinumumIdle : 일하지 않는 Connection을 유지하는 설정
				hikariConfig.setMinimumIdle( 1 );
				
				// IdleTimeOut : 일하지 않는 Connection Pool을 유지하는 시간
				hikariConfig.setIdleTimeout( 10000 );
				
				// ConnectionTimeout : Connection을 가져오기 위해 기다리는 시간 Timout 되면 SqlException을 던짐
				hikariConfig.setConnectionTimeout( 200000 );
				
				// MaximumPoolSize : Connection Pool에 유지할 Connection의 수 -> 현재 Pool Size가 10 이라면 idle 상태인 pool은 없음
				hikariConfig.setMaximumPoolSize( 10 );
				
				return hikariConfig;
		}
}
