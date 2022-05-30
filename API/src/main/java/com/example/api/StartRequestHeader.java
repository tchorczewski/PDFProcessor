package com.example.api;

public class StartRequestHeader {
    private final String Base64Pdf;
    private final Enums.ShortcutType ShortcutType;

    public StartRequestHeader(String base64Pdf, Enums.ShortcutType shortcutType) {
        Base64Pdf = base64Pdf;
        ShortcutType = shortcutType;
    }

    public Enums.ShortcutType getShortcutType() {
        return ShortcutType;
    }
    public String getBase64Pdf(){
        return Base64Pdf;
    }
}
