package com.ecommerce.apiMenuio;

import com.cloudinary.Cloudinary;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//@SpringBootApplication(exclude={SecurityAutoConfiguration.class})

@SpringBootApplication
@ComponentScan(basePackages = {"hello","com.ecommerce.apiMenuio.controller", "com.ecommerce.apiMenuio.service","com.ecommerce.apiMenuio.security","com.ecommerce.apiMenuio.security.jwt","com.ecommerce.apiMenuio.security.services"})
@EntityScan("com.ecommerce.apiMenuio.entities")
@EnableJpaRepositories("com.ecommerce.apiMenuio.managers")
public class ApiMenuioApplication {
@Value("${cloudinary.cloud_name}")
	private String cloudName;

	@Value("${cloudinary.api_key}")
	private String apiKey;

	@Value("${cloudinary.api_secret}")
	private String apiSecret;
    public static void main(String[] args) {
        SpringApplication.run(ApiMenuioApplication.class, args);
    }
    @Bean
	public Cloudinary cloudinaryConfig() {
		Cloudinary cloudinary = null;
		      Map config = new HashMap();
		config.put("cloud_name", cloudName);
		config.put("api_key", apiKey);
		config.put("api_secret", apiSecret);
		cloudinary = new Cloudinary(config);
		return cloudinary;
	}
}
