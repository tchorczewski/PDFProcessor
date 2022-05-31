package com.api.headers;

public class ResponseMessageHeader {
    public final String fileShortcut;
    public final String errorCode;
    public final String errorDsc;

    public ResponseMessageHeader(String fileShortcut, String errorcode, String errorDsc) {

        this.fileShortcut = fileShortcut;
        this.errorCode = errorcode;
        this.errorDsc = errorDsc;
    }
}
