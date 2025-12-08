package com.deliver.task1.parser.impl;

import com.deliver.task1.exeption.CustomException;
import com.deliver.task1.parser.RowDataParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RowDataParserImpl implements RowDataParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String NUMBER_REGEX = "-?\\d+";

    @Override
    public List<int[]> readData(List<String> stringLines) throws CustomException {
        logger.info("Started reading ArrayData");
        List<int[]> numbers = new ArrayList<>();

        for (String line : stringLines) {
            logger.info("Reading numbers from line {}", line);
            int[] intRow = readLineInt(line);
            if (intRow.length > 0) {
                numbers.add(intRow);
            }
        }
        if (numbers.isEmpty()) {
            logger.error("ArrayData is empty or invalid");
            throw new CustomException("No valid numbers found in file");
        }
        logger.info("Finished reading ArrayData");
        return numbers;
    }

    private int[] readLineInt(String line) {
        logger.info("Extracting number from line {}", line);
        List<Integer> numbers = new ArrayList<>();
        Pattern pattern = Pattern.compile(NUMBER_REGEX);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String numberString = matcher.group();
            numbers.add(Integer.parseInt(numberString));
        }
        logger.info("Finished extracting number from line {}", line);
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }
}
