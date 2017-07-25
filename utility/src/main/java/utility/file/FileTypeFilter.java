package utility.file;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by sanjeev on 25/07/17.
 */
public class FileTypeFilter implements FileFilter {

    private String fileType;
    private boolean includeFolder;

    public FileTypeFilter()
    {
        this.fileType = "";
        this.includeFolder = false;
    }

    public FileTypeFilter(String fileType)
    {
        this();
        this.fileType = fileType == null ? this.fileType : fileType;
    }

    public FileTypeFilter(String fileType, boolean includeFolder)
    {
        this(fileType);
        this.includeFolder = includeFolder;
    }

    @Override
    public boolean accept(File pathname) {

        return ((this.includeFolder && pathname.isDirectory()) || (pathname.isFile() && pathname
                .getName().endsWith(this.fileType)));
    }
}
