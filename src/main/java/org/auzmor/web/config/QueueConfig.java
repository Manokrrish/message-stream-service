package org.auzmor.web.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.auzmor.web.common.KafkaProps;
import org.auzmor.web.proto.UserProto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Listener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
@EnableKafka
public class QueueConfig {
	@Autowired
	KafkaProps kafkaProps;
	
		@Bean
	    ConcurrentKafkaListenerContainerFactory<Integer, String>
	                        kafkaListenerContainerFactory() {
	        ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
	                                new ConcurrentKafkaListenerContainerFactory<Integer, String>();
	        factory.setConsumerFactory(consumerFactory());
	        return factory;
	    }

	    @Bean
	    public ConsumerFactory<Integer, String> consumerFactory() {
	        return new DefaultKafkaConsumerFactory<Integer, String>(consumerConfigs());
	    }

	    @Bean
	    public Map<String, Object> consumerConfigs() {
	        Map<String, Object> props = new HashMap<String, Object>();
	        //TODO - will implement when consumer is required
	        return props;
	    }

	    @Bean
	    public Listener listener() {
	        return new Listener();
	    }

	    @Bean
	    public ProducerFactory<Integer, byte[]> producerFactory() {
	        return new DefaultKafkaProducerFactory<Integer, byte[]>(producerConfigs());
	    }

	    @Bean
	    public Map<String, Object> producerConfigs() {
	        Map<String, Object> props = new HashMap<String, Object>();
	        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProps.getProducer().getBootstrapServersConfig());
	        props.put(ProducerConfig.RETRIES_CONFIG, kafkaProps.getProducer().getRetriesConfig());
	        props.put(ProducerConfig.BATCH_SIZE_CONFIG, kafkaProps.getProducer().getBatchSizeConfig());
	        props.put(ProducerConfig.LINGER_MS_CONFIG, kafkaProps.getProducer().getLingerMsConfig());
	        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, kafkaProps.getProducer().getBufferMemoryConfig());
	        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
	        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.ByteArraySerializer.class);
	        return props;
	    }

	    @Bean
	    public KafkaTemplate<Integer, byte[]> kafkaTemplate() {
	        return new KafkaTemplate<Integer, byte[]>(producerFactory());
	    }
}
