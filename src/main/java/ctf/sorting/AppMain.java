package ctf.sorting;

import java.util.List;

import static ctf.sorting.utils.AppUtils.*;

public class AppMain {
    public static void main(String[] args) {

        //чтение аргументов
        readArgs(args);
       //чтение исходных данных и сортировка
        List<?> result = getReadFile().sorting(getReadFile().readFromFile(getListInputFileNames()));
        //запись результата
        getReadFile().writeToFile("out.txt", result);

    }

}
