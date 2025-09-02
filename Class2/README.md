# 🧩 Ejercicios de Backtracking en Java

Este proyecto contiene ejemplos clásicos para aprender la técnica de **Backtracking** (vuelta atrás) en Java.  
Se incluyen dos problemas muy representativos:

1. 💶 **Retirada de dinero en un cajero automático**
2. 👑 **El problema de las N-Reinas**

---

## 📖 ¿Qué es Backtracking?

El **Backtracking** es una técnica de resolución de problemas que explora todas las soluciones posibles de manera **recursiva**.  
La idea es:

- Construir la solución paso a paso.
- Si llegamos a una situación imposible, **retrocedemos** (backtrack) y probamos otra opción.
- Continuamos hasta encontrar una solución válida o agotar todas las combinaciones.

Se utiliza en problemas como: juegos, combinaciones, optimización, búsquedas en laberintos, y puzzles como el Sudoku o las N-Reinas.

---

## 💶 Ejemplo 1: Retirada en cajero automático

### Problema
Queremos retirar **210 €** de un cajero que solo tiene billetes de **50 € y 20 €**.  
Un algoritmo **greedy** (voraz) fallaría:
- Cogería 4 billetes de 50 € = 200 €, pero faltarían 10 € que no se pueden conseguir.

### Solución con Backtracking
El cajero prueba combinaciones de billetes de 50 € y 20 €.  
Si una combinación no lleva a la cantidad exacta, retrocede y prueba otra hasta encontrar una válida.

Ejemplo de una solución posible:
- 2 billetes de 50 € + 5 billetes de 20 € = 210 €

👉 Este problema está implementado en la clase `ATMWithdrawal`.

---

## 👑 Ejemplo 2: El problema de las N-Reinas

### Problema
Colocar `N` reinas en un tablero de ajedrez `N x N` de manera que:
- No se ataquen entre sí.
- No haya dos reinas en la misma fila, columna ni diagonal.

Ejemplo: Para `N = 8` es el clásico **problema de las 8 reinas**.

### Solución con Backtracking
- Colocamos una reina por fila.
- Probamos todas las columnas posibles.
- Si una posición es inválida, retrocedemos y probamos otra.

👉 Este problema está implementado en la clase `NQueens`.