package file.encode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Encode {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String suffix = ".txt";
		File srcfile = new File("src" + suffix);
		File encodeFile = new File("encode" + suffix);
		File recoverFile = new File("recover" + suffix);

		FileInputStream fileInputStream = new FileInputStream(srcfile);
		encodeFile.createNewFile();
		FileOutputStream fileOutputStream = new FileOutputStream(encodeFile);

		byte[] tempbytes = new byte[1024];
		int byteread = 0;
		while ((byteread = fileInputStream.read(tempbytes)) != -1) {
			fileOutputStream.write(change(tempbytes), 0, byteread);
		}

		fileOutputStream.flush();
		fileOutputStream.close();
		fileInputStream.close();

		fileInputStream = new FileInputStream(encodeFile);
		fileOutputStream = new FileOutputStream(recoverFile);
		recoverFile.createNewFile();
		tempbytes = new byte[1024];
		byteread = 0;
		while ((byteread = fileInputStream.read(tempbytes)) != -1) {
			fileOutputStream.write(change(tempbytes), 0, byteread);
		}
		fileOutputStream.flush();
		fileOutputStream.close();
		fileInputStream.close();

	}

	public static byte[] change(byte[] buff) {
		for (int i = 0; i < buff.length; i++) {
			buff[i] = (byte) ~buff[i];
		}
		return buff;
	}
}
