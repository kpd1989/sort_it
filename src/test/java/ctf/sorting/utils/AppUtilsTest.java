package ctf.sorting.utils;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class AppUtilsTest {

    @Test
    void readArgs() {

        Assertions.assertEquals("in1.txt", AppUtils.readArgs(new String[]{"-i", "in1.txt", "in2.txt"}).get(0));
        Assertions.assertEquals(2, AppUtils.readArgs(new String[]{"-i", "in1.txt", "in2.txt"}).size());
    }
}