package top.yuyanmc;

import java.io.File;
import top.yuyanmc.config.Config;

import top.yuyanmc.debugger.DebugLogger;
import top.yuyanmc.install.Installer;
import top.yuyanmc.run.Runner;

public class App {
    private static boolean debug;
    private static DebugLogger logger;
    private static Config config;
    public static void main(String[] args){
        long start=System.nanoTime();
        System.out.println("MCSM v0.0.1");
        logger=new DebugLogger();
        debug=false;
        for(String s:args){
            if(s.contentEquals("-d")||s.contentEquals("--debug")){
                debug=true;
                break;
            }
        }
        System.out.print("Loading config");
        config=new Config(new File("mcsm.config.properties"));
        config.setDefault();
        System.out.print("\r");
        if(args.length!=0){
            switch(args[0]){
                case "install":
                    if(args.length==1){
                        System.out.println("Error: please enter minecraft version.");
                        return;
                    }
                    int id=-1;
                    String name=args[1];
                    for(int i=2;i<args.length;i++){
                        if(args[i].contentEquals("--name")){
                            id=i+1;
                            if(args.length<=id){
                                System.out.println("Error: please give a value for \"--name\"");
                                return;
                            }
                        }
                    }
                    if(id!=-1){
                        name=args[id];
                    }
                    Installer installer=new Installer(args[1], name);
                    installer.install();
                    break;
                case "run":
                    if(args.length==1){
                        System.out.println("Error: please enter minecraft instance name.");
                        return;
                    }
                    name=args[1];
                    Runner runner=new Runner(name);
                    runner.run();
                    break;
                case "help":
                    System.out.println("------Help------");
                    System.out.println(" ---Commands---");
                    System.out.println("help: mcsm help");
                    System.out.println("install: mcsm install [url] [--name name]");
                    System.out.println("run: mcsm run [name]");
                    System.out.println(" -----Args-----");
                    System.out.println("debug: -d,--debug");
                    break;
            }
        }
        long end=System.nanoTime();
        System.out.println("\rFinished in "+String.valueOf((end-start)/1000000*1e-3d)+" seconds");
    }
    public static DebugLogger getLogger(){
        return logger;
    }
    public static boolean getDebug(){
        return debug;
    }
    public static Config getConfig(){
        return config;
    }
}
