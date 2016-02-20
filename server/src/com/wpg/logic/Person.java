package com.wpg.logic;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Luke on 2/5/2016.
 * Stores a person object
 */
public class Person extends Noun {


    private String gender;
    private List<String> pronounList;


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        List<String> pronounList;
        switch (getGender()) {
            case "M":
                pronounList = Arrays.asList("He", "His");
                setPronounList(pronounList);
                break;
            case "F":
                pronounList = Arrays.asList("She", "Her");
                setPronounList(pronounList);
                break;
            default:
                pronounList = Arrays.asList("He", "His");
                setPronounList(pronounList);
                break;
        }


    }

    public List<String> getPronounList() {
        return pronounList;
    }

    public void setPronounList(List<String> pronounList) {
        this.pronounList = pronounList;
    }

}
