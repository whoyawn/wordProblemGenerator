package com.wpg.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Luke on 2/4/2016.
 * This contains the QuizDriver class
 */
public class QuizDriver {

    private UserSpecs userSpecs;
    private List<Worksheet> worksheetList;
    private WebParameters webParameters;
    


	public QuizDriver(WebParameters webParameters){
    	setWebParameters(webParameters);
    }

    public String run(){
        System.out.println("Welcome to Word Problem Generator (Server)");
        makeUserSpecs();
        System.out.println(userSpecs.toString());
        generateWorksheet(userSpecs);
        return saveProblems(worksheetList.get(0));

    }
    
    public WebParameters getWebParameters() {
		return webParameters;
	}

	public void setWebParameters(WebParameters webParameters) {
		this.webParameters = webParameters;
	}
    private void makeUserSpecs(){
        userSpecs = UserSpecs.getInstance(webParameters);
        userSpecs.gatherChildInfo();
        userSpecs.gatherProblemInfo();
    }


    private void generateWorksheet(UserSpecs specs){
        Worksheet worksheet = new Worksheet();
        worksheet.generateProblemList(specs);
        worksheetList = new ArrayList<>();
        worksheetList.add(worksheet);

    }

    private void administerQuiz(Worksheet worksheet){
        worksheet.startQuizUI();
        worksheet.gradeWorksheet();
    }

    private String saveProblems(Worksheet worksheet){
//        SaveProblem save = new SaveProblem(worksheet);
//        save.saveProblemsToTextFile();
    	int count = 0;
    	String text = "";
        for(Problem p : worksheet.problemList) {
            count++;
            text += "<h4>" + count + ". ANSWER:" + p.answer + " QUESTION:" + p.problemText + "</h4><br/>";
        }
        return text;
    }


}
