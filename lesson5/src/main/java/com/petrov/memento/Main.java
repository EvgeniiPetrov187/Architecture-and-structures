package com.petrov.memento;
//memento
public class Main {
    public static void main(String[] args) {

        Editor editor = new Editor();
        editor.type("First");
        editor.type("Second");

        Memorizer memorizer = editor.save();

        editor.type("Third");

        System.out.println(editor.getContent());

        System.out.println();
        editor.restore(memorizer);

        System.out.println(editor.getContent());

    }
    }
