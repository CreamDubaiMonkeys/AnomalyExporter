package com.example.EventOrganizerBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EventOrganizerBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventOrganizerBackApplication.class, args);
	}

}
