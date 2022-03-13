package top.yuyanmc.run;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
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
        cmdArr.add("server.jar");
        String[] cmd=(String[]) CastUtil.cast(cmdArr.toArray(),String.class);
        try {
            ProcessBuilder processBuilder=new ProcessBuilder(cmd);
            processBuilder.directory(new File("servers/"+name+"/"));
            processBuilder.redirectOutput(Redirect.INHERIT);
            processBuilder.redirectInput(Redirect.INHERIT);
            processBuilder.redirectError(Redirect.INHERIT);
            Process process=processBuilder.start();
            while(true){
                try{
                    process.exitValue();
                    break;
                }catch(IllegalThreadStateException e){

                }
            }
        } catch (IOException e) {
            System.err.println("Error: server not found.");
        }
    }
}
