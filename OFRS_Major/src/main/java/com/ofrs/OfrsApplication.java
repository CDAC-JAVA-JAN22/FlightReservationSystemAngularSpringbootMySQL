package com.ofrs;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(scanBasePackages = "com.ofrs")
@EnableJpaRepositories(basePackages = "com.ofrs.repository")
@EntityScan(basePackages = "com.ofrs.model")
@CrossOrigin(origins = "*")
public class OfrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfrsApplication.class, args);
	}
	
	@Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("webmail.evolvingsols.com");
        mailSender.setPort(587);
          
        mailSender.setUsername("Trng1");
        mailSender.setPassword("Cyb@ge@531");
          
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable.required", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.ssl.enable.trust", "*");
        return mailSender;
    }
}