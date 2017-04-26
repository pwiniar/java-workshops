import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * Created by Pawel on 2017-04-22.
 */
public class FtpActions {

    public void printDataAll(FTPClient ftpFile) throws IOException {
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat();
        dateTimeFormatter.applyPattern("dd-MM-Y HH:mm:ss");

        for (FTPFile file : ftpFile.listFiles("/TESTING")) {
            String format = dateTimeFormatter.format(file.getTimestamp().getTime());

            System.out.println(String.format("File name:%s, size:%d, type:%s, user:%s, %s",
                    file.getName(), file.getSize(), file.getType(), file.getUser(), format));
        }
    }

    public void downloadFiles(String remotePath, FTPClient ftpClient, String localPath) {
        ftpClient.enterLocalPassiveMode();
        createDirectory(localPath);

        try {
            for (FTPFile file : ftpClient.listFiles(remotePath)) {
                String remoteFileName = remotePath + "/" + file.getName();
                File localFile = new File(localPath + file.getName());
                OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(localFile));

                long start = System.nanoTime();
                ftpClient.retrieveFile(remoteFileName, outputStream);
                int replyCode = ftpClient.getReplyCode();
                outputStream.close();
                long endTime = System.nanoTime() - start;

                interpretReplayMessage(file, replyCode, endTime, localFile);
            }
        } catch (IOException e) {
            throw new RuntimeException(String.format("Something went wrong: %s \n %s ", e.getMessage(), Arrays.toString(e.getStackTrace())));
        }
    }

    private void interpretReplayMessage(FTPFile file, int replyCode, long endTime, File localFile) {
        switch (replyCode) {
            case 226:
                System.out.println(String.format("File: %s, size: %d KB has been downloaded successfully in time: %d ms", file.getName(), file.getSize(), endTime / 1000000));
                break;
            case 550:
                System.out.println(String.format("File %s not found.", file.getName()));
                localFile.delete();
                break;
            default:
                throw new IllegalArgumentException(String.format("Code: %s interpretation error", replyCode));
        }
    }

    private void createDirectory(String localPath) {
        File directory = new File(localPath);

        if (!directory.exists()) {
            directory.mkdir();
            System.out.println(String.format("Directory %s doesn't exist. Creating...", directory));
        }
    }
}
