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
public class MergeSort {

    int nums[];
    private int numberOfCalls; //hace referecia a las veces que se va a llamar a la función recursiva

    public MergeSort(int nums[]) {
        this.nums = nums;
        this.numberOfCalls = 0;
    }

    //Método que inicia la ordenación
    public void mergeSort() {
        //Llamada al método recursivo
        mergeSort(nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] aux, int start, int end) {
        numberOfCalls++;
        System.out.println("Llamada número " + numberOfCalls + " a la función merge");
        System.out.print("\tEl fragmento del array que se procesa en esta llamada es: ");
        this.showArray(start, end);
        if (start < end) {
            int medio = (start + end) / 2;
            //Se crea la recursividad hacia la rama izquierda
            mergeSort(aux, start, medio);
            //Se crea la recursividad hacia la rama derecha
            mergeSort(aux, medio + 1, end);
            /*
            Una vez se devuelve el resultado de cada rama, deben unirse de forma que los
            elementos sigan ordenados a través de merge
             */
            
            System.out.print("Se mezclan: \n\t" );
            showArray(start, medio);
            System.out.print("\t" );
            showArray(medio+1, end);
            
            merge(aux, start, medio, medio + 1, end);
            
        }

    }

    public static void merge(int[] aux, int start1, int end1, int start2, int end2) {
        int i = start1; //Indice donde se encuentra el primer elemento de la primera sublista
        int j = start2; //Indice donde se encuentra el primer elemento de la segunda sublista

        ArrayList<Integer> temp = new ArrayList<>(); //Lista auxiliar en la que se guardan los elementos de ambas listas ordenados

        //Se introducen elementos en la estructura axiliar hasta que una de las listas esté vacía
        while (i <= end1 && j <= end2) {
            if (aux[i] <= aux[j]) {
                temp.add(aux[i++]);
            } else {
                temp.add(aux[j++]);
            }
        }

        //Se comprueba si quedan elementos en la primera lista
        while (i <= end1) {
            temp.add(aux[i++]);
        }

        //Se comprueba si quedan elementos en la segunda lista
        while (j <= end2) {
            temp.add(aux[j++]);
        }

        //Se pasan todos los elementos de la lista temporal al array
        for (i = start1; i <= end2; i++) {
            aux[i] = temp.remove(0);
        }

    }

    public void showArray(int start, int end) {
        System.out.print("[");
        for (int i = start; i <= end; i++) {
            if (i == (end )) {
                System.out.print(nums[i]);
            } else {
                System.out.print(nums[i] + ",");
            }
        }
        System.out.println("]");
    }

}
