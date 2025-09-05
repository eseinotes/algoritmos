package com.algorithms.class2;

public class PositiveCounter {
    private int[] array;

    // Constructor
    public PositiveCounter(int[] array) {
        this.array = array;
    }

    // Método público que inicia el conteo
    public int countPositives() {
        return countRecursive(0, array.length - 1);
    }

    // Método recursivo con Divide y Vencerás
    private int countRecursive(int left, int right) {
        // Caso base: un solo elemento
        if (left == right) {
            return array[left] > 0 ? 1 : 0;
        }

        // Dividir el array en dos mitades
        int mid = (left + right) / 2;

        // Contar en cada mitad
        int countLeft = countRecursive(left, mid);
        int countRight = countRecursive(mid + 1, right);

        // Conquista: sumar los conteos
        return countLeft + countRight;
    }
}