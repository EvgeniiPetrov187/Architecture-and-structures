package com.petrov.patterns.orm;

public class Main {
    public static void main(String[] args) {
        DataBaseService.connect();

        UserRepository userRepository = new UserRepository(DataBaseService.connection);

        User bob = new User(1, "Bob", "111");

        userRepository.beginTransaction();

        userRepository.insert(bob);
        System.out.println(userRepository.findById(bob.getId()).toString());

        bob = new User("Ben", "222");

        userRepository.update(bob);
        userRepository.delete(bob);

        userRepository.commitTransaction();

        DataBaseService.disconnect();

    }
}
