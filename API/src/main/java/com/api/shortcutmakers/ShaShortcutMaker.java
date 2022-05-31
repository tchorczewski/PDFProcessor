package com.api.shortcutmakers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShaShortcutMaker {
        public static String GetShaShortcut(byte[] file) throws NoSuchAlgorithmException {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
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
