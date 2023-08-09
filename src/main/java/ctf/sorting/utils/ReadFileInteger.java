package ctf.sorting.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Реализация методов чтения и сортировки для чисел
 */
public class ReadFileInteger implements ReadFile<Integer> {

    public List sorting(List<List<Integer>> inputList) {
        List<Integer> result = new ArrayList<>();

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
            } else if (inputList.get(0).get(ind1) > inputList.get(1).get(ind2)) {
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

    public List<List<Integer>> readFromFile(List<String> inputFileNames) {
        //создаем экземпляр общего хранилища прочитанных данных
        ReadDataBase<Integer> readDataBase = new ReadDataBase<>();

        for (String nameFile : inputFileNames) {
            try (BufferedReader readerFromFile = new BufferedReader(new FileReader(nameFile, StandardCharsets.UTF_8))) {
                List<Integer> dataWithFile = new ArrayList<>();
                //вспомогательные переменные для временного хранения считанных данных
                int num;
                String line;
                while ((line = readerFromFile.readLine()) != null) {
                    num = Integer.parseInt(line);
                    dataWithFile.add(num);
                }
                readDataBase.listDataFromFile.add(dataWithFile);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        return readDataBase.listDataFromFile;
    }
}
