package ctf.sorting.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Интерфейс для реализации методов чтения и сортировки
 * в зависимости от входящих данных
 */
public interface ReadFile {

    /**
     * @param inputFileNames список имен файлов для слияния
     * @return считанные строки из файлов
     */
    <T> List<List<T>> readFromFile(List<String> inputFileNames);

    /**
     * сортировка слиянием
     *
     * @param inputList списки на сортировку
     * @return отсортированный список
     */
    <T> List<T> sorting(List<List<T>> inputList);

    /**
     * Метод записи отсортированных данных
     *
     * @param fileName        имя файла для записи
     * @param listDataToWrite список для записи
     */
    default <T> void writeToFile(String fileName, List<T> listDataToWrite) {
        try (BufferedWriter writerToFile = new BufferedWriter(new FileWriter(fileName, StandardCharsets.UTF_8))) {
            for (var num : listDataToWrite) {
                writerToFile.write(num + "\n");
                writerToFile.flush();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
