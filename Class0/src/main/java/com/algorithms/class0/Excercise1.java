package com.algorithms.class0;

import java.util.Arrays;

public class Excercise1 {
    public static void pairNumbers(int[] num){
        System.out.println("Este es el array completo:" + Arrays.toString(num) );
        
        System.out.println("Estos son los números pares:");
        for (int i = 0; i < num.length; i++){
            if ( num[i] % 2 == 0)
                System.out.println(num[i]);
        }
        
    }
    
}
