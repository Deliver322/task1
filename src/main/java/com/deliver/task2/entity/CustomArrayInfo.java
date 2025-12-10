package com.deliver.task2.entity;

public record CustomArrayInfo(int min, int max, int sum) {

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CustomArrayInfo that)) return false;

        return min == that.min && max == that.max && sum == that.sum;
    }

    @Override
    public int hashCode() {
        int result = max;
        result = 31 * result + sum;
        result = 31 * result + min;
        return result;
    }
}
