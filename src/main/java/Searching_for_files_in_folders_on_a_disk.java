import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для поиска файлов в папках на диске.
 * Можно использовать два метода:
 * 1. searchFiles - для поиска файлов по расширению (.jpg).
 * 2. searchingFiles - для поиска файлов по имени или части имени.
 */
public class Searching_for_files_in_folders_on_a_disk {

    /**
     * Главный метод программы.
     * Выполняет поиск файлов, соответствующих определённому условию,
     * начиная с корневой директории "D:\".
     *
     * @param args Аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        ArrayList<File> fileList = new ArrayList<>();

        // Можно использовать этот метод для поиска .jpg файлов
//         searchFiles(new File("D:\\"), fileList);
//         for (File file : fileList) {
//             System.out.println(file);
//         }

       //  Используем метод поиска по имени (или части имени)
        searchingFiles(new File("D:\\"), fileList);
        for (File file : fileList) {
            System.out.println(file);
        }
    }

    /**
     * Метод для рекурсивного поиска файлов с расширением ".jpg".
     *
     * @param rootFile Начальная директория, с которой начинается поиск
     * @param fileList Список, в который добавляются найденные файлы
     */
    private static void searchFiles(File rootFile, List<File> fileList) {
        if (rootFile.isDirectory()) {
            System.out.println("searching at: " + rootFile.getAbsolutePath());
            File[] directoryFiles = rootFile.listFiles();

            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    // Рекурсивный вызов, если файл — это папка
                    if (file.isDirectory()) {
                        searchFiles(file, fileList);
                    } else {
                        // Добавляем файл, если он заканчивается на ".jpg"
                        if (file.getName().toLowerCase().endsWith(".jpg")) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }

    /**
     * Метод для рекурсивного поиска файлов по точному или частичному совпадению имени.
     * Здесь можно легко заменить условие — искать по части имени, по окончанию или по точному совпадению.
     *
     * @param fileName Начальная директория для поиска
     * @param fileList Список, в который добавляются подходящие файлы
     */
    private static void searchingFiles(File fileName, List<File> fileList) {
        if (fileName.isDirectory()) {
            System.out.println("searching at: " + fileName.getAbsolutePath());
            File[] directoryFiles = fileName.listFiles();

            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        // Рекурсивный вызов для перехода в подкаталог
                        searchingFiles(file, fileList);
                    } else {
                        // Условия поиска файла:

                        // Найти файл по части имени
                        //if (file.getName().toLowerCase().contains("ищу")) {

                        // Найти файл, если имя заканчивается на "ищу.txt"
                         //if (file.getName().toLowerCase().endsWith("ищу.txt")) {

                        // Найти файл с точным именем "тебя ищу.txt" (игнорируя регистр)
                        if (file.getName().equalsIgnoreCase("тебя ищу.txt")) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }
}
