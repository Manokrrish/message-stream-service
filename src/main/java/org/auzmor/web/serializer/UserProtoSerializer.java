package org.auzmor.web.serializer;

import java.util.Map;

import org.auzmor.web.proto.UserProto.User;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserProtoSerializer implements org.apache.kafka.common.serialization.Serializer<User>{

	@Override
	public byte[] serialize(String arg0, User arg1) {
		byte[] retVal = null;
	    ObjectMapper objectMapper = new ObjectMapper();
	    try {
	    	System.out.println(objectMapper.writeValueAsString(arg1));
	      retVal = objectMapper.writeValueAsString(arg1).getBytes();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return retVal;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

}
