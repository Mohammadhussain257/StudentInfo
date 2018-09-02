package com.techsoft.studentinfo.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.Part;

public class WriteDataToFileUtil {
	public final static String FILE_PATH = "E:/SaveImage/";
	public static String writeToFile(Part part, String Url) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = part.getInputStream();
			out = new FileOutputStream(Url);
			byte[] b = new byte[2048];
			int content;
			while ((content = in.read(b)) != -1) {
				out.write(b, 0, content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} /*finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		return Url;
	}
	public static String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return "";
	}

}
