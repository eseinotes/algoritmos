package com.cdiclass.class2;

import java.util.Scanner;
import java.util.Arrays;

public class Class2 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int option = 10;
        
        while(option != -1){
            
            System.out.println("Introduce un número: ");
            option = sc.nextInt();
        
            switch (option) { 

                case 1:
                    int[] availableBills = {50, 20}; // Billetes disponibles
                    int targetAmount = 210;
                    System.out.println("Intentamos sacar "+ targetAmount + " de un cajero");
                    System.out.println("Solo tenemos billetes de " + Arrays.toString(availableBills));
                    ATMWithdrawal atm = new ATMWithdrawal(availableBills, targetAmount);
                    atm.findCombination();
                    
                break;
                
                case 2:
                    int n = 8;
                    System.out.println("Algoritmo de N-Reinas, test con 8 reinas");
                    NQueens nQueens = new NQueens(n);
                    nQueens.getSolveNQueens();
                break;
                
                case -1:
                    System.out.println("Adios");
                
                default:
                    System.out.println("Número equivocado");
            }   
        }
    }
}