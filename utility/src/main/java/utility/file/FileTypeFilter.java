package utility.file;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by sanjeev on 25/07/17.
 */
public class FileTypeFilter implements FileFilter {

    private String fileType = null;
    private boolean includeFolder = false; //Skip folders from filtering if false else otherwise;

    public FileTypeFilter()
    {
    }

    public FileTypeFilter(String fileType)
    {
        this.fileType = fileType;
    }

    public FileTypeFilter(String fileType, boolean includeFolder)
    {
        this.fileType = fileType;
        this.includeFolder = includeFolder;
    }


    @Override
    public boolean accept(File pathname) {

        return ((this.includeFolder && pathname.isDirectory()) || (pathname.isFile() && pathname
                .getName().endsWith(this.fileType)));
    }
}
