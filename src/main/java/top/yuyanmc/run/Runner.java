package top.yuyanmc.run;

import java.io.IOException;
import java.util.ArrayList;
import top.yuyanmc.util.CastUtil;

public class Runner {
    private String name;
    public Runner(String name){
        this.name=name;
    }
    public void run(){
        ArrayList<String> cmdArr=new ArrayList<String>();
        cmdArr.add("java");
        cmdArr.add("-jar");
        cmdArr.add("servers/"+name+"/server.jar");
        String[] cmd=(String[]) CastUtil.cast(cmdArr.toArray(),String.class);
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
