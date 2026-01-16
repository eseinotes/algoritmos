
# Algoritmos de Ordenación en Java
Este proyecto implementa y ejecuta varios algoritmos clásicos de **ordenación**, pensados para entender sus diferencias y aplicaciones:

1. **Algoritmo por inserción**
2. **Algoritmo por selección**
3. **Algoritmo por burbuja**
4. **Algoritmo Mergesort**
5. **Algoritmo Quicksort**

---

##  1. Algoritmo: Ordenación por inserción (Insertion Sort)

### 🧠 Descripción
Este algoritmo se utiliza para **ordenar** una estructura contruyendo un subconjunto ordenado. En cada paso se toma un elemento de la parte no ordenada y se **inserta en su posición correcta dentro de la parte ya ordenada**, desplazando a la derecha a los elementos mayores.

🎯 Estrategia general:
- Ordenar **los elementos** que forman parte del array **de menor a mayor**.

- Tomar elemento a elemento para irlo colocando en la posición correcta.
    - Se supone que los **(i-1)** primeros elementos están ordenados. 
    - Se toma el elemento i.
    - Se busca la posición correcta del elemento en el subarray ordenado.
    - Se inserta dicho elemento, obteniendo i elementos ordenados.

### 📌 Ejemplo de funcionamiento:

1. Estado inicial: <code>[<span class="orange">3</span>, 9, 6, 1, 2]</code>
    - Se considera que el primer elemento <code>(3)</code> ya está ordenado.
    - Resultado: <code>[<span class="purple">3</span> | 9, 6, 1, 2]</code>
2. <code>[3, <span class="orange">9</span>, 6, 1, 2]</code>
    - Seleccionamos el siguiente elemento <code>(9)</code>.
    - Lo comparamos con el subconjunto ordenado <code>[<span class="purple">3</span>]</code>
        - <code>(9)</code> es mayor que <code>(3)</code>, por lo que ya está en su lugar.
    - Resultado: <code>[<span class="purple">3</span>, <span class="purple">9</span> | 6, 1, 2]</code>

3. <code>[3, 9, <span class="orange">6</span>, 1, 2]</code>
    - Seleccionamos el siguiente elemento <code>(6)</code>.
    - Lo comparamos con el elemento más a la derecha del subconjunto ordenado <code>[<span class="purple">3</span>, <span class="purple">9</span>]</code>
        - <code>(6)</code> es menor que <code>(9)</code>:
            - Desplazamos <code>(9)</code> a la derecha para dejar hueco al valor actual.       <code>[<span class="purple">3</span>, <span class="purple">9</span>, 9, 1, 2]</code>
    - Lo comparamos con siguiente valor del subconjunto ordenado <code>[<span class="purple">3</span>, <span class="purple">9</span>]</code>
        - <code>(6)</code> es mayor que <code>(3)</code> por lo que ya podemos guardar el valor en el subconjunto ordenado.
    - Resultado: <code>[<span class="purple">3</span>, <span class="purple">6</span>, <span class="purple">9</span> | 1, 2]</code>
4. Se debe continuar con el desarrollo hasta conseguir que el conjunto esté completamente ordenado.
---
##  2. Algoritmo: Ordenación por selección (Selection Sort)

### 🧠 Descripción
Este algoritmo se utiliza para **ordenar** una estructura dividiéndola en dos partes: un subconjunto **ordenado** al inicio (izquierda) y un subconjunto **no ordenado** al final (derecha). En cada paso **busca el elemento más pequeño** en la parte no ordenada y **lo intercambia** con el primer elemento de esa parte no ordenada, ampliando así el subconjunto ordenado.


🎯 Estrategia general:
- Ordenar **los elementos** que forman parte del array **de menor a mayor**.

- Ir tomando elemento a elemento de la estructura de forma que, al seleccionar un elemento se compare con los demás para colocarlo en la posición correcta.
    - Se supone que los **(i-1)** primeros elementos están ordenados. 
    - Se toma el elemento i.
    - Se compara con todos los valores pertenecientes al subarray no ordenado para encontrar la posición del elemento más pequeño (mínimo).
    - Se intercambia el elemento mínimo encontrado con el elemento que se encuentra actualmente en la posición i (primer elemento del subarray no ordenado), obteniendo i elementos ordenados .

### 📌 Ejemplo de funcionamiento:

