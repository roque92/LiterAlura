package org.example.literalura2.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConverData implements IConvertData{
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> clase) {
        try {
            return mapper.readValue(json.toString(), clase);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
