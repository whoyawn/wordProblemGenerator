package com.wpg.logic;

import java.util.ArrayList;

/**
 * Created by Luke on 2/5/2016.
 * Handles subtraction
 */
public class SubtractionProblem extends Problem {


    public SubtractionProblem(){
        templateList = new ArrayList<>();
        templateList.add("#NAME1# has #NUM1# #ITEM1#. #PRONOUN1# gives #NUM2# #ITEM1#" +
                " to #NAME2#. How many #ITEM1# does #NAME1# have left?");
        templateList.add("#NAME1# has #NUM1# #ITEM1#. #PRONOUN1# gives #NUM2# #ITEM1#" +
                " to #NAME2# and #NUM3# #ITEM1# to #NAME3#. How many #ITEM1# does #NAME1# have left?");
    }


    public void calculateAnswer(){
        Float result = (float) this.operandList.get(0);
        for(int i = 1; i < operandList.size(); i++){
            result = result - (float) operandList.get(i);
        }
        this.answer = result;

    }


}
