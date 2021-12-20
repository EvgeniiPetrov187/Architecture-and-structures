package com.petrov.strategy;
//strategy
import java.util.List;

public class QuickSort implements SortStrategy{
    @Override
    public SortStrategy sort(List<Object> list) {
        System.out.println("Quick");
        return null;
    }
}
