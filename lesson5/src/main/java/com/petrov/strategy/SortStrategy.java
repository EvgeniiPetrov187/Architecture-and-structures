package com.petrov.strategy;
//strategy
import java.util.List;

public interface SortStrategy {
    SortStrategy sort(List<Object> list);
}
