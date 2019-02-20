package springbootspringcloud.weatherProject.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 * 编写GZIP解压工具类
 */
public class StringUtil {
	
	
	/**
	 * 处理Gzip压缩的数据
	 * @param str
	 * @return
	 * @throws IOException 
	 */
	public static String conventFromGzip(String str) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in;
		GZIPInputStream gunzip = null;
		in = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
		gunzip = new GZIPInputStream(in);
		byte[] buffer = new byte[256];
		int n;
		while ((n = gunzip.read(buffer)) >= 0) {
			out.write(buffer,0,n);
		}
		return out.toString();
	}

}
