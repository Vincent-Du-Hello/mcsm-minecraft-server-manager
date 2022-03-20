package top.yuyanmc.debugger;

import top.yuyanmc.App;

public class DebugLogger {
    public DebugLogger(){
        
    }
    public void info(String s){
        if(App.getDebug()){
            System.out.println(s);
        }
    }
}
