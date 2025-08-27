# Ejercicios de Recursividad y Divide y Vencerás en Java

Este proyecto contiene una serie de **ejercicios básicos en Java** para comprender los conceptos de **recursividad** y la estrategia de **Divide y Vencerás**.

El código está preparado con un menú interactivo (en la clase `Class1`) donde puedes seleccionar qué ejercicio ejecutar.

---

## 📚 Contenidos

1. Factorial (iterativo y recursivo)
2. Invertir una cadena (recursivo)
3. Sucesión de Fibonacci (recursivo)
4. Máximo en un array (Divide y Vencerás)
5. Suma de elementos de un array (Divide y Vencerás)
6. Contar elementos positivos en un array (Divide y Vencerás)

---

## 1. Factorial

El **factorial de un número n** (n!) es el producto de todos los enteros positivos desde 1 hasta n.  
Se puede resolver tanto **iterativamente** como **recursivamente**.

Se define como `n * factorial(n-1)` con el **caso base** `factorial(0) = 1`.

📌 **Ejemplo**:

`factorial(5) = 5 * 4 * 3 * 2 * 1 = 120`

---

##  2. Invertir una cadena (recursivo)

Dada una cadena, se devuelve la misma pero al revés.  
La recursividad funciona tomando el **primer carácter** y colocándolo al final de la cadena invertida del resto.

📌 **Ejemplo**:  

`"hola" → "aloh"`


---

## 3. Sucesión de Fibonacci (recursivo)

La sucesión de Fibonacci se define como:


📌 **Ejemplo**:  

`F(6) = 8`


---

## 4. Máximo en un array (Divide y Vencerás)

Clase: **`ArrayMaxFinder`**

1. El array se divide en dos mitades.
2. Se obtiene el máximo en cada mitad de forma recursiva.
3. Se comparan ambos resultados para devolver el mayor.

📌 **Ejemplo**:  

`[3, 17, 9, 25, 42, 7, 13, 29] → Máximo = 42`


---

## 5. Suma de elementos de un array (Divide y Vencerás)

Clase: **`ArraySummer`**

1. El array se divide en mitades.
2. Se suman los valores de cada mitad recursivamente.
3. Se combinan los resultados hasta obtener la suma total.

📌 **Ejemplo**:  

`[2, 4, 6, 8, 10] → Suma = 30`


---

## 6. Contar elementos positivos en un array (Divide y Vencerás)

Clase: **`PositiveCounter`**

1. El array se divide en dos mitades.
2. En cada parte se cuentan los positivos de forma recursiva.
3. Se suman los resultados.

📌 **Ejemplo**:  

`[-3, 5, 0, 7, -2, 9, -1] → Positivos = 3`


---

## Objetivo

- Comprender cómo funcionan los **métodos recursivos**.
- Identificar la importancia de los **casos base**.
- Aplicar la estrategia de **Divide y Vencerás** para resolver problemas de arrays.
- Comparar enfoques **iterativos vs recursivos**.

Estos ejercicios son un primer paso hacia problemas más complejos de recursividad como búsqueda binaria, ordenación rápida (Quicksort) o multiplicación de matrices.

---
