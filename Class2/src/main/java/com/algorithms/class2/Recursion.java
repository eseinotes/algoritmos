package com.algorithms.class2;

public class Recursion {
    
    public static int factorialIterative(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    public static String reverseStringRecursive(String str) {
        if (str.isEmpty()) {
            return str; // caso base: cadena vacía
        }
        return reverseStringRecursive(str.substring(1)) + str.charAt(0);
    }
    
    public static int fibonacciRecursive(int n) {
        if (n == 0) return 0; // caso base
        if (n == 1) return 1; // caso base
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}
