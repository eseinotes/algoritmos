/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms.class6;

/**
 *
 * @author noeliagarciahervella
 */
public class InsertionSort {
    private int numbers[];
    
    public InsertionSort(int numbers[]){
        this.numbers = numbers;
    }
    
    public void sort(){
 
        for(int i=1; i<numbers.length; i++){
            
            int elem = numbers[i];
            int j = i-1;
            
            while((j>=0) && (elem < numbers[j])){
                numbers[j+1] = numbers[j]; 
                j--;
            }
            
            numbers[j+1] = elem;  
        }
    }
    
    public void showArray(){
        System.out.print("[");
        for(int i=0; i< numbers.length; i++){
            if(i== (numbers.length-1)) System.out.print(numbers[i]); 
            else System.out.print(numbers[i]+",");
        }
        System.out.println("]");
    }
    
}
