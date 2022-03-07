package com.homeward.webstore.handler.converter;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

public class DynamicMessageConverter implements HttpMessageConverter<Object> {
    private final HttpMessageConverter<Object> jsonConverter;
    private final HttpMessageConverter<String> stringConverter;

    public DynamicMessageConverter(HttpMessageConverter<Object> jsonConverter, HttpMessageConverter<String> stringConverter) {
        this.jsonConverter = jsonConverter;
        this.stringConverter = stringConverter;
    }

    @Override
    public boolean canRead(Class clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class clazz, MediaType mediaType) {
        return jsonConverter.canWrite(clazz, mediaType) || stringConverter.canWrite(clazz, mediaType);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        List<MediaType> jsonMedia = jsonConverter.getSupportedMediaTypes();
        List<MediaType> stringMedia = stringConverter.getSupportedMediaTypes();
        List<MediaType> allMedia = new ArrayList<>();
        allMedia.addAll(jsonMedia);
        allMedia.addAll(stringMedia);
        return allMedia;
    }

    @Override
    public Object read(Class clazz, HttpInputMessage inputMessage) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void write(Object o, MediaType contentType, HttpOutputMessage outputMessage) {
        try {
            if (o instanceof String) {
                stringConverter.write((String) o, contentType, outputMessage);
            } else {
                jsonConverter.write(o, contentType, outputMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}