import java.awt.*;

public class SaveShortcut {
    public static String SaveFIle(Frame frame) {
        FileDialog fd = new FileDialog(frame);
        fd.setMode(FileDialog.SAVE);
        fd.setFile("*.txt");
        fd.setVisible(true);
        return fd.getDirectory()+fd.getFile();
    }
}
