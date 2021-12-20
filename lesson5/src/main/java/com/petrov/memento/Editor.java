package com.petrov.memento;
//memento
public class Editor {
    private String content;

    public Memorizer save() {
        return new Memorizer(this.content);
    }

    public void type(String content) {
        this.content = this.content + " new content is " + content;
    }

    public void restore(Memorizer memorizer) {
        this.content = memorizer.getContent();
    }

    public String getContent() {
        return content;
    }
}
