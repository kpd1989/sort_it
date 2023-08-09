package ctf.sorting.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *
 * Интерфейс для реализации методов чтения и сортировки
 * в зависимости от входящих данных
 */
public interface ReadFile<T> {

    /**
     * @param inputFileNames список имен файлов для слияния
     * @return считанные строки из файлов
     */
    List<List<T>> readFromFile(List<String> inputFileNames);

    /**
     * сортировка слиянием
     *
     * @param inputList списки на сортировку
     * @return отсортированный список
     */
    List sorting(List<List<T>> inputList);

    /**
     * Метод записи отсортированных данных
     * @param fileName имя файла для записи
     * @param result список для записи
     */
    default void writeToFile(String fileName, List result) {
        try (BufferedWriter writerToFile = new BufferedWriter(new FileWriter(fileName, StandardCharsets.UTF_8))) {
            for (var num : result) {
                writerToFile.write(num + "\n");
                writerToFile.flush();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
