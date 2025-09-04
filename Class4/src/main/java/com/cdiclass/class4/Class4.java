package com.cdiclass.class4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Class4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 10;
        
                
        while(option != -1){
            
            System.out.println("Introduce un número: ");
            option = sc.nextInt();
            
            List<Item> items = Arrays.asList(
            new Item("A", 3, 25),
            new Item("B", 2, 20),
            new Item("C", 4, 40)
            );
            
            int capacity = 7;
            
            BranchAndBoundKnapsack branchAndBound = new BranchAndBoundKnapsack();
        
            switch (option) { 

                case 1:
                    System.out.println("Problema de la mochila con FIFO");            
                    branchAndBound.knapsackFIFO(capacity, items);
                break;
                
                case 2:
                    System.out.println("Problema de la mochila con LIFO");
                    branchAndBound.knapsackLIFO(capacity, items);
                case -1:
                    System.out.println("Adios");
                
                default:
                    System.out.println("Número equivocado");
            }   
        }
    }
    
}

