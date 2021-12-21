package com.petrov.strategy;
//strategy
import java.util.List;

public class BubbleSort implements SortStrategy{
    @Override
    public SortStrategy sort(List<Object> list) {
        System.out.println("Bubble");
        return null;
    }
}
