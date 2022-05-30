package com.example.api;

public class PDFParser {
    public static byte[] Parse(String base64String){
        byte[] decodedFile;
        try {
            decodedFile = java.util.Base64.getDecoder().decode(base64String);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return decodedFile;
    }
}
