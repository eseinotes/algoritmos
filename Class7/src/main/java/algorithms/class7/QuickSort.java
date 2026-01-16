/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms.class7;

import java.util.ArrayList;

/**
 *
 * @author noeliagarciahervella
 */
public class QuickSort {

    int nums[];
    private int numberOfCalls; //hace referecia a las veces que se va a llamar a la función recursiva

    public QuickSort(int nums[]) {
        this.nums = nums;
        this.numberOfCalls = 0;
    }
    
    //Método que inicia la ordenación
    public void quickSortlomuto() {
        quickSortlomuto(nums, 0, nums.length - 1);
    }

    public void quickSortlomuto(int[] arr, int start, int end) {
        
        int numberThisCall = numberOfCalls++;
        System.out.println("Llamada número " + numberThisCall + " a la función merge");
        System.out.print("\tEl fragmento del array que se procesa en esta llamada es: ");
        this.showArray(start, end);

        if (start < end) {
            //Seleccionamos el pivote. Se colocan los elementos menores a la izquierda y mayores a la derecha
            int pi = lomutoPartition(arr, start, end);
            
            System.out.print("Resultado de la partición de lomuto: \n\t" );
            showArray(start, pi-1);
            System.out.print("\t" );
            showArray(pi+1, end);
            
            //Se crea la recursividad hacia la rama izquierda
            quickSortlomuto(arr, start, pi - 1);
            //Se crea la recursividad hacia la rama derecha
            quickSortlomuto(arr, pi + 1, end);
            
            
            System.out.print("Resultado de la llamada "+ numberThisCall+" de quickSortlomuto: \t" );
            this.showArray(start, end);
        }
    }

    public static int lomutoPartition(int[] arr, int start, int end) {

        int pivot = arr[end]; //Selecciona pivote
        System.out.println("\tEl pivote es: " + pivot);
        int i = (start - 1); //Apunta al último elemento (que el pivote) encontrado
        
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {// Se mueve el elemento a la izquierda
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        //Se coloca el pivote en su posición final
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        return i + 1;
    }

    public void quickSorthoare() {
        quickSorthoare(nums, 0, nums.length - 1);
    }

    public void quickSorthoare(int[] arr, int start, int end) {
        System.out.print("Entrar quickSort: [");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println("]");
        if (start < end) {
            int pi = hoarePartition(arr, start, end);
            quickSorthoare(arr, start, pi);
            quickSorthoare(arr, pi + 1, end);
        }
    }

    public static int hoarePartition(int[] arr, int start, int end) {
        int pivot = arr[start]; //selecciona pivote
        int i = start - 1;
        int j = end + 1;
        while (i < j) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        System.out.print("Salir hoarePartition: [");
        for (int a = start; a <= end; a++) {
            System.out.print(arr[a] + ",");
        }
        System.out.println("]");
        return j;
    }

    public void showArray(int start, int end) {
        System.out.print("[");
        for (int i = start; i <= end; i++) {
            if (i == (end)) {
                System.out.print(nums[i]);
            } else {
                System.out.print(nums[i] + ",");
            }
        }
        System.out.println("]");
    }
}
