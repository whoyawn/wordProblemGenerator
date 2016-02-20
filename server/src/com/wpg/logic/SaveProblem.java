package com.wpg.logic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Luke on 2/18/2016.
 * Save problems out to text file
 */
public class SaveProblem {

    private Worksheet worksheet;

    public SaveProblem(Worksheet worksheet){
        this.worksheet = worksheet;
    }

    public void saveProblemsToTextFile(){
        try {

            FileWriter fstream = new FileWriter("problems.txt", false); //true tells to append data.
            BufferedWriter out = new BufferedWriter(fstream);
            int count = 0;
            for(Problem p : worksheet.problemList) {
                count++;
                out.write(count + ". ANSWER:" + p.answer + " QUESTION:" + p.problemText + "\n");
            }
            out.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
