package controller;

import model.FtpConnectionData;
import model.UserData;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

public class ConnectionController {
    FtpConnectionData connectionData;
    URLConnection ftpConnection;

    ConnectionController (UserData userData, String filename, String ip, int port) {
        connectionData = new FtpConnectionData(ip, port);
        connectionData.makeFtpUrl(userData, filename);
    }

    public void establishConnection () throws IOException {
        ftpConnection = new URL(connectionData.getFtpUrl()).openConnection();
        InputStream inputStream = ftpConnection.getInputStream();
        Files.copy(inputStream, new File("downloaded_buz.txt").toPath());
        inputStream.close();
    }
    
}
