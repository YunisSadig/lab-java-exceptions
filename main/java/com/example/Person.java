package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;


    private static final Pattern NAME_PATTERN =
            Pattern.compile("^[A-Z][a-zA-Z]*\\s[A-Z][a-zA-Z]*$");

    public Person(int id, String name, int age, String occupation) {

        if (!NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(
                    "Name must be in the format 'FirstName LastName'");
        }

        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public boolean equals(Person other) {
        if (other == null) return false;

        return this.name.equals(other.name)
                && this.age == other.age
                && this.occupation.equals(other.occupation);
    }

    @Override
    public String toString() {
        return "Person{id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }


    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getOccupation() { return occupation; }
}
