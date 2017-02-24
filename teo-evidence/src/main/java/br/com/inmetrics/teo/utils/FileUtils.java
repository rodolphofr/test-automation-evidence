package br.com.inmetrics.teo.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class FileUtils {

	public static File base64ToTempFile(String base64) {
		
		byte[] bytes = Base64.getDecoder().decode(base64);
		File temp = null;
		
		try {
			temp = File.createTempFile("temp", ".tmp");
			BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(temp));
			writer.write(bytes);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return temp;
		
	}
	
}
