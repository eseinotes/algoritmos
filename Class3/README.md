# Algoritmos de Grafos y Voraces en Java

Este proyecto implementa y ejecuta varios algoritmos clásicos de **optimización y grafos**, pensados para entender sus diferencias y aplicaciones:

1. **Algoritmo voraz de selección de actividades**
2. **Kruskal (Árbol de Expansión Mínima - MST)**
3. **Prim (Árbol de Expansión Mínima - MST)**
4. **Dijkstra (Caminos más cortos desde un origen)**

---

##  1. Algoritmo voraz: **Selección de actividades**

### 📝 Descripción
Este es un algoritmo **greedy** (voraz).  
Se usa cuando tenemos un conjunto de actividades con **hora de inicio y fin**, y queremos seleccionar el **máximo número de actividades compatibles** (que no se solapen).

👉 Estrategia:
- Ordenar las actividades por **hora de finalización**.
- Ir seleccionando siempre la actividad que acabe más pronto y no se solape con la anterior.

### 📊 Ejemplo en el código:
```java
A1: 9–10
A2: 9–12
A6: 10–11
A3: 11–12
A4: 12–14
A5: 14–15
```

## 2. Kruskal: Árbol de Expansión Mínima (MST)

### 📝 Descripción
El algoritmo de Kruskal encuentra un árbol de expansión mínima (MST) en un grafo no dirigido y ponderado.
Esto significa conectar todos los nodos con el mínimo coste total sin ciclos.

👉 Estrategia:

- Ordenar las aristas de menor a mayor peso.
- Ir añadiendo aristas siempre que no formen un ciclo (Union-Find).
- Se detiene cuando todos los nodos están conectados.

### 📊 Ejemplo en el código:
```java
A-B (1), A-C (3), B-C (2), B-D (4), C-D (5)
```

## 3. Prim: Árbol de Expansión Mínima (MST)

### 📝 Descripción
El algoritmo de Prim también construye un MST, pero funciona de manera distinta a Kruskal.
Se parece a Dijkstra porque crece el árbol desde un nodo inicial.

👉 Estrategia:
- Empezar en un nodo.
- Seleccionar la arista más barata que conecta el árbol con un nuevo nodo.
- Repetir hasta incluir todos los nodos.

📊 Ejemplo empezando en A:
- De A tomamos A-B (1)
- Luego B-C (2)
- Finalmente B-D (4)

El MST es el mismo que con Kruskal: A-B, B-C, B-D

## 4. Dijkstra: Caminos más cortos desde un origen

### 📝 Descripción
El algoritmo de Dijkstra encuentra la distancia más corta desde un nodo origen a todos los demás nodos en un grafo ponderado (sin pesos negativos).

👉 Estrategia:
- Asignar distancia 0 al nodo inicial y ∞ al resto.
- Ir eligiendo siempre el nodo con menor distancia conocida.
- Relajar sus aristas (actualizar distancias si encontramos un camino más corto).
- Repetir hasta procesar todos los nodos.

📊 Ejemplo en el código (grafo gd):
```java 
A-B (4), A-C (2), A-E (7), B-C (3), B-D (1), C-E (2), D-E (2)
```
Caminos mínimos desde A:
- A → A = 0
- A → C = 2
- A → B = 4 (por A-B)
- A → D = 5 (A-B-D o A-C-B-D)
- A → E = 4 (A-C-E)