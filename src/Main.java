public class Main {
    /* Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
    вывести на консоль содержимое, дополнить, удалить. */
    public static void main(String[] args) {
        TextFile file = new TextFile();
        file.setDirectory("D:\\Test Directory");
        file.setFileName("new file");
        file.create();
        file.addToFile("Text in file.");
        System.out.println("File contents:");
        file.printContent();
        file.addToFile(" Add some text in file");
        System.out.println("File contents:");
        file.printContent();
        System.out.println("File address " + file.getFile());
        file.rename("second file");
        System.out.println("\nAfter renaming:");
        System.out.println("File address " + file.getFile());
        file.delete();
    }
}
