package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PersonList {
    private List<Person> persons;

    public PersonList() {
        persons = new ArrayList<>();
    }

    public void add(Person person) {
        persons.add(person);
    }


    public Person findByName(String name) {

        if (!Pattern.matches("^[A-Z][a-zA-Z]*\\s[A-Z][a-zA-Z]*$", name)) {
            throw new IllegalArgumentException(
                    "Name must be in the format 'FirstName LastName'");
        }

        for (Person p : persons) {
            if (p.getName().equals(name)) {
                return p;
            }
        }

        return null;
    }


    public Person clone(Person original, int newId) {
        return new Person(
                newId,
                original.getName(),
                original.getAge(),
                original.getOccupation()
        );
    }


    public void writeToFile(Person person, String filename) {

        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(person.toString() + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
