package com.deliver.task1.reader.impl;

import com.deliver.task1.exeption.CustomException;
import com.deliver.task1.reader.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {

    private static final Logger logger = LogManager.getLogger();
    private static final String FILE_URL = "numbers.txt";

    @Override
    public List<String> readLine() throws CustomException {
        logger.info("Started reading file at {}", FILE_URL);
        Path path = Paths.get(FILE_URL);
        try {
            logger.info("Success on Reading file");
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new CustomException(e.getMessage());
        }
    }
}
