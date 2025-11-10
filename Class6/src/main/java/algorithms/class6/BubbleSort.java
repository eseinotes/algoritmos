
package algorithms.class6;

public class BubbleSort {
    private int numbers[];
    
    public BubbleSort(int numbers[]){
        this.numbers = numbers;
    }
    
    public void sort(){
        for(int pasada=0; pasada<numbers.length-1; pasada++){
            for(int i=0; i<(numbers.length-1-pasada); i++){
                if(numbers[i] > numbers[i+1]){
                    int aux = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = aux;
                }
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
