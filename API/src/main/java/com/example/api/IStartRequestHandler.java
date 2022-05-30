package com.example.api;

import java.security.NoSuchAlgorithmException;

public interface IStartRequestHandler {
    public ResponseMessageHeader StartProcessing(StartRequestHeader header) throws NoSuchAlgorithmException;
}
