package com.wpg.logic;

import java.util.List;

public class CheckAnswers {
	
	private int correct = 0;
	private int score;
	private String[] userAnswers;
	private List<String> genAnswers;

	
	
	public CheckAnswers(String[] answers){
		userAnswers = answers;
		genAnswers = FileHandling.readFromFile("answers.txt");
	}
	
	public String runCheck(){
		String html = "";
		int count = 0;
		for(String userA : userAnswers){
			Float userFloat = Float.parseFloat(userA);
			Float genFloat = Float.parseFloat(genAnswers.get(count));
			count++;
			if(userFloat.equals(genFloat)){
				correct++;
				html += "<label style='color:green'>Question " + count + ": correct</label></br>\n";
            } else {
            	html += "<label style='color:red'>Question " + count + ": incorrect, answer is " + genFloat
            			+"</label></br>\n";
            }
			
		}
		score = (correct * 100) / genAnswers.size();
		
		html = "<h2>You scored " + score + "%</h2>\n" + html;
		
		return html;
	}
	
	
	
	
}