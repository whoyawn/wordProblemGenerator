package com.wpg.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Luke on 2/5/2016.
 * Stores problem information
 */
public abstract class Problem {

    private UserSpecs userSpecs;
    public String template;
    public String problemText;
    public List<String> templateList;
    public List<Integer> operandList;
    public Float answer;


    public void generateProblem(UserSpecs specs){
        this.userSpecs = specs;
        this.operandList = new ArrayList<>();
        this.template = chooseTemplate();
        this.problemText = generateString();
        calculateAnswer();

    }

    public void calculateAnswer(){

    }



    private String chooseTemplate(){
        int ranTempNum = randomGenerateNums(0, templateList.size() - 1);

        return templateList.get(ranTempNum);
    }

    private int randomGenerateNums(int min, int max){
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        return rand.nextInt((max - min) + 1) + min;
    }

    private Person randomGeneratePeople(){
        int numImportantPeople = userSpecs.getImportantPeople().size();
        int randIndexOfPeople = randomGenerateNums(0, numImportantPeople - 1);
        return userSpecs.getImportantPeople().get(randIndexOfPeople);
    }

    private Item randomGenerateItems(){
        int numImportantItems = userSpecs.getImportantItems().size();
        int randIndexOfItems = randomGenerateNums(0, numImportantItems - 1);
        return userSpecs.getImportantItems().get(randIndexOfItems);
    }



    private String generateString(){

        return concatProbText(parseFormatText());
    }

    private boolean containsKeyWord(String s){
        return s.contains("NAME") || s.contains("NUM") || s.contains("ITEM") || s.contains("PRONOUN");
    }

    private String[] parseFormatText(){
        String[] splitList = this.template.split("#");
        int count = 0;
        List<Person> people = new ArrayList<>();
        List<Item> items = new ArrayList<>();

        for(String s : splitList){

            if(containsKeyWord(s)){
                int keyWordNum = Integer.parseInt(s.substring(s.length() - 1));
                String keyWord = s.substring(0, s.length() - 1);

                switch (keyWord){
                    case "NAME":
                        generateName(keyWordNum, people);
                        splitList[count] = people.get(keyWordNum - 1).getName();
                        break;
                    case "NUM":
                        generateNum(keyWordNum);
                        splitList[count] = operandList.get(keyWordNum - 1).toString();
                        break;
                    case "ITEM":
                        generateItem(keyWordNum, items);
                        splitList[count] = items.get(keyWordNum - 1).getName();
                        break;
                    case "PRONOUN":
                        splitList[count] = people.get(keyWordNum - 1).getPronounList().get(0);
                        break;

                }
            }

            count++;
        }
        return splitList;
    }

    private void generateName(int num, List<Person> people){
        if (people.size() < num ){
            Person rand = randomGeneratePeople();
            while (people.contains(rand) && userSpecs.getImportantPeople().size() >= num){
                rand = randomGeneratePeople();
            }
            people.add(rand);

        }
    }

    private void generateNum(int num){
        if (operandList.size() < num ){
            int randOperand = randomGenerateNums(userSpecs.getBottomRange(), userSpecs.getTopRange());
            operandList.add(randOperand);
        }
    }

    private void generateItem(int num, List<Item> items){
        if (items.size() < num ){
            Item randItem = randomGenerateItems();
            while (items.contains(randItem) && userSpecs.getImportantItems().size() >= num){
                randItem = randomGenerateItems();
            }
            items.add(randItem);
        }
    }



    private String concatProbText(String[] splitList){
        String probText = "";
        for(String s : splitList){
            probText+= s;
        }
        return probText;
    }


}
