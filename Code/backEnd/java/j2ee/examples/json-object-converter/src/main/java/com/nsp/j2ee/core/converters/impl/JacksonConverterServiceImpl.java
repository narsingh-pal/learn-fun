package com.nsp.j2ee.core.converters.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nsp.j2ee.core.converters.api.ConverterService;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class JacksonConverterServiceImpl implements ConverterService {
	private static ObjectMapper objectMapper;
	final static Logger logger = Logger.getLogger(JacksonConverterServiceImpl.class);

	static {
		objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public <T> T bind(String src, Class<T> targetClass) {
		try {
			if (src.length() > 0) {
				return objectMapper.readValue(src, targetClass);
			} else {
				return null;
			}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			// TODO: need to add logging here +
			// TODO: Logs for all serializers
			throw new RuntimeException(e);
		}
	}

	public String serialize(Object object) {
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String result = null;
		try {
			result = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage(), e);
			// TODO: need to add logging here +
			// TODO: Logs for all serializers
			throw new RuntimeException(e);
		}
		return result;
	}
}
