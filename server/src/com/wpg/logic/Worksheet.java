package com.wpg.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luke on 2/5/2016.
 * Controls the problems
 */
public class Worksheet {

    private UserSpecs userSpecs;
    public List<Float> userAnswers;
    public List<Problem> problemList;
    public int score;

    public void generateProblemList(UserSpecs specs){
        this.userSpecs = specs;
        this.problemList = new ArrayList<>();

        for(int i = 0; i < userSpecs.getProblemNum(); i++) {

            int numTypOps = userSpecs.getOperationList().size();
            String problemType = userSpecs.getOperationList().get(i % numTypOps);
            switch (problemType){
                case "ADD":
                    problemList.add(new AdditionProblem());
                    break;
                case "SUB":
                    problemList.add(new SubtractionProblem());
                    break;
                case "MULT":
                    problemList.add(new MultProblem());
                    break;
                case "DIV":
                    problemList.add(new DivProblem());
                    break;
            }
        }

        getRealAnswers();

    }

    private void getRealAnswers(){
        for(Problem prob : problemList){
            prob.generateProblem(userSpecs);
        }

    }

    public void startQuizUI(){
        QuizAdmin quiz = new ConsoleQuizAdmin(this);
        quiz.displayQuestions();
        quiz.getAnswers();
        gradeWorksheet();
        compareAnswers();
        quiz.displayScores();
    }

    public void gradeWorksheet(){
        int count = 0;
        for(Float answer : userAnswers){
            if(answer.equals(problemList.get(count).answer)){
                score++;
            }
            count++;
        }


    }

    private boolean compareAnswers(){

        return true;
    }


}
