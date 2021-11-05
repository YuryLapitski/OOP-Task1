import java.io.File;
import java.io.IOException;

public class MyFile {
    private Directory directory = new Directory();
    private String fileName;
    private String expansion;
    private File file;

    public MyFile() {
    }

    public MyFile(String path, String fileName, String expansion) {
        setDirectory(path);
        setFileName(fileName);
        setExpansion(expansion);
        file = new File(directory.getDirectory(), fileName + "." + expansion);
    }

    public File getFile() {
        return file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        if (fileName != null && !fileName.isEmpty()) {
            this.fileName = fileName;
            file = new File(directory.getDirectory(), fileName + "." + expansion);
        }
    }

    public String getExpansion() {
        return expansion;
    }

    public void setExpansion(String expansion) {
        if (expansion != null && !expansion.isEmpty()) {
            this.expansion = expansion;
            file = new File(directory.getDirectory(), fileName + "." + expansion);
        }
    }

    public String getDirectory() {
        return directory.toString();
    }

    public void setDirectory(String path) {
        if (path != null && !path.isEmpty()) {
            directory.setDirectory(path);
            file = new File(directory.getDirectory(), fileName + "." + expansion);
        }
    }

    public boolean isExists() {
        return file.isFile();
    }

    public boolean create() {
        if (!isExists()) {
            if (!directory.isExists()) {
                directory.create();
            }
            try {
                return file.createNewFile();
            } catch (IOException ex) {
                return false;
            }

        } else {
            return false;
        }
    }

    public boolean delete() {
        if (isExists()) {
            return file.delete();
        } else {
            return false;
        }
    }

    public boolean rename(String name) {
        File newFile = new File(directory.getDirectory(), name + "." + expansion);
        boolean isRenamed = false;
        if (isExists() && !newFile.exists()) {
            isRenamed = file.renameTo(newFile);
        }
        if (isRenamed) {
            setFileName(name);
        }
        return isRenamed;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        MyFile other = (MyFile) obj;
        return directory.equals(other.directory) && fileName.equals(other.fileName)
                && expansion.equals(other.expansion);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((fileName == null) ? 0 : fileName.hashCode());
        result = 31 * result + ((expansion == null) ? 0 : expansion.hashCode());
        result = 31 * result + directory.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return directory.toString() + "//" + fileName + "." + expansion;
    }
}
