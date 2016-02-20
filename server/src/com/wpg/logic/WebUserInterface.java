package com.wpg.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luke on 2/18/2016.
 * Hard coded (The servlet will provide the infomration
 */
public class WebUserInterface implements UserInput {


    @Override
    public List<Person> gatherImportantPeople() {
        List<Person> peopleList = new ArrayList<>();
        Person person1 = new Person();
        person1.setName("Luke");
        person1.setGender("M");
        Person person2 = new Person();
        person2.setName("Rose");
        person2.setGender("F");

        peopleList.add(person1);
        peopleList.add(person2);
        return peopleList;
    }

    @Override
    public List<Item> gatherImportantItems() {
        List<Item> itemList = new ArrayList<>();
        Item item1 = new Item();
        item1.setName("Cats");

        Item item2 = new Item();
        item2.setName("Dogs");

        itemList.add(item1);
        itemList.add(item2);
        return itemList;
    }

    @Override
    public List<String> gatherOperationsList(List<String> opList) {
        List<String> operationsList = new ArrayList<>();
        for(String op : opList){
            operationsList.add(op);
        }
        return operationsList;
    }

    @Override
    public int gatherProblemNum() {

        return 10;
    }

    @Override
    public int gatherTopRange() {
        return 10;
    }

    @Override
    public int gatherBottomRange() {
        return 1;
    }
}
