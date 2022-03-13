package top.yuyanmc.util;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.FileNotFoundException;
import java.io.IOException;
public class WebUtil {
    public static void downloadNet(String path,String file) throws MalformedURLException {
        int byteread = 0;
        long total=0;
        long read=0;
        URL url = new URL(path);
        try {
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            total=getRemoteFileSize(path);
            System.out.println("File size: "+String.valueOf(total)+"bytes");
            while ((byteread = inStream.read(buffer)) != -1) {
                read+=byteread;
                fs.write(buffer, 0, byteread);
                System.out.print("\r"+String.valueOf(1.0d*read/total*100).substring(0,Math.min(4,String.valueOf(1.0d*read/total*100).length()))+"% \t"+String.valueOf(read)+"bytes");
            }
            System.out.print("\r");
            fs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static long getRemoteFileSize(String url) {
        long size = 0;
        try {
            HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();
            size = conn.getContentLength();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }
}
