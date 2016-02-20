package com.wpg.logic;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Luke on 2/5/2016.
 * Handles Division
 */
public class DivProblem extends Problem {


    public DivProblem(){
        templateList = new ArrayList<>();
        templateList.add("#NAME1# has #NUM1# #ITEM1#. #PRONOUN1# wants to divide them evenly" +
                " among #NUM2# friends. How many #ITEM1# does each friend get? ");
    }


    public void calculateAnswer(){
        Float result = (float) this.operandList.get(0);
        for(int i = 1; i < operandList.size(); i++){
            result = result / (float) operandList.get(i);
        }
        DecimalFormat df = new DecimalFormat("#.#");
        this.answer = Float.parseFloat(df.format(result));

    }


}
