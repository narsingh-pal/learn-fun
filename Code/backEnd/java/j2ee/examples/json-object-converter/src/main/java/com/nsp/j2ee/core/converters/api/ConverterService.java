package com.nsp.j2ee.core.converters.api;

public interface ConverterService {
    <T> T bind(String var1, Class<T> var2) throws DeserializationException;

    String serialize(Object var1) throws SerializationException;
}
