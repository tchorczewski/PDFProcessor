package com.api.handlers;

import com.api.headers.ResponseMessageHeader;
import com.api.headers.StartRequestHeader;
import com.api.parser.PDFParser;
import com.api.shortcutmakers.ShaShortcutMaker;

import java.security.NoSuchAlgorithmException;

public class StartRequestHandler_Sha {
    public ResponseMessageHeader GetShaShortcut(StartRequestHeader header) throws NoSuchAlgorithmException {
        byte[] parsedFile = PDFParser.Parse(header.getBase64Pdf());
        String shaShortcut = ShaShortcutMaker.GetShaShortcut(parsedFile);
        return new ResponseMessageHeader(shaShortcut,null,null);
    }
}
