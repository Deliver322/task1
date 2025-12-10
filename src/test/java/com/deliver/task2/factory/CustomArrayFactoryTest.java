package com.deliver.task2.factory;

import com.deliver.task2.entity.CustomArray;
import com.deliver.task2.exeption.CustomException;
import com.deliver.task2.factory.impl.CustomArrayFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayFactoryTest {
    private CustomArrayFactory factory;

    @BeforeEach
    void setUp() {
        factory = new CustomArrayFactoryImpl();

    }

    @Test
    void testCreateValidCustomArray() throws CustomException {
        int id = 1;
        int[] data = {1, 2, 3};

        CustomArray customArray = factory.create(id, data);

        assertEquals(id, customArray.getId(), "Custom Array ID should be equal");
        assertArrayEquals(data, customArray.getArray(), "Custom Array data should be equal");
    }

    @Test
    void testCreateNullIntArray() {
        int id = 1;
        int[] data = null;

        assertThrows(CustomException.class,
                () -> factory.create(id, data),
                "Should throw for null array");
    }

    @Test
    void testCreateEmptyIntArray() {
        int id = 1;
        int[] data = {};

        assertThrows(CustomException.class,
                () -> factory.create(id, data),
                "Should throw for empty array");
    }

    @Test
    void testCreateArraysFromFileWithValidLines(@TempDir Path tempDir) throws Exception {
        Path tempFile = tempDir.resolve("data.txt");
        Files.write(tempFile, List.of("1 2 3", "-5, 6; 7", "8"));

        int startingId = 100;

        List<CustomArray> result = factory.createArraysFromFile(startingId, tempFile.toString());

        assertEquals(3, result.size());

        assertArrayEquals(new int[]{1, 2, 3}, result.get(0).getArray(), " first array should be equal");
        assertArrayEquals(new int[]{-5, 6, 7}, result.get(1).getArray(), " second array should be equal");
        assertArrayEquals(new int[]{8}, result.get(2).getArray(), " third array should be equal");

        assertEquals(100, result.get(0).getId(), "first Custom Array ID should be equal");
        assertEquals(101, result.get(1).getId(), "second Custom Array ID should be equal");
        assertEquals(102, result.get(2).getId(), "third Custom Array ID should be equal");
    }

    @Test
    void testCreateArraysFromFileOfNonValidLines(@TempDir Path tempDir) throws IOException {
        Path tempFile = tempDir.resolve("bad.txt");
        Files.write(tempFile, List.of("aaa", "@@@", "  ", "x12z"));

        int startingId = 10;

        assertThrows(CustomException.class,
                () -> factory.createArraysFromFile(startingId, tempFile.toString()),
                "Should throw if parser returns empty list");
    }
}