1. Estado inicial: <code>[<span class="orange">3</span>, 9, 6, 1, 2]</code>
    - Se selecciona el primer elemento (i=0) del subconjunto desordenado (ahora mismo es el conjunto completo). 
    - Se establece el menor valor es el primer elemento (menor=3). 
    - Se compara el menor valor con el siguiente elemento (i+1)
        - <code>(3)</code> es menor que <code>(9)</code>, por lo que seguiremos buscando un valor menor.
    - Se compara el menor valor con el siguente elemento (i+2)
        - <code>(3)</code> es menor que <code>(6)</code>, por lo que seguiremos buscando un valor menor.
    - Se compara el menor valor con el siguente elemento (i+3)
        - <code>(3)</code> es mayor que <code>(1)</code>
            - Se actualiza el valor de menor (menor=1)
    - Se compara el menor valor con el siguente elemento (i+4)
        - <code>(1)</code> es menor que <code>(2)</code>, por lo que seguiremos buscando un valor menor.
    - Se deja de recorrer el array ya que no hay más elementos
    - Se intercambian el valor guardado en la posición i con el  la el menor valor encontrado.
    - Resultado: <code>[<span class="purple">1</span> | 9, 6, 3, 2]</code>
2. <code>[1, <span class="orange">9</span>, 6, 3, 2]</code>
    - Se selecciona el primer elemento (i=1) del subconjunto desordenado. 
    - Se establece el menor valor es el primer elemento (menor=9). 
    - Se compara el menor valor con el siguiente elemento (i+1)
        - <code>(9)</code> es mayor que <code>(6)</code>
            - Se actualiza el valor de menor (menor=6)
    - Se debe continuar con el desarrollo hasta conseguir que el conjunto esté completamente ordenado.

##  3. Algoritmo: Ordenación Burbuja (Bubble Sort)

### 🧠 Descripción
Este algoritmo se utiliza para **ordenar** una estructura comparando e intercambiando repetidamente pares de elementos adyacentes que estén en el orden incorrecto. El efecto es que los elementos más grandes (o "burbujas") **flotan** gradualmente hacia el final del array con cada pasada.

🎯 Estrategia general:
- Ordenar **los elementos** que forman parte del array **de menor a mayor**.

- Comparar elementos adyacentes repetidamente e intercambiarlos si están en el orden incorrecto, para que los elementos más grandes o pequeños se muevan gradualmente a su posición final.

    - Se recorre la lista (o array) comparando pares de elementos adyacentes.
    - Si un par está en el orden incorrecto (por ejemplo, el primero es mayor que el segundo para un orden ascendente), se intercambian.
    - Tras la primera pasada (o iteración completa), el elemento más grande (o el más pequeño) del array "burbujea" hasta su posición final en el extremo del array.
    - Se repiten los pasos anteriores, excluyendo el último elemento ya ordenado, hasta que no se necesiten más intercambios en una pasada completa, lo que indica que el array está ordenado.



### 📌 Ejemplo de funcionamiento:

1. Estado inicial: <code>[<span class="orange">3</span>, 9, 6, 1, 2]</code>
    - Se selecciona el primer elemento (i=0). 
        - Se compara el elemento <code>(3)</code> con su siguiente <code>(9)</code>
            - <code>(3)</code> es menor que <code>(9)</code>, por lo que esos dos elementos estan ordenados en referencia al otro.
    - Se selecciona el siguiente elemento (i+1).
        - Se compara el elemento <code>(9)</code> con su siguiente <code>(6)</code>
            - <code>(9)</code> es mayor que <code>(6)</code>, por lo que esos dos elementos no estan ordenados en referencia al otro.
            - Se intercambian los valores para que estén ordenados entre sí. <code>[<span class="purple">3</span>, <span class="purple">6</span>, 9, 1, 2]</code>
    - Se selecciona el siguiente elemento (i+2).
    - Se compara el elemento <code>(9)</code> con su siguiente <code>(1)</code>
        - <code>(9)</code> es mayor que <code>(1)</code>, por lo que esos dos elementos no estan ordenados en referencia al otro.
        - Se intercambian los valores para que estén ordenados entre sí. <code>[<span class="purple">3</span>, <span class="purple">6</span>, <span class="purple">1</span>, 9, 2]</code>
    - Se selecciona el siguiente elemento (i+3).
    - Se compara el elemento <code>(9)</code> con su siguiente <code>(2)</code>
        - <code>(9)</code> es mayor que <code>(2)</code>, por lo que esos dos elementos no estan ordenados en referencia al otro.
        - Se intercambian los valores para que estén ordenados entre sí. <code>[<span class="purple">3</span>, <span class="purple">6</span>, <span class="purple">1</span>, <span class="purple">2</span>, 9]</code>
    - Se seleccionaría el siguiente elemento (i+4). Como no hay elemento con el qué compararlo esta iteración debe finalizar.
    - Resultado: <code>[<span class="purple">3</span>, <span class="purple">6</span>, <span class="purple">1</span>, <span class="purple">2</span>, 9]</code>
2. <code>[<span class="orange">3</span>, 6, 1, 2, 9]</code>
    - Se selecciona el primer elemento (i=0). 
        - Se compara el elemento <code>(3)</code> con su siguiente <code>(6)</code>
            - <code>(3)</code> es menor que <code>(6)</code>, por lo que esos dos elementos estan ordenados en referencia al otro.
    - Se debe continuar con el desarrollo hasta conseguir que el conjunto esté completamente ordenado.

