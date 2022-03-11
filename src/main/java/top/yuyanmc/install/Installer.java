package top.yuyanmc.install;
import top.yuyanmc.util.WebUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
public class Installer{
    private String version;
    private String path;
    private String name;
    public Installer(){

    }
    public Installer(String version,String name){
        this.version=version;
        this.name=name;
    }
    public String analyzePath(){
        path=version;
        return path;
    }
    public void download() throws MalformedURLException{
        File dirCreator=new File("servers/"+name);
        dirCreator.mkdirs();
        WebUtil.downloadNet(path, "servers/"+name+"/server.jar");
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(new File("servers/"+name+"/eula.txt"));
            fileOutputStream.write("eula=true".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void install(){
        analyzePath();
        try {
            download();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
