package com.cdiclass.class0;

import static com.cdiclass.class0.Excercise1.pairNumbers;
import static com.cdiclass.class0.Exercise2.modifyListNames;
import static com.cdiclass.class0.Exercise3.searchInPhoneBook;
import static com.cdiclass.class0.Exercise4.averageNotes;
import static com.cdiclass.class0.Exercise5.sortInverse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Class0 {

    public static void main(String[] args) {
                
        
        Scanner sc = new Scanner(System.in);
        int option = 10;
        
        while(option != -1){
            
            System.out.println("Introduce un número: ");
            option = sc.nextInt();
        
            switch (option) { 

                case 1:
                    int[] numbers = {1,2,3,4,5,6,7,8,9,10};
                    pairNumbers(numbers);
                break;

                case 2:
                    ArrayList<String> names = new ArrayList();
                    names.add("Juan");
                    names.add("Maria");
                    names.add("Fran");
                    names.add("Lucia");                
                    names.add("Uxia");
                    modifyListNames(names);
                break;

                case 3:
                    HashMap<String, Integer> phoneBook = new HashMap();
                    phoneBook.put("Juan", 600113322);
                    phoneBook.put("Maria", 643116379);
                    phoneBook.put("Fran", 611343312);
                    phoneBook.put("Lucia", 621135422);
                    phoneBook.put("Uxia", 699123352);
                    searchInPhoneBook(phoneBook);
                break;
                
                case 4:
                    ArrayList<Double> notes = new ArrayList();
                    notes.add(5.5);
                    notes.add(7.2);
                    notes.add(1.4);
                    notes.add(3.2);
                    
                    System.out.println("La media es: " + averageNotes(notes));
                break;
                
                case 5:
                    int[] sortNumbers = {10,12,13,18,21,25,33,58,90,110};
                    System.out.println("Array: " + 
                            Arrays.toString(sortNumbers));
                    int[] sortInverseNumbers = sortInverse(sortNumbers);
                    System.out.println("Array invertido: " + 
                            Arrays.toString(sortInverseNumbers));
                                        
                break;
                
                case -1:
                    System.out.println("Adios!");
                 

                default:
                    System.out.println("No has introducido una opción válida");
            }
        }        
    }
}
