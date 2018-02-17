package org.auzmor.web.service;

import org.auzmor.web.common.KafkaProps;
import org.auzmor.web.proto.UserProto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueueService {
	
	@Autowired
	KafkaTemplate<Integer, byte[]> kafkaTemplate;
	@Autowired
	KafkaProps kafkaProps;
	
	public void pushUserToQueue(User user) {
		System.out.println(kafkaProps.toString());
		kafkaTemplate.send(kafkaProps.getUserTopic(), user.getId(), user.toByteArray());
	}
}
