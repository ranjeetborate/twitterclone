package com.assignment.twitter.utility;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:db.properties")
public class DataSourceConfiguration {
	@Value( "${spring.datasource.driver-class-name}" )
	private String driverClassName;

	@Value( "${spring.datasource.username}" )
	private String username;

	@Value( "${spring.datasource.password}" )
	private String password;

	@Value( "${spring.datasource.url}" )
	private String url;

	@Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
        .driverClassName(driverClassName)
        .url(url)
        .username(username)
        .password(password)
        .build();	
    }
}
