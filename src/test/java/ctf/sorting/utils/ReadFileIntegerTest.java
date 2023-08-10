package ctf.sorting.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


class ReadFileIntegerTest {

    @Test
    void sorting() {
        List<Integer> actual = new ReadFileInteger().sorting(List.of(List.of(1, 4, 9), List.of(1, 8, 27)));
        List<Integer> expected = List.of(1, 1, 4, 8, 9, 27);
        assertEquals(expected, actual);

        List<Integer> actual1 = new ReadFileInteger().sorting(List.of(List.of(1, 4, 9), List.of()));
        List<Integer> expected1 = List.of(1, 4, 9);
        assertEquals(expected1, actual1);

        List<Integer> actual2 = new ReadFileInteger().sorting(List.of(List.of(1, 4, 9), List.of(1, 8, 27)));
        List<Integer> expected2 = List.of(1, 1, 4, 8, 9, 27);
        assertEquals(expected2, actual2);
    }
}