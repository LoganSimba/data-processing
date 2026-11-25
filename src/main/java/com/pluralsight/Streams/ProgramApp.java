package com.pluralsight.Streams;

import com.pluralsight.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProgramApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //instantiated a list of people and added Person to the list
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("John", "Smith", 25),
                new Person("Sarah", "Johnson", 32),
                new Person("Michael", "Williams", 18),
                new Person("Emily", "Brown", 45),
                new Person("David", "Jones", 29),
                new Person("Jessica", "Garcia", 21),
                new Person("James", "Miller", 55),
                new Person("Ashley", "Davis", 37),
                new Person("Robert", "Wilson", 16),
                new Person("Amanda", "Taylor", 42)
        ));
        //prompt user for the name they want to search and store in a variable
        System.out.println("Enter a name to search: ");
        String name = scanner.nextLine().trim();


        //sorting using streams
        List<Person> similarNames = people.stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase(name)
                        || person.getLastName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        //check if the loop is emptty
        if (similarNames.isEmpty()) {
            System.out.println("No matches found for \"" + name + "\".");
        } else {
            similarNames.forEach(person -> System.out.println(person.getFirstName() + " " +
                    person.getLastName()));

        }

        //make a stream and map it to getAge so we can use the max() and mi()
        int oldest = people.stream()
                .mapToInt(person -> person.getAge())
                .max()
                .getAsInt();

        int youngest = people.stream()
                .mapToInt(person -> person.getAge())
                .min()
                .getAsInt();
        //get teh average by using streams and average()
        double average = people.stream()
                .mapToInt(person -> person.getAge())
                .average()
                .getAsDouble();

        //print the message
        System.out.println("Average age: " + average);
        System.out.println("Oldest age: " + oldest);
        System.out.println("Youngest age: " + youngest);


    }
}
