package com.wpg.logic;

import java.util.ArrayList;

/**
 * Created by Luke on 2/5/2016.
 * Hands addition
 */
public class AdditionProblem extends Problem {



    public AdditionProblem(){
        templateList = new ArrayList<>();
        templateList.add("#NAME1# has #NUM1# #ITEM1#. #NAME2# has #NUM2# #ITEM1#" +
                ". How many #ITEM1# do they have altogether?");
        templateList.add("#NAME1# has #NUM1# #ITEM1#. #NAME2# has #NUM2# #ITEM1#" +
                " and #NAME3# has #NUM3# #ITEM1#. How many #ITEM1# do they have altogether?");
    }


    public void calculateAnswer(){
        Float result = 0f;
        for(int each : this.operandList){
            result += (float) each;
        }
        this.answer = result;

    }


}
