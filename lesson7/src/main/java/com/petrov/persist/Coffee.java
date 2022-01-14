package com.petrov.persist;

public class Coffee {

    private Long id;

    private String title;

    public Coffee(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Coffee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
