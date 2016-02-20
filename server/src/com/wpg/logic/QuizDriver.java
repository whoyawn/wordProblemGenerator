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
    private List<String> operationsList = Arrays.asList("ADD", "SUB", "MULT", "DIV");

    public String run(){
        System.out.println("Welcome to Word Problem Generator (Server)");
        makeUserSpecs();
        generateWorksheet(userSpecs);
        return saveProblems(worksheetList.get(0));

    }

    private void makeUserSpecs(){
        userSpecs = UserSpecs.getInstance();
        userSpecs.gatherChildInfo();
        userSpecs.gatherProblemInfo(operationsList);
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
            text += "<h3>" + count + ". ANSWER:" + p.answer + " QUESTION:" + p.problemText + "</h3>";
        }
        return text;
    }


}
