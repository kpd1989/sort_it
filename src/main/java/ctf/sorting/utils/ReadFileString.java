package ctf.sorting.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Реализация методов чтения и сортировки для строки
 */
public class ReadFileString implements ReadFile {

    public <T>List<T> sorting(List<List<T>> inputList) {
        List<T> result = new ArrayList<>();

        // вспомогательные индексы для сортировки двух коллекций
        int ind1 = 0;
        int ind2 = 0;

        for (int index = 0; index < (inputList.get(0).size() + inputList.get(1).size()); index++) {
            // если первый список пуст -> записываем значение второго списка
            if (inputList.get(0).size() <= ind1) {
                result.add(inputList.get(1).get(ind2));
                ind2++;
            // если второй список пуст -> записываем значение первого списка
            } else if (inputList.get(1).size() <= ind2) {
                result.add(inputList.get(0).get(ind1));
                ind1++;
            //если значение символов строки первого списка больше второго -> записываем значение второго списка
            } else if (((String)inputList.get(0).get(ind1)).compareTo(((String) inputList.get(1).get(ind2))) > 0) {
                result.add(inputList.get(1).get(ind2));
                ind2++;
            //иначе записываем значение строки первого списка
            } else {
                result.add(inputList.get(0).get(ind1));
                ind1++;
            }
        }
        return result;
    }

    public <T>List<List<T>> readFromFile(List<String> inputFileNames) {
        //создаем экземпляр общего хранилища прочитанных данных
        DataWithFiles<T> dataWithFiles = new DataWithFiles<>();

        for (String nameFile : inputFileNames) {
            try (BufferedReader readerFromFile = new BufferedReader(new FileReader(nameFile, StandardCharsets.UTF_8))) {
                List<String> dataWithFile = new ArrayList<>();
                //вспомогательная переменная для временного хранения строки
                String readedLine;

                while ((readedLine = readerFromFile.readLine()) != null) {
                    //проверяем строку на наличие пробелов
                    //при наличии пробеза заканчиваем чтение
                    try {
                        char[] characters = readedLine.toCharArray();
                        for (Character ch : characters) {
                            if (ch == ' ') {
                                throw new IllegalArgumentException("В файле " + nameFile + ", строка <" + readedLine + "> содержит пробел\n");
                            }
                        }
                    } catch (IllegalArgumentException ex) {
                        System.err.printf(ex.getMessage());
                        break;
                    }
                    dataWithFile.add(readedLine);
                }
                dataWithFiles.listDataFromFile.add((List<T>) dataWithFile);

            } catch (IOException ex) {
                System.err.println("Ошибка доступа к файлу " + nameFile);
                throw new RuntimeException(ex);
            }
        }
        return dataWithFiles.listDataFromFile;
    }

}
