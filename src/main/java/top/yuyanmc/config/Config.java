package top.yuyanmc.config;

import java.io.File;

import top.yuyanmc.properties.PropertiesEditor;

public class Config extends PropertiesEditor{
    public Config(File file){
        super(file);
    }
    public void setDefault(){
        putDefault("defaultJRE","java");
        save();
    }
}
