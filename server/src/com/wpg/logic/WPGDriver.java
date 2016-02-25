package com.wpg.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luke on 2/4/2016.
 * This contains the QuizDriver class
 */
public class WPGDriver {

    private UserSpecs userSpecs;
    private List<Worksheet> worksheetList;
    private WebParameters webParameters;
    
	public WPGDriver(WebParameters webParameters){
    	setWebParameters(webParameters);
    }

    public String run(){
        makeUserSpecs();
        generateWorksheet(userSpecs);
        saveQuestions(worksheetList.get(0));
        return genHTMLQuestions(worksheetList.get(0));

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
    private void saveQuestions(Worksheet worksheet) {
    	ArrayList<String> answers = new ArrayList<>();
    	for(Problem p : worksheet.problemList){
    		answers.add(p.answer.toString());
    	}
		FileHandling.storeInTextFile(answers, "answers.txt");

		
	}


    private String genHTMLQuestions(Worksheet worksheet){
    	int count = 0;
    	String text = "";
        for(Problem p : worksheet.problemList) {
            count++;
            String genQuestion = "<div class='row'>\n" +
			"<div class='col-lg-6 col-lg-offset-3' id='inputs'>\n" + 
				"<label for=question" + count + ">Question " + count + ":</label>\n" +
				"<label for=question" + count + ">" + p.problemText + "</label>\n" +
				"<input type='text' style:='width:' class='form-control' id='question" + count + "' placeholder='Your Answer'>\n" +
			"</div>\n" +
		"</div>\n";
            text += genQuestion;
        }
        return text;
    }


}
