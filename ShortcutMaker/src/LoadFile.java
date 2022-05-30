import java.awt.*;

public class LoadFile {
    public static String GetLoadedFile(Frame frame) {
        FileDialog fd = new FileDialog(frame);
        fd.setFile("*.pdf");
        fd.setVisible(true);
        return fd.getDirectory() + fd.getFile();
    }
}
