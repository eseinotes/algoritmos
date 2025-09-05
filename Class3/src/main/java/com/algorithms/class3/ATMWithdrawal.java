package com.algorithms.class3;

import java.util.ArrayList;
import java.util.List;

public class ATMWithdrawal {
        
    private int[] availableBills = {50, 20}; // Billetes disponibles
    private int targetAmount = 210;
    
    ATMWithdrawal(int[] availableBills, int targetAmount){
        this.availableBills = availableBills;
        this.targetAmount = targetAmount;
    }
    
    public void findCombination(){
                
        List<List<Integer>> allSolutions = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        
        // Encontrar todas las combinaciones posibles
        findCombinations(targetAmount, availableBills, 0, currentCombination, allSolutions);
        
        // Mostrar resultados
        System.out.println("Possible combinations to withdraw " + targetAmount + "€:");
        System.out.println("======================================================");
        
        if (allSolutions.isEmpty()) {
            System.out.println("No solution possible");
        } else {
            for (int i = 0; i < allSolutions.size(); i++) {
                List<Integer> solution = allSolutions.get(i);
                System.out.println("Solution " + (i + 1) + ":");
                System.out.println("  €50 bills: " + countBills(solution, 50));
                System.out.println("  €20 bills: " + countBills(solution, 20));
                System.out.println("  Total bills: " + solution.size());
                System.out.println("  Combination: " + solution);
                System.out.println();
            }
        }
        
    }
    
    /**
     * Método recursivo que encuentra todas las combinaciones posibles usando backtracking
     */
    private static void findCombinations(int remainingAmount, int[] availableBills, 
                                       int currentBillIndex, List<Integer> currentCombination, 
                                       List<List<Integer>> allSolutions) {
        
        // Caso base: hemos alcanzado exactamente la cantidad objetivo
        if (remainingAmount == 0) {
            allSolutions.add(new ArrayList<>(currentCombination));
            return;
        }
        
        // Caso base: nos hemos pasado de la cantidad o no hay más billetes que probar
        if (remainingAmount < 0 || currentBillIndex >= availableBills.length) {
            return;
        }
        
        int currentBill = availableBills[currentBillIndex];
        
        // Máximo número de este billete que podemos usar sin pasarnos
        int maxBills = remainingAmount / currentBill;
        
        // Probar con 0, 1, 2, ..., maxBilletes del billete actual
        for (int i = maxBills; i >= 0; i--) {
            int newRemainingAmount = remainingAmount - (i * currentBill);
            
            // Agregar i billetes del tipo actual a la combinación
            for (int j = 0; j < i; j++) {
                currentCombination.add(currentBill);
            }
            
            // Llamar recursivamente con el siguiente tipo de billete
            findCombinations(newRemainingAmount, availableBills, currentBillIndex + 1, 
                           currentCombination, allSolutions);
            
            // Backtrack: remover los billetes agregados
            for (int j = 0; j < i; j++) {
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }
    
    /**
     * Método auxiliar para contar cuántos billetes de un tipo específico hay en una combinación
     */
    private static int countBills(List<Integer> combination, int billValue) {
        int count = 0;
        for (int bill : combination) {
            if (bill == billValue) {
                count++;
            }
        }
        return count;
    }
    
}