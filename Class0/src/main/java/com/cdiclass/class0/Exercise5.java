package com.cdiclass.class0;

public class Exercise5 {
    
    public static int[] sortInverse(int[] numbers){
        int[] inverseArray = new int[numbers.length];
        int cont = 0;
        
        for ( int i = numbers.length; i > 0; i--){
            inverseArray[cont] = numbers[i-1];
            cont++;            
        }
        return inverseArray;
   
    
    }
    
}
