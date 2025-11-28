package com.deliver.task1.reader;

import com.deliver.task1.exeption.CustomException;

import java.util.List;

public interface FileReader {
    List<String> readLine() throws CustomException;
}
