package com.algorithms.class0;

import java.util.ArrayList;

public class Exercise4 {
    public static double averageNotes(ArrayList<Double> notes){
        double sum = 0;
        
        for (Double note : notes){
            sum += note;
        }
        
        return sum/notes.size();
    }   
}
