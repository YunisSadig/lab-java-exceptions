package com.example;

public class Main {
    public void main(String[] args){
        PersonList list = new PersonList();

        Person p1 = new Person(1, "Alice Smith", 25, "Engineer");
        Person p2 = new Person(2, "John Doe", 30, "Doctor");

        list.add(p1);
        list.add(p2);

        System.out.println("All persons:");
        System.out.println(p1);
        System.out.println(p2);


        try {
            p1.setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught error: " + e.getMessage());
        }


        try {
            Person found = list.findByName("John Doe");
            System.out.println("Found: " + found);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        Person cloned = list.clone(p1, 3);
        System.out.println("Cloned: " + cloned);


        list.writeToFile(p1, "persons_output.txt");
        list.writeToFile(cloned, "persons_output.txt");

        System.out.println("Data written to persons_output.txt");
    }
}
