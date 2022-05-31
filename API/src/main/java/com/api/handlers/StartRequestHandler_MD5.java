package com.api.handlers;

import com.api.headers.ResponseMessageHeader;
import com.api.headers.StartRequestHeader;
import com.api.shortcutmakers.MD5ShortcutMaker;
import com.api.parser.PDFParser;

import java.security.NoSuchAlgorithmException;

public class StartRequestHandler_MD5 {
    public ResponseMessageHeader GetShortcutMD5(StartRequestHeader header) throws NoSuchAlgorithmException {
        byte[] parsedFile = PDFParser.Parse(header.getBase64Pdf());
        String shaShortcut = MD5ShortcutMaker.GetMD5Shortcut(parsedFile);
        return new ResponseMessageHeader(shaShortcut,null,null);
    }
}
