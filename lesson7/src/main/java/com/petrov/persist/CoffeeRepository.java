package com.petrov.persist;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CoffeeRepository {

    private  Map<Long, Coffee> coffeeMap = new ConcurrentHashMap<>();

    private AtomicLong identificator = new AtomicLong(0);

    public List<Coffee> findAll() {
        return new ArrayList<>(coffeeMap.values());
    }

    public Optional<Coffee> findById(long id) {
        return Optional.ofNullable(coffeeMap.get(id));
    }

    @PostConstruct
    public void init(){
        this.insert(new Coffee(1L, "Mocca"));
        this.insert(new Coffee(2L, "Arabica"));
    }

    public void insert(Coffee coffee){
        long id = identificator.incrementAndGet();
        coffee.setId(id);
        coffeeMap.put(id, coffee);
    }

    public void update(Coffee coffee){
        coffeeMap.put(coffee.getId(), coffee);
    }

    public void delete(Long id){
        coffeeMap.remove(id);
    }
}
