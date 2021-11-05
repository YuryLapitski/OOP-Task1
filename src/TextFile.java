import java.io.*;

public class TextFile extends MyFile {
    String text;
    public TextFile() {
        super();
        super.setExpansion("txt");
    }

    public void addToFile(String text) {
        try {
            FileWriter writer = new FileWriter(getFile(), true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(text);
            bufferWriter.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getContent() {
        StringBuilder build = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(getFile()));
            String line;
            while ((line = reader.readLine()) != null) {
                build.append(line);
                build.append("\n");
            }
            reader.close ();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return build.toString();
    }

    public void printContent() {
        System.out.println(getContent());
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!super.equals(obj))
            return false;
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        TextFile other = (TextFile) obj;
        return text.equals(other.text);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + ((text == null) ? 0 : text.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return text;
    }
}
