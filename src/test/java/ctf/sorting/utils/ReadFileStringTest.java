package ctf.sorting.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;



class ReadFileStringTest {

    @Test
    void sorting() {

        List<String> actual = new ReadFileString().sorting(List.of(List.of("а", "б", "д"), List.of("а", "б", "в")));
        List<String> expected = List.of("а", "а", "б", "б", "в", "д");
        assertEquals(expected, actual);

        List<String> actual1 = new ReadFileString().sorting(List.of(List.of("а", "б", "в"), List.of()));
        List<String> expected1 = List.of("а", "б", "в");
        assertEquals(expected1, actual1);

        List<String> actual2 = new ReadFileString().sorting(List.of(List.of("аа", "бвг", "конец"), List.of("аб", "вгд35%", "иррр")));
        List<String> expected2 = List.of("аа", "аб", "бвг", "вгд35%", "иррр", "конец");
        assertEquals(expected2, actual2);
    }
}