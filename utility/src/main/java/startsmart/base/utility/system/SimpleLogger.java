package startsmart.base.utility.system;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

/**
 * Created by sanjeev on 27/06/18.
 */
public final class SimpleLogger {

    private SimpleDateFormat format = new SimpleDateFormat("MMM dd yyyy kk:mm:ss:SSS");
    private PrintStream out;
    private PrintStream err;
    private boolean isVerbose;
    private boolean console;

    private SimpleLogger(){}

    public static SimpleLogger getLogger(){
        return getLogger(null,null,false,true);
    }

    public static SimpleLogger getLogger(PrintStream out, PrintStream err){
       return getLogger(out,err,false);
    }

    public static SimpleLogger getLoggerWithoutConsole(PrintStream out, PrintStream err){
        return getLogger(Objects.requireNonNull(out),Objects.requireNonNull(err),false,false);
    }

    public static SimpleLogger getLogger(PrintStream out, PrintStream err, boolean verbose){
       return getLogger(out,err,verbose,true);
    }

    private static SimpleLogger getLogger(PrintStream out, PrintStream err, boolean verbose, boolean console){
        SimpleLogger logger = new SimpleLogger();
        logger.setOut(out);
        logger.setErr(err);
        logger.setVerbose(verbose);
        logger.setConsole(console);
        return logger;
    }


    private void setVerbose(boolean verbose){
        isVerbose = verbose;
    }

    private void setConsole(boolean console){
        isVerbose = console;
    }

    private void setOut(PrintStream outStream){
        out = outStream;
    }

    private void setErr(PrintStream errStream){
        err = errStream;
    }

    public void error(String msg){
        error(msg, "ERROR");
    }

    public void warn(String msg){
        error(msg, "WARN", isVerbose);
    }

    private void error(String msg, String level){
        error(msg,level,true);
    }

    private void error(String msg, String level, boolean verbose){
        String formatted = formatMsg(msg,level);
        if(err != null) err.println(formatted);
        if(verbose && console) System.err.println(formatted);
    }

    public void error(String msg, Throwable throwable){
        error(msg);
        error(throwable);
    }

    public void error( Throwable throwable){
        if(err != null) err.print(formatMsg("","ERROR"));
        throwable.printStackTrace(err);
        if(console) System.err.println(formatMsg(throwable.getMessage(),"ERROR"));
    }

    public void info(String msg){
        String formatted = formatMsg(msg, "INFO");
        if(out != null) out.println(formatted);
        if(console) System.out.println(formatted);
    }

    public String formatMsg(String msg,String level){
        return format.format(Calendar.getInstance().getTime()).toUpperCase() + " [" + level + "] "+ msg;
    }
}
