package com.example.api;

import java.security.NoSuchAlgorithmException;

public class StartRequestHandler_Sha {
    public ResponseMessageHeader GetShaShortcut(StartRequestHeader header) throws NoSuchAlgorithmException {
        byte[] parsedFile = PDFParser.Parse(header.getBase64Pdf());
        String shaShortcut = ShaShortcutMaker.GetShaShortcut(parsedFile);
        return new ResponseMessageHeader(shaShortcut,null,null);
    }
}
