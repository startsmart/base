package startsmart.base.utility.file;

import startsmart.base.constant.StringConstants;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sanjeev on 25/07/17.
 */
public final class FileUtility {

    public static String readFile(String filePath) throws IOException{
        return readFile(getFile(filePath));
    }

    public static String readFile(File f) throws IOException {
        return Files.readAllLines(f.toPath()).stream().collect(Collectors.joining(System.lineSeparator()));
    }

    public static String safeReadFile(String filePath) {
        return safeReadFile(getFile(filePath));
    }

    public static String safeReadFile(File f) {
        try {
            return  readFile(f);
        } catch (IOException e) {
           return null;
        }
    }

    public static void writeInFile(String content, String filePath) throws IOException {
        writeInFile(content, getFile(filePath));
    }

    public static void writeInFile(String content, File f) throws IOException {
        Files.write(f.toPath(), content.getBytes(), StandardOpenOption.CREATE,
                StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static void appendToFile(String content, String filePath) throws IOException {
        appendToFile(content, getFile(filePath));
    }
    public static void appendToFile(String content, File f) throws IOException {
        Files.write(f.toPath(), content.getBytes(),  StandardOpenOption.CREATE,StandardOpenOption.WRITE, StandardOpenOption.APPEND);
    }

    public static boolean safeAppendToFile(String content, String filePath) {
        try{
            appendToFile(content, getFile(filePath));
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static boolean safeStoreObject(String fileName, Serializable object)
             {
        return safeStoreObject(getFile(fileName), object);
    }

    public static boolean safeStoreObject(File f, Serializable object) {
        try {
            ensureParentDirectories(f);
            deleteFile(f);
            storeObject(f, object);
        } catch (IOException e) {
           return false;
        }
        return true;
    }

    public static void storeObject(String fileName, Serializable object) throws IOException {
        storeObject(getFile(fileName), object);
    }

    public static void storeObject(File f, Serializable object) throws IOException {

        try(ObjectOutputStream oos  = new ObjectOutputStream(new FileOutputStream(f))) {
            oos.writeObject(object);
        }
    }

    public static void storeException(Throwable t, String filePath) throws FileNotFoundException {
        storeException(t, getFile(filePath));
    }

    public static void storeException(Throwable t, File f) throws FileNotFoundException {

        try(PrintStream out = new PrintStream(f)) {
            t.printStackTrace(out);
        }
    }

    public static boolean safeStoreException(Throwable t, String filePath){
        return safeStoreException(t, getFile(filePath));
    }

    public static boolean safeStoreException(Throwable t, File f){
        try {
            ensureParentDirectories(f);
            deleteFile(f);
            storeException(t, f);
            return true;
        } catch (FileNotFoundException e){
            return false;
        }
    }

    public static void ensureParentDirectories(String filePath){
        ensureParentDirectories(getFile(filePath));
    }

    public static void ensureParentDirectories(File f) {
        File p = f.getParentFile();
        if (!p.exists()) {
            p.mkdirs();
        }
    }

    public static boolean createDirectoryPath(String directoryPath) {
        File f = getFile(directoryPath);
        if(!f.exists()) {
            return f.mkdirs();
        } else {
            return true;
        }
    }

    public static void deleteFile(File f){
        if (f.exists()) {
            f.delete();
        }
    }

    public static Object readObjectFromFile(File f) throws IOException, ClassNotFoundException {

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return ois.readObject();
        }
    }

    public static Object readObjectFromFile(String filePath) throws IOException, ClassNotFoundException {
        return readObjectFromFile(getFile(filePath));
    }


    public static Object safeReadObjectFromFile(File f)  {

        try {
            return readObjectFromFile(f);
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    public static Object safeReadObjectFromFile(String filePath)  {
        return safeReadObjectFromFile(getFile(filePath));
    }

    public static List<File> filterFilesRecursive(String path, final String fileExtension){
        return filterFiles(path,fileExtension,true);
    }

    public static List<File> filterFiles(String path, final String fileExtension){
        return filterFiles(path,fileExtension,false);
    }

    private static List<File> filterFiles(String path, final String fileExtension, boolean includeFolder) {
        List<File> files = new ArrayList<>();

        File f = getFile(path);
        if (f.isDirectory()) {
            recursivelyGetFiles(f, new FileTypeFilter(fileExtension,includeFolder), files);
        } else if (f.isFile() && f.getName().endsWith(fileExtension)) {
            files.add(f);
        }
        return files;
    }

    private static void recursivelyGetFiles(File folder, FileFilter filter,
                                            List<File> files) {
        File[] filteredFiles = folder.listFiles(filter);
        for (File f : filteredFiles) {
            if (f.isDirectory()) {
                recursivelyGetFiles(f, filter, files);
            }
            if (f.isFile()) {
                files.add(f);
            }
        }
    }

    /**
     * Deletes the folder content recursively. Run time exception will be thrown in the event of
     * Exception.
     *
     * @param folderPath
     *            Absolute path of the folder whose content needs to be deleted.
     * @return true if and only if the all the content of the directory is
     *         successfully deleted; false otherwise
     */
    public static boolean deleteContentRecursively(String folderPath){
        return deleteContentRecursively(folderPath, false);
    }

    /**
     * Deletes the folder content recursively.The method is designed to handle
     * exception over a boolean parameter. IF the handleException parameter is
     * set to true then any exception occurred will be handled and false value
     * will be returned instead of throwing an Exception. If the handleException
     * is set to false then a run time exception will be thrown in the event of
     * Exception.
     *
     * @param folderPath
     *            Absolute path of the folder whose content needs to be deleted.
     * @param handleException
     *            true to handle exceptions | false to not handle exceptions
     * @return true if and only if the all the content of the directory is
     *         successfully deleted; false otherwise
     */
    public static boolean deleteContentRecursively(String folderPath,
                                                   boolean handleException) {
        try {
            File folder = getFile(folderPath);
            if (folder.isDirectory()) {
                for (File f : folder.listFiles()) {
                    deleteFolder(f);
                }
                return true;
            }
        } catch (Exception e) {
            if (!handleException) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    /**
     * Deletes the folder and its content recursively.The method is designed to
     * handle exception over a boolean parameter. IF the handleException
     * parameter is set to true then any exception occurred will be handled and
     * false value will be returned instead of throwing an Exception. If the
     * handleException is set to false then a run time exception will be thrown
     * in the event of Exception.
     *
     * @param folderPath
     *            Absolute path of the folder which needs to be deleted.
     * @param handleException
     *            true to handle exceptions | false to not handle exceptions
     * @return true if and only if the directory is successfully deleted; false
     *         otherwise
     */
    public static boolean deleteRecursively(String folderPath,
                                            boolean handleException) {
        try {
            File folder = getFile(folderPath);
            deleteFolder(folder);
            return true;
        } catch (Exception e) {
            if (!handleException) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public static void splitTextFile(File f, int maxLine) throws FileNotFoundException, IOException
    {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f))))
        {
            int count = 0;
            String line;
            StringBuilder builder = new StringBuilder();
            String extension = f.getName().contains(StringConstants.DOT) ?
                    f.getName().substring(f.getName().lastIndexOf(StringConstants.DOT)) : StringConstants.EMPTY;
            while((line = reader.readLine()) != null)
            {
                count++;
                builder.append(line);
                builder.append(System.lineSeparator());
                if(count%maxLine == 0)
                {
                    createSplit(builder, f, extension, count);
                    builder = new StringBuilder();
                }
            }
            createSplit(builder, f, extension, count);
        }
    }

    private static void createSplit(StringBuilder builder, File f, String extension, int count) throws IOException {
        if(builder.length() != 0){
            File out = new File(f.getAbsolutePath().replace(extension, "_" + count + extension));
            Files.write(out.toPath(), builder.toString().getBytes());
        }
    }

    private static void deleteFolder(File folder) {
        if (folder.isDirectory()) {
            File[] fList = folder.listFiles();
            if (fList == null || fList.length <= 0) {
                folder.delete();
            }
            for (File f : fList) {
                deleteFolder(f);
            }
            deleteFolder(folder);
        } else {
            folder.delete();
        }
    }

    private static File getFile(String filePath) {
        return new File(filePath);
    }


}
