package com.api.handlers;

import com.api.headers.ResponseMessageHeader;
import com.api.headers.StartRequestHeader;

import java.security.NoSuchAlgorithmException;

public interface IStartRequestHandler {
    public ResponseMessageHeader StartProcessing(StartRequestHeader header) throws NoSuchAlgorithmException;
}
