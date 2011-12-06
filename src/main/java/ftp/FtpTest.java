package ftp;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FtpTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SocketException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws SocketException, IOException, InterruptedException {
		for (int i = 0; i < 1; i++) {
			Thread thread = new Thread(new Task());
			thread.start();
		}
	}

}

class Task implements Runnable {

	public void run() {
		FTPClient ftp = new FTPClient();
		try {
			ftp.connect("58.68.239.12");
			ftp.login("rcms", ";)%ty}Ttc;mQ1:poFBapX&pYu_Ig;0&{");
			int reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				System.out.println("FTP server refused connection.");
			}
			ftp.setFileType(2);
			ftp.changeWorkingDirectory("/");
//			String path[] = new String[] { "test", "subtest", "t", "t1", "t2", "t3", "t4", "t5" };

			System.out.println(ftp.mkd("test3"));
			System.out.println(ftp.getStatus());
			System.out.println(ftp.makeDirectory("test"));
			ftp.logout();
			ftp.disconnect();
			System.out.println(Thread.currentThread().getName() + " done.");
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
