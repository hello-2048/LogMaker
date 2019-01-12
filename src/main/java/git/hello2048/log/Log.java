package git.hello2048.log;

import git.hello2048.log.Type;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {
    public Log(boolean FMode,String message,Type type,boolean ChineseMode) throws Exception{
        if(FMode){
            new FileLog();
            try {
                new FileLog(message);
            } catch (Exception e) {
                File file = new File("\\erro.log");
                if(file.exists()){
                    // nothing
                }else{
                    try {
                        file.createNewFile();
                    } catch (IOException e1) {
                        e1 = null;
                        type = null;
                        System.err.println("导出日志失败!");
                        System.gc();
                        System.exit(5);
                        return;
                    }
                }
                PrintWriter printWriter = new PrintWriter(file);
                e.printStackTrace(printWriter);
                printWriter.close();
            }
        }else{
            new TextLog(type,message,ChineseMode);
        }
    }
}