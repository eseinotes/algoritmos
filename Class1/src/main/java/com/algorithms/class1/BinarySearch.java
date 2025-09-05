package com.algorithms.class1;

public class BinarySearch {
    
    private int[] array;
    
    BinarySearch(int[] array){
        this.array = array;
    }  
    
    public int search(int target){
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == target) return mid;
            if (array[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1; // no encontrado
    }
}