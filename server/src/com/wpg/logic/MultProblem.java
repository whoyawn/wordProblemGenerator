package com.wpg.logic;

import java.util.ArrayList;

/**
 * Created by Luke on 2/5/2016.
 * Handles multiplication
 */
public class MultProblem extends Problem {



    public MultProblem(){
        templateList = new ArrayList<>();
        templateList.add("#NAME1# has #NUM1# groups of #NUM2# #ITEM1#. How many #ITEM1# " +
            "does #NAME1# have altogether?");
    }

    public void calculateAnswer(){
        Float result = 1f;
        for(int each : this.operandList){
            result = result * (float) each;
        }
        this.answer = result;


    }



}
