package com.nsp.j2ee.core.converters.impl;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nsp.j2ee.core.converters.api.ConverterService;
import com.nsp.j2ee.core.converters.api.DeserializationException;
import com.nsp.j2ee.core.converters.api.SerializationException;
@Component
public class GsonConverterServiceImpl implements ConverterService {
	private static Gson gson;
	static {
		gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz")
				// Another way is use type adapters instead of setDateFormat
				// .registerTypeAdapter(Date.class, new DateSerializer())
				// .registerTypeAdapter(Date.class, new DateDeserializer())
				.create();
	}
	
	public <T> T bind(String src, Class<T> targetClass) throws DeserializationException {
		return gson.fromJson(src, targetClass);
	}

	public String serialize(Object object)  throws SerializationException {
		return gson.toJson(object);
	}
}
