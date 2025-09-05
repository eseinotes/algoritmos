package com.algorithms.class1;

public class LinearSearch {
    
    private int[] array;
    
    LinearSearch(int[] array){
        this.array = array;
    }
    
    public int search(int target){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // posición encontrada
            }
        }
        return -1; // no encontrado
    }
    
    
    
}
