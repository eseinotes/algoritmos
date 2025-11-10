/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms.class6;

/**
 *
 * @author noeliagarciahervella
 */
public class SelectionSort {
    
    private int numbers[];
    
    public SelectionSort(int numbers[]){
        this.numbers = numbers;
    }
    
    public void sort(){
 
        for(int i=0; i<numbers.length-1; i++){
            int posMinValue = i;
            for(int j=i+1; j<numbers.length; j++){
                if(numbers[posMinValue] > numbers[j]){
                    posMinValue = j;
                }
            }
            if(posMinValue != i){
                int aux = numbers[posMinValue];
                numbers[posMinValue] = numbers[i];
                numbers[i] = aux;
            }
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
