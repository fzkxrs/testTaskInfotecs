package model;

public class FtpConnectionData {
    private String ftpUrl;
    private String filename;

    private final String ip;
    private final int port;

    public FtpConnectionData(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void makeFtpUrl(UserData userData, String filename) {
        this.ftpUrl =
                "ftp://" + userData.getLogin() + ":" + userData.getPassword() +
                        "@" + ip + ":" + port + "/";
        this.filename = filename;
    }

    public String getFtpUrl() {
        return ftpUrl;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

}
