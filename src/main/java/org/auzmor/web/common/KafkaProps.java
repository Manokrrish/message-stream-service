package org.auzmor.web.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Kafka properties loaded here
 * @author mankri
 *
 */
@Configuration
@PropertySource("classpath:kafka.properties")
@ConfigurationProperties(prefix="kafka")
public class KafkaProps {
	
	private String userTopic;
	private Producer producer;
	public String toString() {
		return "userTopic="+userTopic+", Producer.bootstrap="+producer.bootstrapServersConfig+", batchSizeConfig="+producer.batchSizeConfig;
	}

	public String getUserTopic() {
		return userTopic;
	}

	public void setUserTopic(String userTopic) {
		this.userTopic = userTopic;
	}
	
	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public static class Producer {
		private String bootstrapServersConfig;
		private String retriesConfig;
		private int batchSizeConfig;
		private int lingerMsConfig;
		private long bufferMemoryConfig;
		
		public String getBootstrapServersConfig() {
			return bootstrapServersConfig;
		}
		public void setBootstrapServersConfig(String bootstrapServersConfig) {
			this.bootstrapServersConfig = bootstrapServersConfig;
		}
		public String getRetriesConfig() {
			return retriesConfig;
		}
		public void setRetriesConfig(String retriesConfig) {
			this.retriesConfig = retriesConfig;
		}
		public int getBatchSizeConfig() {
			return batchSizeConfig;
		}
		public void setBatchSizeConfig(int batchSizeConfig) {
			this.batchSizeConfig = batchSizeConfig;
		}
		public int getLingerMsConfig() {
			return lingerMsConfig;
		}
		public void setLingerMsConfig(int lingerMsConfig) {
			this.lingerMsConfig = lingerMsConfig;
		}
		public long getBufferMemoryConfig() {
			return bufferMemoryConfig;
		}
		public void setBufferMemoryConfig(long bufferMemoryConfig) {
			this.bufferMemoryConfig = bufferMemoryConfig;
		}
	}
	
}
