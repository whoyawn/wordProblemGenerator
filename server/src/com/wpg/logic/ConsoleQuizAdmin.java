package com.wpg.logic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Luke on 2/5/2016.
 * Implements QuizAdmin for console use
 */
public class ConsoleQuizAdmin implements QuizAdmin {

    private Worksheet worksheet;


    public ConsoleQuizAdmin(Worksheet work){
        worksheet = work;
    }

    @Override
    public void displayQuestions() {
        int count = 0;
        for(Problem p : worksheet.problemList){
            count++;
            System.out.println(count + ". " + p.problemText);
        }

    }

    @Override
    public void getAnswers() {
        Scanner sc = new Scanner(System.in);
        worksheet.userAnswers = new ArrayList<>();
        int count = 0;
        System.out.println("\nEnter answers one at a time (round to nearest .1 place):");
        for(Problem p : worksheet.problemList){
            count++;
            System.out.print(count + ". ");
            float answer = sc.nextFloat();
            sc.nextLine();
            worksheet.userAnswers.add(answer);
            System.out.print("Your answer = " + answer );
            System.out.println(" Correct answer = " + p.answer);
        }


    }

    @Override
    public void displayScores(){
        System.out.println("Final score: " + worksheet.score + " out of " + worksheet.problemList.size());

    }
}
