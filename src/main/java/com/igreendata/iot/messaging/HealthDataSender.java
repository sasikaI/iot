package com.igreendata.iot.messaging;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import com.igreendata.iot.data.BloodPressureData;

import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HealthDataSender {

	@Autowired
	private NotificationMessagingTemplate notificationMessagingTemplate;

    @Value("${aws.sns-topic.name}")
    private String topicName;

    public void sendToSNS(List<BloodPressureData> listBloodPresser) {
    	for (BloodPressureData bloodPressureData : listBloodPresser) {
    		Message<BloodPressureData> message = new GenericMessage<>(bloodPressureData);
    		 notificationMessagingTemplate.send(topicName, message);
		}
    }
}
