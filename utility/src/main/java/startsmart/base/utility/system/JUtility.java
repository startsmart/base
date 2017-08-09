package startsmart.base.utility.system;

import startsmart.base.utility.datetime.DateUtility;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by sanjeev on 03/08/17.
 */
public class JUtility {

    private JUtility()
    {
    }

    public static void delay(long millis)
    {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void delay(long millis, boolean verbose)
    {
        PrintStream out = verbose ? System.out : null;
        delay(millis, out);
    }

    public static void delay(long millis, PrintStream out)
    {
        try
        {
            if(out != null) threadLog("Waiting for... " + DateUtility.getHumanReadableTime(millis), out);
            Thread.sleep(millis);
            if(out != null) threadLog("Completed waiting.", out);
        }
        catch (Exception e)
        {
            if(out != null)
            {
                threadLog("Exception while waiting. " + e, out);
                throw new RuntimeException(e);
            }
        }
    }

    public static void threadLog(String message)
    {
        threadLog(message, System.out);
    }

    public static void threadLog(String message, PrintStream out)
    {
        String msg = DateUtility.getFormattedCurrentDate("MMM dd yyyy kk:mm:ss:SSS");
        msg += " - ["  + Thread.currentThread().getName();
        msg += "]: "  + message;
        out.println(msg);
    }

    public static String extractStringConstantsFromJava(String srcFilePath) throws IOException {
        return extractStringConstantsFromJava(srcFilePath, null);
    }

    public static String extractStringConstantsFromJava(String srcFilePath, String className) throws IOException {
        String packageName = null;
        String data = extractCleanData(srcFilePath);
        StringBuilder constantFile = new StringBuilder();

        setPackageInfo(packageName, data, constantFile);
        setTypeInfo(className, data, constantFile);

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(data);
        List<String> store = new ArrayList<>();

        while (m.find())
        {
            String d = m.group(1);
            if(store.contains(d))
            {
                continue;
            }
            store.add(d);
            addConstant(d, constantFile);
        }
        constantFile.append("}");
        return  constantFile.toString();
    }

    private static void addConstant(String d, StringBuilder constantFile) {
        String variableName = d.trim().replaceAll("\\s+", "_").toUpperCase();
        variableName = variableName.replaceAll("([^A-Z 0-9 _])*", "");
        if(variableName.isEmpty())
        {
            variableName = "VAR_" + System.currentTimeMillis();
        }
        variableName = variableName.replaceAll("_+", "_");
        constantFile.append("\tpublic static final String ");
        constantFile.append(variableName);
        constantFile.append(" =  ");
        constantFile.append("\"");
        constantFile.append(d);
        constantFile.append("\";");
        constantFile.append(System.lineSeparator());
    }

    private static void setTypeInfo(String className, String data, StringBuilder constantFile) {
        if(className == null || className.isEmpty())
        {
            className = extractTypeName(data) + "Constant";
        }

        constantFile.append("public class ");
        constantFile.append(className);
        constantFile.append(System.lineSeparator());
        constantFile.append("{");
        constantFile.append(System.lineSeparator());
    }

    private static void setPackageInfo(String packageName, String data, StringBuilder constantFile) {
        if((packageName == null || packageName.isEmpty()) && data.contains("package"))
        {
            packageName = StringUtil.substringBetween(data, "package", ";");
            packageName = packageName.replaceAll("\\s+", "");
        }
        if(packageName != null && !packageName.isEmpty())
        {
            constantFile.append("package ");
            constantFile.append(packageName);
            constantFile.append(";");
            constantFile.append(System.lineSeparator());
        }
    }

    private static String extractTypeName(String data){
        String type = determineType(data);
        String className = StringUtil.substringBetween(data, type, "{");
        if(className.contains("extends"))
        {
            className = StringUtil.substringBefore(className, "extends");
        }
        if(className.contains("implements"))
        {
            className = StringUtil.substringBefore(className, "implements");
        }
        if(className.contains("<"))
        {
            className = StringUtil.substringBefore(className, "<");
        }
        className = className.replaceAll("\\s+", "");
        return className;
    }

    private static String determineType(String data){
        Map<Integer, String> store = new TreeMap<>();
        store.put(data.indexOf("class") , "class");
        store.put(data.indexOf("interface") , "interface");
        store.put(data.indexOf("@interface") , "@interface");
        store.put(data.indexOf("enum") , "enum");
        int min = Integer.MAX_VALUE;
        for(Integer key : store.keySet()){
            if(key != -1 && key < min){
                min = key;
            }
        }
        String type = store.get(min);
        if(type == null){
            throw new IllegalArgumentException("Invalid java file, type value not found");
        }
        return type;
    }

    private static String extractCleanData(String srcFilePath) throws IOException {
        File srcFile = new File(srcFilePath);
        List<String> allLines = Files.readAllLines(srcFile.toPath());
        String data = allLines.stream().collect(Collectors.joining("\n"));
        data = data.replaceAll("\\s+", " ");
        data = data.replaceAll("[]", "\"");
        return data;
    }


}
