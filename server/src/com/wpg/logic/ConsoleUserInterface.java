package com.wpg.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Luke on 2/5/2016.
 * Implements UserInput
 */
public class ConsoleUserInterface implements UserInput {


    @Override
    public List<Person> gatherImportantPeople() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of important people (1,2,3...): ");
        int numberOfPeople = sc.nextInt();
        sc.nextLine();
        List<Person> peopleList = new ArrayList<>();
        for(int i = 0; i < numberOfPeople; i++){
            Person person = new Person();

            System.out.print("Person #" + (i + 1) +" Name: ");
            String name = sc.nextLine();
            person.setName(name);

            System.out.print("Person #" + (i + 1) +" Gender (M/F): ");
            String gender = sc.nextLine();
            person.setGender(gender);

            peopleList.add(person);
        }
        return peopleList;
    }

    @Override
    public List<Item> gatherImportantItems() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of important Items (1,2,3...): ");
        int numberOfPeople = sc.nextInt();
        sc.nextLine();
        List<Item> itemsList = new ArrayList<>();
        for(int i = 0; i < numberOfPeople; i++){
            Item item = new Item();

            System.out.print("Item #" + (i + 1) +" Name: ");
            String name = sc.nextLine();
            item.setName(name);


            itemsList.add(item);
        }
        return itemsList;
    }

    @Override
    public List<String> gatherOperationsList(List<String> opList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Y or N next to each Operation to select or remove it: ");
        List<String> operationsList = new ArrayList<>();
        for(String op : opList){
            System.out.print(op + ": ");
            String choice = sc.nextLine();
            if (choice.equals("Y")){
                operationsList.add(op);
            }
        }
        return operationsList;
    }

    @Override
    public int gatherProblemNum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of problems desired (1,2,3,4...): ");
        int numProblems = sc.nextInt();
        sc.nextLine();
        return numProblems;
    }

    @Override
    public int gatherTopRange() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Top range of operands (20,30,40...): ");
        int top = sc.nextInt();
        sc.nextLine();
        return top;
    }

    @Override
    public int gatherBottomRange() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Bottom range of operands (1,2,3...): ");
        int bot = sc.nextInt();
        sc.nextLine();
        return bot;
    }
}
