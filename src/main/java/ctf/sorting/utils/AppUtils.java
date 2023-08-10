package ctf.sorting.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для считывания данных запуска
 */
public class AppUtils {

    //для чтения данных, храним названия переданных файлов
    private static List<String> inputFileNames;
    //стратегия чтения и сортировки данных
    //по умолчанию String
    private static ReadFile readFile = new ReadFileString();

    public static ReadFile getReadFile() {
        return readFile;
    }
    public static List<String> getInputFileNames() {
        return inputFileNames;
    }

    public static void readArgs(String[] args) {
        inputFileNames=new ArrayList<>();

        for (String arg : args) {
            if (arg.equals("-i")) {
                readFile = new ReadFileInteger();
                continue;
            } else if (arg.equals("-s")) {
                readFile = new ReadFileString();
                continue;
            }
            if (arg.contains("txt")) {
                inputFileNames.add(arg);
            }
        }
        if (inputFileNames.size()!=2 || !inputFileNames.contains("txt")){
            System.out.println("Укажите в вызове программы два файла для сортировки");
            System.exit(1);
        }
    }
}
