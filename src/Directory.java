import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Directory {
    private final ArrayList<String> directories = new ArrayList<>();
    private File directory;

    public Directory() {
    }

    public Directory(String path) {
        setDirectory(path);
    }

    public void addFolder(String folder) {
        if (folder != null && !folder.isEmpty()) {
            directories.add(folder);
        }
    }

    public void changeFolder(String oldFolder, String newFolder) {
        if (oldFolder != null && newFolder != null && !oldFolder.isEmpty() && !newFolder.isEmpty()) {
            int index = directories.indexOf(oldFolder);
            if (index != -1) {
                directories.set(index, newFolder);
            }
        }
    }

    public void deleteFolder(String name) {
        directories.remove(name);
    }

    public File getDirectory() {
        directory = new File(toString());
        return directory;
    }

    public void setDirectory(String path) {
        if (path != null && !path.isEmpty()) {
            Scanner scanner = new Scanner(path);
            scanner.useDelimiter("\\\\");
            while (scanner.hasNext()) {
                directories.add(scanner.next());
            }
        }
    }

    public boolean isExists() {   //проверка есть ли такая директория
        directory = new File(toString());
        return directory.isDirectory();
    }

    public boolean create() {     //создаём дирректорию, если она ещё не была создана
        if (!isExists()) {
            return directory.mkdirs();
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Directory other = (Directory) obj;
        return directories.equals(other.directories);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + directories.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (String folder : directories) {
            string.append(folder);
        }
        return string.toString();
    }
}

