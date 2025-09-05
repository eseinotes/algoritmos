package com.algorithms.class0;

import java.util.ArrayList;

public class Exercise2 {
    public static ArrayList<String> modifyListNames(ArrayList<String> names){
        
        System.out.println("Estos son los nombres de la lista");
        
        for ( String name : names ){
            System.out.println(name);
        }
        
        System.out.println("Modificando.....");
        
        names.add("Victor");
        names.remove(0);
        
        System.out.println("Mostrando los nombres después de la modificación");
        for ( String name : names ){
            System.out.println(name);
        }
    
        return names;
    }
    
}
