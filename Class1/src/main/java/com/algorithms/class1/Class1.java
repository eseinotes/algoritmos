package com.algorithms.class1;

import java.util.HashMap;
import java.util.Scanner;

public class Class1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 10;
                
        while(option != -1){
            
            System.out.println("Introduce un número: ");
            option = sc.nextInt();
                    
            switch (option) { 

                case 1:
                    System.out.println("Búsqueda lineal:");            
                    int[] array = {1,4,32,12,42,12,54,122,13,31};
                    int target = 42;
                    
                    LinearSearch ls = new LinearSearch(array);
                    
                    int pos = ls.search(target);
                    
                    System.out.println("El número " + target + " esta en la "
                            + "posicion " + pos);
            
                break;
                
                case 2:
                    System.out.println("Binary Search:");
                    int[] arrayB = {1,4,32,12,42,12,54,122,13,31};
                    int search = 32;
                    
                    BinarySearch bs = new BinarySearch(arrayB);
                    
                    int posB = bs.search(search);
                    
                    System.out.println("El número " + search + " esta en la "
                            + "posicion " + posB);
                break;
                
                case 3:
                    HashMap<Integer, String> map = new HashMap<>();

                    // Insertar datos
                    map.put(23, "Elemento A");
                    map.put(42, "Elemento B");
                    map.put(15, "Elemento C");
                    
                    HashSearch hs = new HashSearch(map);
                    
                    int key = 23;
                    
                    String element = hs.searchElement(key);
                    
                    System.out.println("El elemento es " + element);
                break;
                
                case -1:
                    System.out.println("Adios");
                break;
                
                default:
                    System.out.println("Número equivocado");
            }   
        }
    }
}
