# Grafos
Este proyecto implementa y ejecuta varias implementaciones de **grafos**, con el objetivo de entender su lógica y sus aplicaciones.  A continuación se presentan los principales contenidos:

1. **Implementaciones de grafos**  
   Diferentes formas de representar y manipular grafos en Java.
2. **Recorridos de grafos**  
   Ejemplos de **DFS (Depth-First Search)** y **BFS (Breadth-First Search)** para explorar grafos.

---

##  1. Implementación de Grafos

- Lista de arcos
- Lista de adyacencia
- Matriz de adyacencia

##  2.1. Recorrido en profundidad DFS (Depth-First Search)

### 🧠 Descripción
El recorrido en profundidad (DFS) tiene como objetivo explorar todos los vértices y aristas de un grafo siguiendo ramas completas antes de retroceder. Se utiliza para recorrer grafos, analizar su estructura, detectar componentes conectados, buscar caminos o ciclos y servir de base para algoritmos más complejos, como detección de puentes, ordenamiento topológico o resolución de laberintos.

🎯 Estrategia general:

- Se visita el vértice inicial 𝑣 y se marca como visitado.
- Se selecciona un vértice adyacente no visitado 𝑤 y se realiza el recorrido desde él:
    - Se aplica recursivamente DFS sobre  𝑤.
    - Cada vértice visitado se añade al conjunto visitados.
- Cuando un vértice no tiene adyacentes no visitados, se retrocede:
    - Se vuelve al último vértice visitado que tenga adyacentes sin explorar.
    - Se repite el paso de seleccionar un vértice adyacente no visitado.
- El recorrido continúa hasta que todos los vértices alcanzables desde el inicial hayan sido visitados.

    💡 Nota:
    Se mantiene un conjunto visitados para controlar los vértices recorridos y evitar repeticiones. Inicialmente, este conjunto está vacío.

### 📌 Ejemplo de funcionamiento:

- Se utilizan estructuras típicas para mostrar el estado del algoritmo en cada paso:
    - **Visitados:** lista de vértices ya visitados.  
    - **Estructura de trabajo:** pila en la que se meten los vértices que quedan por explicara.  
    - **Aristas exploradas:** aristas consideradas en cada paso.
    💡 Nota:
    El recorrido se realiza **desde el vértice 2**.

---

        | Paso | Vértice visitado | Visitados        | Pila (Worklist) | Arista explorada |
        |------|------------------|------------------|-----------------|------------------|
        | 1    |                  | []               | [2]             |                  |
        | 2    | 2                | [2]              | [2,3]           |                  |
        | 2    | 3                | [2,3]            | [2,3,5]         | 2 → 3            |
        | 3    | 5                | [2,3,5]          | [2,3,5,7]       | 3 → 5            |
        | 4    | 7                | [2,3,5,7]        | [2,3,5,7,8]     | 5 → 7            |
        | 5    | 8                | [2,3,5,7,8]      | [2,3,5,7]       | 7 → 8            |
        | 6    | 7                | [2,3,5,7,8]      | [2,3,5]         |                  |
        | 7    | 5                | [2,3,5,7,8]      | [2,3]           |                  |
        | 8    | 3                | [2,3,5,7,8]      | [2,3,6]         |                  |
        | 9    | 6                | [2,3,5,7,8,6]    | [2,3]           | 3 → 6            |
        | 10   | 3                | [2,3,5,7,8,6]    | [2]             |                  |
        | 11   | 2                | [2,3,5,7,8,6]    | [2,4]           |                  |
        | 12   | 4                | [2,3,5,7,8,6,4]  | [2]             | 2 → 4            |
        | 13   | 2                | [2,3,5,7,8,6,4]  | []              |                  |

        Orden final de visita: 2, 3, 5, 7, 8, 6, 4 
        Conjunto de aristas visitadas: 2→3, 3→5, 5→7, 7→8, 3→6, 2→4  



---

##  2.2. Recorrido en anchura BFS (Breadth-First Search)

### 🧠 Descripción
El recorrido en anchura (BFS, Breadth-First Search) tiene como objetivo explorar todos los vértices y aristas de un grafo nivel por nivel, es decir, visitando primero todos los vecinos más cercanos antes de pasar a los siguientes niveles. Se utiliza para recorrer grafos, analizar su estructura, encontrar el camino más corto entre vértices en grafos no ponderados, detectar componentes conectados, y servir de base para algoritmos más complejos, como búsqueda de rutas, flujo máximo, propagación de información o detección de ciclos.

🎯 Estrategia general:

- Se visita el vértice inicial 𝑣 y se marca como visitado.
- Se añaden a una cola (Worklist) todos los vértices adyacentes no visitados de 𝑣.
- Mientras la cola no esté vacía:
    - Se extrae el primer vértice de la cola 𝑤 y se visita.
    - Cada vértice visitado se añade al conjunto visitados.
    - Se agregan a la cola los adyacentes no visitados de 𝑤 w.
- El recorrido continúa hasta que todos los vértices alcanzables desde el inicial hayan sido visitados.

    💡 Nota:
    Se mantiene un conjunto visitados para controlar los vértices recorridos y evitar repeticiones. Inicialmente, este conjunto está vacío.

### 📌 Ejemplo de funcionamiento:

- Se utilizan estructuras típicas para mostrar el estado del algoritmo en cada paso:  
    - **Visitados:** lista de vértices ya visitados.  
    - **Estructura de trabajo:** **cola** con los vértices pendientes de visitar.  
    - **Aristas exploradas:** aristas consideradas en cada paso. 
    💡 Nota:
    El recorrido se realiza **desde el vértice 2**.

---

### BFS (Recorrido en anchura)

        | Paso | Vértice visitado | Visitados        | Cola (Worklist) | Arista explorada |
        |------|------------------|------------------|-----------------|------------------|
        | 1    | 2               | [2]               | [3,4,5]         |                  |
        | 2    | 3               | [2,3]             | [4,5,6]         | 2 → 3            |
        | 3    | 4               | [2,3,4]           | [5,6,8]         | 2 → 4            |
        | 4    | 5               | [2,3,4,5]         | [6,8,7]         | 2 → 5            |
        | 5    | 6               | [2,3,4,5,6]       | [8,7]           | 3 → 6            |
        | 6    | 8               | [2,3,4,5,6,8]     | [7]             | 4 → 8            |
        | 7    | 7               | [2,3,4,5,6,8,7]   | []              | 5 → 7          |

        Orden final de visita: 2, 3, 4, 5, 6, 8, 7  
        Conjunto de aristas visitadas: 2→3, 2→4, 2→5, 3→6, 4→8, 5→7
---
