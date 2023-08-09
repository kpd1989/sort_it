package ctf.sorting.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Вспомогательный класс
 * для считывания данных запуска
 */
public class AppUtils {

    //для чтения данных, храним названия переданных файлов
    private static List<String> inputFileNames;
    //
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
            if (arg.contains("in")) {
                inputFileNames.add(arg);
            }
        }
    }

}
