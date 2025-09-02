
package com.cdiclass.class2;

public class NQueens {
    
    private int n = 9; // Cambia este valor a 8, 9, 10... para probar con otro número de reinas
        
    NQueens(int n){
        this.n = n;
    }
    
    
    public void getSolveNQueens() {
        int[][] board = new int[n][n];
                
        if (solveNQueens(board, 0)) {
            printBoard(board);
        } else {
            System.out.println("No existe solución");
        }
    }
    
    // Función principal de backtracking
    private boolean solveNQueens(int [][] board, int row) {
        
        // Caso base: si hemos colocado todas las reinas
        if (row >= n) {
            return true;
        }
        
        // Intentar poner una reina en cada columna de la fila actual
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1; // Colocamos la reina
                
                // Llamada recursiva para la siguiente fila
                if (solveNQueens(board, row + 1)) {
                    return true;
                }
                
                // Si no funciona, hacemos backtracking
                board[row][col] = 0;
            }
        }
        
        // Si no hay lugar válido en esta fila, retrocedemos
        return false;
    }
    
    // Verificar si es seguro poner una reina en board[row][col]
    private boolean isSafe(int[][] board, int row, int col) {
        // Comprobar columna
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }
        
        // Comprobar diagonal superior izquierda
        for (int i = row-1, j = col-1; i >=0 && j >=0; i--, j--) {
            if (board[i][j] == 1) return false;
        }
        
        // Comprobar diagonal superior derecha
        for (int i = row-1, j = col+1; i >=0 && j < n; i--, j++) {
            if (board[i][j] == 1) return false;
        }
        
        return true;
    }
    
    // Imprimir el tablero
    private void printBoard(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((board[i][j] == 1 ? "Q " : ". "));
            }
            System.out.println();
        }
    }
}