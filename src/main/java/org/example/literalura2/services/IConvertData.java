package org.example.literalura2.services;

public interface IConvertData {
    <T> T getData(String json, Class<T> clase);
}
