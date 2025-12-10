package com.deliver.task2.observer;

import com.deliver.task2.entity.CustomArray;

public interface CustomArrayObservable {
    void addObserver(CustomArrayObserver customArrayObserver);
    void removeObserver(CustomArrayObserver customArrayObserver);
    void notifyObservers();
}
