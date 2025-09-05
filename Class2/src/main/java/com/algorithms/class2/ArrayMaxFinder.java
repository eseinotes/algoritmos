
package com.algorithms.class2;

public class ArrayMaxFinder {
    private int[] array;

    // Constructor que recibe el array
    public ArrayMaxFinder(int[] array) {
        this.array = array;
    }

    // Método público que llama al algoritmo recursivo
    public int findMax() {
        return findMaxRecursive(0, array.length - 1);
    }

    // Método privado recursivo (Divide y Vencerás)
    private int findMaxRecursive(int left, int right) {
        // Caso base: si el subarray tiene un solo elemento
        if (left == right) {
            return array[left];
        }

        // Dividir el array en dos mitades
        int mid = (left + right) / 2;

        // Llamadas recursivas en cada mitad
        int maxLeft = findMaxRecursive(left, mid);
        int maxRight = findMaxRecursive(mid + 1, right);

        // Conquistar: elegir el mayor de ambos
        return Math.max(maxLeft, maxRight);
    }
}