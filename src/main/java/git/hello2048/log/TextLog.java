package git.hello2048.log;

import java.text.SimpleDateFormat;
import java.util.Date;

import git.hello2048.log.Type;

class TextLog {
    protected TextLog(Type type,String message,boolean ChineseMode) {
        SimpleDateFormat sd;
        if(ChineseMode) {
            sd = new SimpleDateFormat
                    ("yyyy年MM月dd日HH时mm分ss秒");
        } else {
            sd = new SimpleDateFormat
                    ("yyyy-MM-dd HH:mm:ss");
        }
        switch(type) {
            case INFO:
                i(message,sd);
                break;
            case I:
                i(message,sd);
                break;
            case WARN:
                w(message,sd);
                break;
            case W:
                w(message,sd);
                break;
            case ERRO:
                e(message,sd);
                break;
            case E:
                e(message,sd);
                break;
            case D:
                d(message,sd);
                break;
            case DEV:
                d(message,sd);
                break;
        }
    }

    private static final void d(String message,SimpleDateFormat timeformat) {
        System.out.println("[" + timeformat.format(new Date()) + "]" + " "
                + "[D]" + " " + message);
    }

    private static final void i(String message,SimpleDateFormat timeformat) {
        System.out.println("[" + timeformat.format(new Date()) + "]" + " "
                + "[I]" + " " + message);
    }

    private static final void w(String message,SimpleDateFormat timeformat) {
        System.out.println("[" + timeformat.format(new Date()) + "]" + " "
                + "[W]" + " " + message);
    }

    private static final void e(String message,SimpleDateFormat timeformat) {
        System.err.println("[" + timeformat.format(new Date()) + "]" + " "
                + "[E]" + " " + message);
    }
}