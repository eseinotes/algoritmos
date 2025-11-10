
package algorithms.class6; 
import java.util.Scanner;

public class Class6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 10;
        
        int[] numbers;

        while(option != -1){
            System.out.println("Introduce un número: ");
            option = sc.nextInt();
            
            switch (option) { 
                case 1:
                    System.out.println("Ordenación por inserción");
                    numbers = new int[]{3, 9, 6, 1, 2};
                    InsertionSort insertionSort = new InsertionSort(numbers);
                    insertionSort.sort();
                    insertionSort.showArray(); 
                break;
                case 2:
                    System.out.println("Ordenación por selección");
                    numbers = new int[]{3, 9, 6, 1, 2};
                    SelectionSort selectionSort = new SelectionSort(numbers);
                    selectionSort.sort();
                    selectionSort.showArray();
                break;
                case 3:
                    System.out.println("Ordenación por selección");
                    numbers = new int[]{3, 9, 6, 1, 2};
                    BubbleSort bubbleSort = new BubbleSort(numbers);
                    bubbleSort.sort();
                    bubbleSort.showArray();
                break;
                default:
                    System.out.println("Esa opción no está contemplada");
                break;
            } 
            
        }
    }
}
