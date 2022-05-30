import org.springframework.web.reactive.function.client.WebClient;

public class ResponseHeader{
    public  String fileShortcut;
    public String errorCode;
    public  String errorDsc;

    public ResponseHeader(String fileShortcut, String errorcode, String errorDsc) {

        this.fileShortcut = fileShortcut;
        this.errorCode = errorcode;
        this.errorDsc = errorDsc;
    }
    public ResponseHeader(){}

    public String getFileShortcut(){
        return fileShortcut;
    }
}
