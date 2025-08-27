package com.cdiclass.class1;

public class ArraySummer {
    private int[] array;

    // Constructor que recibe el array
    public ArraySummer(int[] array) {
        this.array = array;
    }

    // Método público que inicia la suma
    public int sumElements() {
        return sumRecursive(0, array.length - 1);
    }

    // Método recursivo con Divide y Vencerás
    private int sumRecursive(int left, int right) {
        // Caso base: un solo elemento
        if (left == right) {
            return array[left];
        }

        // Dividimos en dos mitades
        int mid = (left + right) / 2;

        // Suma de cada mitad
        int sumLeft = sumRecursive(left, mid);
        int sumRight = sumRecursive(mid + 1, right);

        // Conquista: combinar resultados
        return sumLeft + sumRight;
    }

}
