package git.hello2048.log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

class FileLog {
    protected FileLog() {
        if(new File("data").exists()) {
            // nothing
        } else {
            new File("data").mkdirs();
        }
        if(new File("data\\lastlog.log").exists()) {
            new File("data\\lastlog.log").
                    renameTo(new File("data\\log-" + new Date().getTime() + ".log"));
            try {
                new File("data\\lastlog.log").createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                new File("data\\lastlog.log").createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    protected FileLog(String message) throws Exception {
        File file = new File("data");
        file.mkdirs();
        file = null;
        file = new File("data\\lastlog.log");
        if(file.exists()) {
            file.delete();
            file.createNewFile();
        } else if(file.exists()) {
            //nothing
        } else {
            file.createNewFile();
        }
        OutFile(file,message);
    }
    private static final void OutFile(File file,String message) throws
            Exception {
        FileOutputStream fos = new FileOutputStream(file);
        if(file.exists() == false) {
            return;
        }
        message = "[" + new Date() + "]" + " " + message + "\n";
        fos.write(message.getBytes());
        fos.close();
    }
}
