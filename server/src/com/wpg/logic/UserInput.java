package com.wpg.logic;

import java.util.List;

/**
 * Created by Luke on 2/5/2016.
 * Interface for collect user input
 */
public interface UserInput {

    List<Person> gatherImportantPeople();
    List<Item> gatherImportantItems();
    List<String> gatherOperationsList(List<String> input);
    int gatherProblemNum();
    int gatherTopRange();
    int gatherBottomRange();

}
