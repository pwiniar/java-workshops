import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;

/**
 * Created by Pawel on 2017-04-22.
 */
public class FtpConnectionFactory {


    public static FTPClient ftpConnection(String user, String pass, String server) {
        int port = 21;
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            showServerReply(ftpClient);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Operation failed. Server reply code: " + replyCode);
            }
            boolean success = ftpClient.login(user, pass);
            showServerReply(ftpClient);
            if (!success) {
                System.out.println("Could not login to the server");
            } else {
                System.out.println(String.format(
                        "Connected to:%s with user:%s and password:%s",
                        server, user, pass.substring(0, pass.length()).replaceAll(".", "*")));
                return ftpClient;
            }
        } catch (IOException ex) {
            System.out.println("Oops! Something wrong happened");
            ex.printStackTrace();
        }
        throw new RuntimeException();
    }


    private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                if (aReply != null) {
                    System.out.println("SERVER: " + aReply);
                }
            }
        }
    }
}
