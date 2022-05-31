package com.api.handlers;

import com.api.enums.Enums;
import com.api.headers.ResponseMessageHeader;
import com.api.headers.StartRequestHeader;

import java.security.NoSuchAlgorithmException;

public class StartRequestHandler_Base implements IStartRequestHandler {
    @Override
    public ResponseMessageHeader StartProcessing(StartRequestHeader header) throws NoSuchAlgorithmException {
        if(header.getShortcutType() == Enums.ShortcutType.MD5){
            return new StartRequestHandler_MD5().GetShortcutMD5(header);
        } else if (header.getShortcutType() == Enums.ShortcutType.SHA) {
            return new StartRequestHandler_Sha().GetShaShortcut(header);
        }
        else {
            return new ResponseMessageHeader(null,"Wrong Shortcut Type","200");
        }
    }
}
