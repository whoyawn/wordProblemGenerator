package com.wpg.logic;

import java.util.List;

/**
 * Created by Luke on 2/5/2016.
 * Stores child interest and people
 */
public class UserSpecs {

    private static UserSpecs userSpecs;
    private List<Person> importantPeople;
    private List<Item> importantItems;
    private List<String> operationList;
    private int problemNum;
    private int bottomRange;
    private int topRange;
    private static WebParameters webParameters;



	@Override
	public String toString() {
		return "UserSpecs [importantPeople=" + importantPeople + ", importantItems=" + importantItems
				+ ", operationList=" + operationList + ", problemNum=" + problemNum + ", bottomRange=" + bottomRange
				+ ", topRange=" + topRange + "]";
	}

	private UserSpecs(){}

    public static UserSpecs getInstance(WebParameters webParams){
        if (userSpecs == null){
            userSpecs = new UserSpecs();
            webParameters = webParams;
        }
        return userSpecs;
    }

    public void gatherChildInfo(){
        UserInput userInput = new WebUserInterface(webParameters);
        setImportantPeople(userInput.gatherImportantPeople());
        setImportantItems(userInput.gatherImportantItems());
    }

    public void gatherProblemInfo(){
        UserInput userInput = new WebUserInterface(webParameters);
        setOperationList(userInput.gatherOperationsList());
        setProblemNum(userInput.gatherProblemNum());
        setBottomRange(userInput.gatherBottomRange());
        setTopRange(userInput.gatherTopRange());

    }
    
    public WebParameters getWebParameters() {
		return webParameters;
	}

    public List<Person> getImportantPeople() {
        return importantPeople;
    }

    public void setImportantPeople(List<Person> importantPeople) {
        this.importantPeople = importantPeople;
    }

    public List<Item> getImportantItems() {
        return this.importantItems;
    }

    public void setImportantItems(List<Item> importantItems) {
        this.importantItems = importantItems;
    }

    public List<String> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<String> operationList) {
        this.operationList = operationList;
    }

    public int getProblemNum() {
        return problemNum;
    }

    public void setProblemNum(int problemNum) {
        this.problemNum = problemNum;
    }

    public int getBottomRange() {
        return bottomRange;
    }

    public void setBottomRange(int bottomRange) {
        this.bottomRange = bottomRange;
    }

    public int getTopRange() {
        return topRange;
    }

    public void setTopRange(int topRange) {
        this.topRange = topRange;
    }



}
