package top.yuyanmc;

import top.yuyanmc.install.Installer;

public class App {
    public static void main(String[] args){
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
            }
        }
    }
}
