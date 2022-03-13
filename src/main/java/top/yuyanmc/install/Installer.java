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
        if(dirCreator.exists()){
            System.out.print("Warning: server already exists. Continue? (y/n) ");
            char c;
            do{
                try {
                    c = (char)System.in.read();
                    System.in.skip(1024);
                    if(c=='n'){
                        return;
                    }else if(c=='y'){
                        break;
                    }else{
                        System.out.print("Please type 'y' or 'n': ");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }while(true);
        }
        System.out.println("1. Creating directory.");
        dirCreator.mkdirs();
        System.out.println("2. Downloading server.jar.");
        WebUtil.downloadNet(path, "servers/"+name+"/server.jar");
        try {
            System.out.println("3. Writing eula.txt");
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
