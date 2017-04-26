import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

/**
 * Created by Pawel on 2017-04-22.
 */
public class FtpConnectionTest {

    private final FtpActions ftpActions = new FtpActions();

    @Test
    public void name() throws Exception {
        FTPClient ftpClient = FtpConnectionFactory.ftpConnection("winiar", "winiar", "localhost");
//        ftpActions.printDataAll(ftpClient);
        ftpActions.downloadFiles("/TESTING", ftpClient, "D:\\WORKSPACE\\testing\\");

    }


}
