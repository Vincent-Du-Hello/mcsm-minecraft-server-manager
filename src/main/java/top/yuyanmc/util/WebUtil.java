package top.yuyanmc.util;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.io.FileNotFoundException;
import java.io.IOException;
public class WebUtil {
    public static void downloadNet(String path,String file) throws MalformedURLException {
        int byteread = 0;
        URL url = new URL(path);
        try {
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            while ((byteread = inStream.read(buffer)) != -1) {
                fs.write(buffer, 0, byteread);
            }
            fs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
