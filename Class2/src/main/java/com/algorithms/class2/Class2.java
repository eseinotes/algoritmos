package com.algorithms.class2;

import static com.algorithms.class2.Recursion.factorialIterative;
import static com.algorithms.class2.Recursion.fibonacciRecursive;
import static com.algorithms.class2.Recursion.reverseStringRecursive;
import java.util.Arrays;
import java.util.Scanner;

public class Class2 {

    public static void main(String[] args) {  
    
        Scanner sc = new Scanner(System.in);
        int option = 10;
        
        while(option != -1){
            
            System.out.println("Introduce un número: ");
            option = sc.nextInt();
        
            switch (option) { 

                case 1:
                    System.out.println("Factorial. Introduce un número");
                    int num = sc.nextInt();
                    System.out.println(factorialIterative(num));
                break;

                case 2:
                    System.out.println("Invertir cadena. Introduce una cadena");
                    String word = sc.next();
                    System.out.println(reverseStringRecursive(word));
                break;
                
                case 3:
                    System.out.println("Sucesión de Fibonacci. Introduce un número");
                    int numFibonacci = sc.nextInt();
                    System.out.println(fibonacciRecursive(numFibonacci));
                break;
                
                case 4:
                    int[] numbers = {3, 17, 9, 25, 42, 7, 13, 29};
                    System.out.println("Hallar el máximo valor en: "+ Arrays.toString(numbers));
                    ArrayMaxFinder finder = new ArrayMaxFinder(numbers);
                    int max = finder.findMax();
                    System.out.println("El valor máximo del array es: " + max);
                break;
                
                case 5:
                    int[] nums = {2, 4, 6, 8, 10};
                    System.out.println("Hallar la suma de: "+ Arrays.toString(nums));
                    ArraySummer summer = new ArraySummer(nums);

                    int total = summer.sumElements();
                    System.out.println("La suma total es: " + total);
                break;
                
                case 6:
                    int[] positiveNums = {-3, 5, 0, 7, -2, 9, -1};
                    System.out.println("Hallar positivos: "+ Arrays.toString(positiveNums));
                    PositiveCounter counter = new PositiveCounter(positiveNums);
                    int positives = counter.countPositives();
                    System.out.println("Cantidad de elementos positivos: " + positives);
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
