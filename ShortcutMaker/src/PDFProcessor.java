import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;




public class PDFProcessor {
    private JButton LoadFileBtn;
    private JTextField DisplayPathTxt;
    private JTextField DisplayShortcutTxt;
    private JRadioButton SHARadioBtn;
    private JRadioButton MD5RadioBtn;
    private JButton saveShortcutButton;
    private JButton exitButton;
    private JButton getShortcutButton;
    private JPanel rootPanel;
    private JLabel FileSaveStatus;
    private ButtonGroup selectShortcutType;
    private static StartHeader header = new StartHeader();
    private static ResponseHeader response = new ResponseHeader();

    public PDFProcessor() {
        selectShortcutType = new ButtonGroup();
        selectShortcutType.add(SHARadioBtn);
        selectShortcutType.add(MD5RadioBtn);
        SHARadioBtn.setSelected(true);


        LoadFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame LoadFileFrame = new Frame("File Select");
                String path = LoadFile.GetLoadedFile(LoadFileFrame);
                LoadFileFrame.dispose();
                try {
                    header.setBase64Pdf(Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get(path))));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                DisplayPathTxt.setText(path);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        getShortcutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (SHARadioBtn.isSelected() == true){
                    header.setShortcutType(Enums.ShortcutType.SHA);
                }
                else{
                    header.setShortcutType(Enums.ShortcutType.MD5);
                }
                WebClient client =  WebClient.builder()
                        .baseUrl("http://localhost:8080/LoadedFile")
                        .build();
                response = client.post()
                        .body(Mono.just(header), StartHeader.class)
                        .retrieve()
                        .bodyToMono(ResponseHeader.class)
                        .block();
                DisplayShortcutTxt.setText(response.getFileShortcut());

            }
        });
        saveShortcutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String shortcut = DisplayShortcutTxt.getText();
                Frame SaveFileFrame = new Frame("Save Your File");
                File file = new File(SaveShortcut.SaveFIle(SaveFileFrame));
               try {
                   PrintWriter writer = new PrintWriter(file);
                   writer.println(shortcut);
                   writer.close();
                   FileSaveStatus.setText("Saved succesfully");
               }
               catch(IOException ex){
                   FileSaveStatus.setText("Error while trying to save");
               }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PDFProcessor");
        frame.setContentPane(new PDFProcessor().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}


