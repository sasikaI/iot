package com.igreendata.iot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.igreendata.iot.data.HealthDataReader;
import com.igreendata.iot.messaging.HealthDataSender;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private HealthDataSender healthDataSender;

    @Override
    public void run(String...args) throws Exception {
    	healthDataSender.sendToSNS(HealthDataReader.getBloodPressureData());

    }
}
