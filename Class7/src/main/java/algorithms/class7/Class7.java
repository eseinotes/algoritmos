/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package algorithms.class7;

import java.util.Scanner;

/**
 *
 * @author noeliagarciahervella
 */
public class Class7 {

    public static int[] Temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 10;
        
        int[] numbers;

        while(option != -1){
            System.out.println("1. MergeSort\n2. QuickSort con la partición de Lomuto\n3. QuickSort con la partición de Hoare \n\tIntroduce un número para ejecutar el algoritmo de ordenación deseado: ");
            option = sc.nextInt();
            
            switch (option) { 
                case 1:
                    System.out.println("Has elegido MergeSort");
                    numbers = new int[]{3, 9, 6, 1, 2};
                    System.out.println("El array que se va a ordenar es:");
                    System.out.print("[");
                    for (int i = 0; i < numbers.length-1; i++) {
                        System.out.print(numbers[i]+", ");
                    }
                    System.out.println(numbers[numbers.length-1]+"]");
                    
                    // Se crea un objeto MergeSort, se ordena el array usando el algoritmo MergeSort y se muestra el resultado
                    MergeSort mergeSort = new MergeSort(numbers); 
                    mergeSort.mergeSort();
                    System.out.print("El resultado es: ");
                    mergeSort.showArray(0,numbers.length-1); 
                break;
                case 2:
                    System.out.println("Has seleccionado QuickSort");
                    numbers = new int[]{3, 9, 6, 1, 2};
                    QuickSort quickSortLomuto = new QuickSort(numbers);
                    quickSortLomuto.quickSortlomuto();
                    System.out.print("El resultado es: ");
                    quickSortLomuto.showArray(0, numbers.length-1); 
                break;
                case 3:
                    System.out.println("Has seleccionado QuickSort");
                    numbers = new int[]{3, 9, 6, 1, 2};
                    QuickSort quickSortHoare = new QuickSort(numbers);
                    quickSortHoare.quickSorthoare();
                    System.out.print("El resultado es: ");
                    quickSortHoare.showArray(0, numbers.length-1); 
                break;
                default:
                    System.out.println("Esa opción no está contemplada");
                break;
            } 
            
        }
    }
}
