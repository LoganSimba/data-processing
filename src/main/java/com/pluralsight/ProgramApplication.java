package com.pluralsight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProgramApplication {
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

        System.out.println("Enter a name to search: ");
        String name = scanner.nextLine().trim();
        //initialize the list that will hold similar names
//        List<Person> similarNames = new ArrayList<>();
//        for (Person person : people) {//iterate thorught he loop
//            //if we find a match in either first or last name, add to the list
//            if (person.getFirstName().equalsIgnoreCase(name) || person.getLastName().equalsIgnoreCase(name)) {
//                similarNames.add(person);
//                System.out.println(person.toString());//print the person
//            }
//        }//check if after iterating that nothing has been added to the list, if it has, its an emptu list, let the user know
//        if (similarNames.isEmpty()) {
//            System.out.println("No matches found for: " + name);
//
//        }
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



        //just a space for easier read
        System.out.println("=======");

        int total = 0;//variable to hold total age
        int age = people.get(0).getAge();//variable to hold the age, first person age for now
        int oldest = people.get(0).getAge();//variable to hold the oldest person age, it holds first person in the lists age
        int youngest = people.get(0).getAge();//initialize variable tp hold youngest person first but assign to the first person in the list at first
        //for that iterates and finds the oldes, youngest and the total age we will divide for average
        for (Person person : people) {
            age = person.getAge();//get the persons age
            total += age;//increment the total age every iteration by the age
            if (age > oldest) {//check if the current age is > than oldest
                oldest = age;//assign oldest to the age if the condition is true
            }
            if (age < youngest) {//check if the age is < youngest
                youngest = age;//assign youngest to age if the above condition is true
            }
        }
        //initialize average variable and calclat the average by dividing the total with the size of the array
        double average = (double) total / people.size();
        //print the average, oldest and youngest age
        System.out.println("Average age: " + average);
        System.out.println("Oldest age: " + oldest);
        System.out.println("Youngest age: " + youngest);

        scanner.close();//close the scanner

    }
}
