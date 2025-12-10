package com.deliver.task1.parser;

import com.deliver.task1.exeption.CustomException;
import com.deliver.task1.parser.impl.RowDataParserImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RowDataParserTest {
    private RowDataParser parser;

    @BeforeEach
    void setUp() {
        parser = new RowDataParserImpl();
    }

    @Test
    void testParserValidLines() throws CustomException {
        List<String> lines = List.of("1 2 3", "-5; 6, 7", "10");

        List<int[]> result = parser.readData(lines);

        assertEquals(3, result.size(), "Should parse three rows");

        assertArrayEquals(new int[]{1, 2, 3}, result.get(0));
        assertArrayEquals(new int[]{-5, 6, 7}, result.get(1));
        assertArrayEquals(new int[]{10}, result.get(2));
    }

    @Test
    void testIgnoresInvalidLines() throws CustomException {
        List<String> lines = List.of("1 2 3", "abc", "5 @ 6", "-1 0 2");

        List<int[]> result = parser.readData(lines);

        assertEquals(2, result.size(), "Should ignore invalid lines");
        assertArrayEquals(new int[]{1, 2, 3}, result.get(0));
        assertArrayEquals(new int[]{-1, 0, 2}, result.get(1));
    }

    @Test
    void testReadData_ThrowsException_WhenAllLinesInvalid() {
        List<String> lines = List.of("abc", "@@", "   ", "z12");

        assertThrows(CustomException.class,
                () -> parser.readData(lines),
                "Should throw exception if no valid numbers found");
    }

    @Test
    void testReadData_ParsesNegativeNumbersCorrectly() throws CustomException {
        List<String> lines = List.of("-1 -2 -3", "10 -20 30");

        List<int[]> result = parser.readData(lines);

        assertArrayEquals(new int[]{-1, -2, -3}, result.get(0));
        assertArrayEquals(new int[]{10, -20, 30}, result.get(1));
    }

    @Test
    void testParseEmptyList() {
        List<String> lines = List.of();

        assertThrows(CustomException.class,
                () -> parser.readData(lines),
                "Empty input list must throw CustomException");
    }

    @Test
    void testParseLineWithExtraSymbols() throws CustomException {
        List<String> lines = List.of("!!!", "abc", "1 2 3");

        List<int[]> result = parser.readData(lines);

        assertEquals(1, result.size(), "Should be one row with numbers 1 2 3");
        assertArrayEquals(new int[]{1, 2, 3}, result.get(0));

    }
}
