package com.wpg.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luke on 2/18/2016.
 * Hard coded (The servlet will provide the infomration
 */
public class WebUserInterface implements UserInput {
	
	private WebParameters webParameters;
	
	
	public WebUserInterface(WebParameters webParameters){
		this.webParameters = webParameters;
	}


    @Override
    public List<Person> gatherImportantPeople() {
        List<Person> peopleList = new ArrayList<>();
        String[] splitNames = webParameters.getNames().split(", ");
        for(String s : splitNames){
        	Person p = new Person();
        	p.setName(s);
        	p.setGender("M");
        	peopleList.add(p);
        }
        
        return peopleList;
    }

    @Override
    public List<Item> gatherImportantItems() {
        List<Item> itemList = new ArrayList<>();
        String[] splitItems = webParameters.getItems().split(", ");
        for(String s : splitItems){
        	Item i = new Item();
        	i.setName(s);
        	itemList.add(i);
        }
        
        return itemList;
    }

    @Override
    public List<String> gatherOperationsList() {
        List<String> operationsList = new ArrayList<>();
        for(String op : webParameters.getOperations()){
            operationsList.add(op);
        }
        return operationsList;
    }

    @Override
    public int gatherProblemNum() {
        return webParameters.getNumberOfQuestions();
    }

    @Override
    public int gatherTopRange() {
        return webParameters.getRangeMax();
    }

    @Override
    public int gatherBottomRange() {
        return webParameters.getRangeMin();
    }
}
