package com.deliver.task2.reader.impl;

import com.deliver.task2.exeption.CustomException;
import com.deliver.task2.reader.CustomFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CustomFileReaderImpl implements CustomFileReader {

    private static final Logger logger = LogManager.getLogger();
//    private static final String FILE_URL = "data/numbers.txt";

    @Override
    public List<String> readLines(String filePath) throws CustomException {
        logger.info("Started reading file at {}", filePath);
        if (filePath == null || filePath.isBlank()) {
            throw new CustomException("File path is null or blank");
        }
        Path path = Paths.get(filePath);
        try {
            logger.info("Success on Reading file");
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new CustomException(e.getMessage());
        }
    }
}
