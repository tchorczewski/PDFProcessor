public class StartHeader {
    private String Base64Pdf;
    private Enums.ShortcutType ShortcutType;

    public StartHeader(String base64Pdf, Enums.ShortcutType shortcutType) {
        Base64Pdf = base64Pdf;
        ShortcutType = shortcutType;
    }
    public StartHeader(){}

    public Enums.ShortcutType getShortcutType() {
        return ShortcutType;
    }
    public String getBase64Pdf(){
        return Base64Pdf;
    }
    public void setBase64Pdf(String base64Pdf){
        Base64Pdf = base64Pdf;
    }
    public void setShortcutType(Enums.ShortcutType shortcutType){
        ShortcutType = shortcutType;
    }
}
