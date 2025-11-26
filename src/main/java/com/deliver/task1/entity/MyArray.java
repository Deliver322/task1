package com.deliver.task1.entity;


import com.deliver.task1.exeption.MyExeption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class MyArray {
    private int id;
    private int[] array;
    private final Logger logger = LogManager.getLogger(MyArray.class);

    MyArray(int id, int[] array) {
        logger.debug("Creating MyArray with id: {} ", id);
        if (id < 0) {
            logger.error("Entered id is negative");
            throw new MyExeption("Id can't be negative");
        }
        if (array == null) {
            logger.error("Entered array is null");
            throw new MyExeption("Array is null");
        }
        this.id = id;
        this.array = array;
        logger.info("MyArray created with id: {} ", id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getValue(int index) {
        logger.debug("Getting value from index: {} ", index);
        if (index < 0 || index >= array.length) {
            logger.error("Entered index is out of bounds: {}", index);
            throw new MyExeption("Index is out of bounds: " + index);
        }
        logger.info("Success on getting value from index: {} ", index);
        return array[index];
    }

    public void setValue(int index, int value) {
        logger.debug("Setting value from index: {} ", index);
        if (index < 0 || index >= array.length) {
            logger.error("Entered index is out of bounds: {}", index);
            throw new MyExeption("Index is out of bounds: " + index);
        }
        logger.info("Success on setting value from index: {} ", index);
        array[index] = value;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof MyArray myArray)) return false;

        return id == myArray.id && Arrays.equals(array, myArray.array);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyArray{");
        sb.append("id=").append(id);
        sb.append(", array=");
        if (array == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < array.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(array[i]);
            sb.append(']');
        }
        sb.append(", logger=").append(logger);
        sb.append('}');
        return sb.toString();
    }

    public interface Factory {
        MyArray create(int id, int[] array);
    }
}
