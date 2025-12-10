package com.deliver.task2.reader;

import com.deliver.task2.exeption.CustomException;
import com.deliver.task2.reader.impl.CustomFileReaderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomFileReaderTest {
    private CustomFileReader customFileReader;

    @BeforeEach
    void setup() {
        customFileReader = new CustomFileReaderImpl();
    }

    @Test
    void testReadExistingFile() throws CustomException, IOException {
        Path tempFilePath = Files.createTempFile("tempFile", ".txt");
        List<String> expectedLines = List.of("10", "20 30", "-40", "50;60");
        Files.write(tempFilePath, expectedLines);

        List<String> actualLines = customFileReader.readLines(tempFilePath.toString());

        assertEquals(expectedLines, actualLines, "Lines are not equal");
    }

    @Test
    void testReadNullPathFile() {
        assertThrows(CustomException.class,
                () -> customFileReader.readLines(null),
                "File is null, should throw CustomException");
    }

    @Test
    void testReadBlankFile() {
        assertThrows(CustomException.class,
                () -> customFileReader.readLines("  "),
                "File is blank, should throw CustomException");
    }

    @Test
    void testReadNonExistingFile() {
        assertThrows(CustomException.class,
                () -> customFileReader.readLines("nonExistingFile.txt"),
                "File is not found, should throw CustomException");
    }
}
