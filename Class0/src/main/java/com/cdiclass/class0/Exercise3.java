package com.cdiclass.class0;

import java.util.HashMap;
import java.util.Scanner;

public class Exercise3 {
    
    public static void searchInPhoneBook(HashMap<String,Integer> phoneBook){
        System.out.println("De quien quieres saber el número?");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        
        if ( phoneBook.get(name) != null ){
            System.out.println("El número de " + name + " es " + 
                    phoneBook.get(name));
        }else{
            System.out.println("No existe ese nombre en la agenda");
        }
        
        
        
    }
    
}
