# Ramificación y Poda (Branch & Bound) en Java

Este proyecto implementa el **algoritmo de Ramificación y Poda** para resolver el clásico **problema de la mochila (Knapsack problem)**.

Se muestran dos estrategias distintas para gestionar los **nodos vivos (LNV)** del árbol de decisión:
- **FIFO (First In, First Out)** → Exploración en **anchura** (cola).
- **LIFO (Last In, First Out)** → Exploración en **profundidad** (pila).

---

## ¿Qué es Ramificación y Poda?

La **ramificación y poda** es una técnica de búsqueda en árboles para resolver problemas de optimización combinatoria.

- **Ramificación** → dividir el problema en **subproblemas más pequeños** (hijos).
- **Poda** → eliminar ramas que **no pueden mejorar la mejor solución encontrada** hasta ese momento, usando **cotas superiores** (optimistas).

Se diferencia de **backtracking** porque aquí se usan **cotas** (upper/lower bounds) para decidir si merece la pena seguir explorando.

---

## Problema de ejemplo: Mochila Binaria

Se tiene una mochila con capacidad limitada y un conjunto de objetos.  
Cada objeto tiene un **peso** y un **valor**.

El objetivo es **seleccionar objetos** sin superar la capacidad de la mochila, maximizando el valor total.

### Ejemplo usado en el código:

- **Capacidad**: 7
- **Objetos**:
    - A: peso = 3, valor = 25
    - B: peso = 2, valor = 20
    - C: peso = 4, valor = 40

**Solución óptima**: Objetos **A + C = 65** (peso 7).

---

## Funcionamiento del código

### 1. Representación de un objeto
```java
public class Item {
    private String name;
    private int weight;
    private int value;
}
```


### 2. Representación de un node del árbol
```java
public class Node {
    private int level;       
    private int value;       
    private int weight;      
    private int bound;       
    private List<String> taken; 
}
```

### 3. Cálculo de cuota superior (CS)
```java
private int bound(Node node, int capacity, List<Item> items)
```

- Si el peso actual > capacidad → cota = 0 (nodo inválido).
- Añade objetos mientras quepan.
- Si hay espacio sobrante, añade fracción del siguiente objeto (estrategia voraz).

Esto da una estimación optimista del valor máximo alcanzable desde ese nodo.

### 4. Estrategias de exploración

a) FIFO → Anchura (cola)
````java
Queue<Node> queue = new LinkedList<>();
````
- Se extrae siempre el primer nodo generado.
- Se exploran primero los nodos de nivel superficial.

b) LIFO → Profundidad (pila)
```java
Stack<Node> stack = new Stack<>();
```
- Se extrae siempre el último nodo generado.
- Se profundiza en una rama antes de explorar las demás.

### 5. Proceso general
- Crear nodo raíz (mochila vacía).
- Calcular su cota superior.
-  Mientras queden nodos vivos:
- -  Extraer nodo de la lista (FIFO o LIFO).
- - Generar hijos:
- - - Nodo con objeto incluido.
- - - Nodo sin objeto.
- - Si el hijo mejora la mejor solución, actualizar.
- - Si la cota del hijo es prometedora, mantenerlo en la LNV.