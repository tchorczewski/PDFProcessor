package com.api.shortcutmakers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5ShortcutMaker {
    public static String GetMD5Shortcut(byte[] file) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        file = digest.digest(file);
        StringBuilder hexString = new StringBuilder(2 * file.length);
        for (int i = 0; i < file.length; i++) {
            String hex = Integer.toHexString(0xff & file[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
