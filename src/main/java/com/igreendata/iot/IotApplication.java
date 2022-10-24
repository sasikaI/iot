package com.igreendata.iot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.igreendata.iot.data.HealthDataReader;
import com.igreendata.iot.messaging.HealthDataSender;

@SpringBootApplication
public class IotApplication {
	
	@Autowired
	private HealthDataSender healthDataSender;

	public static void main(String[] args) {
		SpringApplication.run(IotApplication.class, args);
	}

}
