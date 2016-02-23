package com.wpg.logic;

import java.util.Arrays;

public class WebParameters {
	
	String names;
	String items;
	int numberOfQuestions;
	String[] operations;
	int rangeMin;
	int rangeMax;
	
	public WebParameters(String names, String items, String numberOfQuestions, 
			String[] operations, String rangeMin, String rangeMax){
		setNames(names);
		setItems(items);
		setNumberOfQuestions(numberOfQuestions);
		setOperations(operations);
		setRangeMin(rangeMin);
		setRangeMax(rangeMax);
	}
	
	@Override
	public String toString() {
		return "WebQuestionParameters [names=" + names + ", items=" + items 
				+ ", numberOfQuestions=" + numberOfQuestions
				+ ", operations=" 
				+ Arrays.toString(operations) + ", range_min=" + rangeMin + ", range_max="
				+ rangeMax + "]";
	}
	
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}
	public void setNumberOfQuestions(String numberOfQuestions) {
		this.numberOfQuestions = Integer.parseInt(numberOfQuestions);
	}
	public String[] getOperations() {
		return operations;
	}
	public void setOperations(String[] operations) {
		this.operations = operations;
	}
	public int getRangeMin() {
		return rangeMin;
	}
	public void setRangeMin(String rangeMin) {
		this.rangeMin = Integer.parseInt(rangeMin);
	}
	public int getRangeMax() {
		return rangeMax;
	}
	public void setRangeMax(String rangeMax) {
		this.rangeMax = Integer.parseInt(rangeMax);
	}

}
