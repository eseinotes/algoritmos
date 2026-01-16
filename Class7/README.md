
# Algoritmos de Ordenación en Java
Este proyecto implementa y ejecuta varios algoritmos clásicos de **ordenación**, pensados para entender sus diferencias y aplicaciones:

1. **Algoritmo por inserción**
2. **Algoritmo por selección**
3. **Algoritmo por burbuja**
4. **Algoritmo Mergesort**
5. **Algoritmo Quicksort**

---

##  1. Algoritmo: MergeSort

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

***1. Estado inicial: <code>[3, 9, 6, 1, 2]</code>***
- <code>inicio = 0</code>, <code>fin = 4</code>, <code>medio = (0+4)/2 = 2</code>
- Se realiza la llamada recursiva con los elementos de la izquierda: <code>[3, 9, 6]</code>

    ***1.1. Subconjunto con el que se va a trabajar: [<code>3, 9, 6</code>, 1, 2]***
    - <code>inicio = 0</code>, <code>fin = 2</code>, <code>medio = (0+2)/2 = 1</code>
    - Se realiza la llamada recursiva con los elementos de la izquierda:  <code>[3, 9]</code>

        ***1.1.1. Subconjunto con el que se va a trabajar: [<code>3, 9</code>, 6, 1, 2]***
        - <code>inicio = 0</code>, <code>fin = 1</code>, <code>medio = (0+1)/2 = 0</code>
        - Se realiza la llamada recursiva con los elementos de la izquierda: <code>[3]</code>

            ***1.1.1.1. Subconjunto con el que se va a trabajar: [<code>3</code>, 9, 6, 1, 2]*** 
            - <code>inicio = 0</code>, <code>fin = 0</code>
            - Cuando <code>inicio == fin</code> ya no es posible fragmentar más el array. Este es el caso base de la recursión, por lo que se retorna a la llamada recursiva anterior.

        ***1.1.1. Subconjunto con el que se va a trabajar: [<code>3, 9</code>, 6, 1, 2]***
        - La llamada recursiva con los elementos de la izquierda (<code>[3]</code>) devuelve el subconjunto ya ordenado.
        - Se realiza la llamada recursiva con los elementos de la derecha: <code>[9]</code>

            ***1.1.1.2. Subconjunto con el que se va a trabajar: [3, <code>9</code>, 6, 1, 2]***
            - <code>inicio = 1</code>, <code>fin = 1</code>
            - Cuando <code>inicio == fin</code> ya no es posible fragmentar más el array. Este es el caso base de la recursión, por lo que se retorna a la llamada recursiva anterior.

        ***1.1.1. Subconjunto con el que se va a trabajar: [<code>3, 9</code>, 6, 1, 2]***
        - La llamada recursiva con los elementos de la derecha (<code>[9]</code>) devuelve el subconjunto ordenado.
        - Las llamadas recursivas han finalizado tanto para el subconjunto izquierdo (<code>[3]</code>)como para el derecho (<code>[9]</code>), obteniendo así dos arrays ya ordenados.
        - Ambos arrays deben combinarse en uno solo, manteniendo el orden de sus elementos. Para ello, se invoca la ***función merge (1.1.1)***, encargada de realizar la mezcla.
        - Con esto finaliza la llamada recursiva actual, devolviendo a la llamada anterior el resultado parcial obtenido, donde los elementos <code>[3, 9]</code> ya han sido ordenados: [<code>3, 9</code>, 6, 1, 2].
    
    ***1.1. Subconjunto con el que se va a trabajar: [<code>3, 9, 6</code>, 1, 2]***
    - La llamada recursiva con los elementos de la izquierda (<code>[3, 9]</code>) devuelve el subconjunto ordenado.
    - Se realiza la llamada recursiva con los elementos de la derecha: <code>[6]</code>
        
        ***1.1.2. Subconjunto con el que se va a trabajar: [3, 9, <code>6</code>, 1, 2]***
        - <code>inicio = 2</code>, <code>fin = 2</code>
        - Cuando <code>inicio == fin</code> ya no es posible fragmentar más el array. Este es el caso base de la recursión, por lo que se retorna a la llamada recursiva anterior.

    ***1.1. Subconjunto con el que se va a trabajar: [<code>3, 9, 6</code>, 1, 2]***
    - La llamada recursiva con los elementos de la derecha (<code>[6]</code>) devuelve el subconjunto ordenado.
    - Las llamadas recursivas han finalizado tanto para el subconjunto izquierdo (<code>[3,9]</code>) como para el derecho (<code>[6]</code>), obteniendo así dos arrays ya ordenados. 
    - Ambos arrays deben combinarse en uno solo, manteniendo el orden de sus elementos. Para ello, se invoca la ***función merge (1.1)***, encargada de realizar la mezcla.
    - Con esto finaliza la llamada recursiva actual, devolviendo a la llamada anterior el resultado parcial obtenido, donde los elementos <code>[3, 9, 6]</code> ya han sido ordenados: [<code>3, 6, 9</code>, 1, 2].

***1. Estado inicial ya actualizado: <code>[3, 6, 9, 1, 2]</code>***
 - La llamada recursiva con los elementos de la izquierda (<code>[3, 9, 6]</code>) devuelve el subconjunto ordenado: <code>[3, 6, 9]</code>
- Se realiza la llamada recursiva con los elementos de la derecha: <code>[1, 2]</code>

    ***1.2. Subconjunto con el que se va a trabajar: [3, 6, 9, <code>1, 2</code>]***
    - <code>inicio = 3</code>, <code>fin = 4</code>, <code>medio = (3+4)/2 = 3</code>
    - Se realiza la llamada recursiva con los elementos de la izquierda:  <code>[1]</code>

        ***1.2.1. Subconjunto con el que se va a trabajar: [3, 6, 9, <code>1</code>, 2]***
        - <code>inicio = 3</code>, <code>fin = 3</code>
        - Cuando <code>inicio == fin</code> ya no es posible fragmentar más el array. Este es el caso base de la recursión, por lo que se retorna a la llamada recursiva anterior.

    ***1.2. Subconjunto con el que se va a trabajar: [3, 6, 9, <code>1, 2</code>]***
    - La llamada recursiva con los elementos de la izquierda (<code>[1]</code>) devuelve el subconjunto ordenado.
    - Se realiza la llamada recursiva con los elementos de la derecha: <code>[2]</code>
        
        ***1.2.2. Subconjunto con el que se va a trabajar: [3, 6, 9, 1, <code>2</code>]***
        - <code>inicio = 4</code>, <code>fin = 4</code>
        - Cuando <code>inicio == fin</code> ya no es posible fragmentar más el array. Este es el caso base de la recursión, por lo que se retorna a la llamada recursiva anterior.
    
    ***1.2. Subconjunto con el que se va a trabajar: [3, 6, 9, <code>1, 2</code>]***
    - La llamada recursiva con los elementos de la derecha (<code>[2]</code>) devuelve el subconjunto ordenado.
    - Las llamadas recursivas han finalizado tanto para el subconjunto izquierdo (<code>[1]</code>) como para el derecho (<code>[2]</code>), obteniendo así dos arrays ya ordenados. 
    - Ambos arrays deben combinarse en uno solo, manteniendo el orden de sus elementos. Para ello, se invoca la ***función merge (1.2)***, encargada de realizar la mezcla.
    - Con esto finaliza la llamada recursiva actual, devolviendo a la llamada anterior el resultado parcial obtenido, donde los elementos <code>[1, 2]</code> ya han sido ordenados: [3, 6, 9, <code>1, 2</code>].
    
***1. Estado inicial ya actualizado: <code>[3, 6, 9, 1, 2 ]</code>***
- La llamada recursiva con los elementos de la derecha (<code>[1, 2]</code>) devuelve el subconjunto ordenado.
- Las llamadas recursivas han finalizado tanto para el subconjunto izquierdo (<code>[3, 6, 9]</code>) como para el derecho (<code>[1, 2]</code>), obteniendo así dos arrays ya ordenados. 
- Ambos arrays deben combinarse en uno solo, manteniendo el orden de sus elementos. Para ello, se invoca la ***función merge (1)***, encargada de realizar la mezcla. 
- Con esto finaliza la llamada recursiva actual, devolviendo a la llamada anterior. Dado que en este caso se trata de la llamana inicial (no existe llamada padre), se obtiene finalmente el array completamente ordenado: <code>[ 1, 2, 3, 6, 9]</code>

-----------------------------------------------------------------------

***Llamada a merge (1.1.1.)***
- Deben unirse <code>[3]</code> y  <code>[9]</code>
- <code>inicio_parte_izquierda = 0</code>, <code>inicio_parte_derecha = 1</code>, <code>fin_parte_izquierda = 0</code>, <code>fin_parte_derecha = 1</code>
- <code>i = inicio_parte_izquierda = 0</code>, <code>j = inicio_parte_derecha = 1</code>
- Se compara el elemento en  <code>i</code> con elemento en <code>j</code>
    - <code>(3)</code> es menor que <code>(9)</code>, por lo que se guarda en una estructura auxiliar <code>(3)</code>. <code>i++</code>
- <code>i</code> es mayor que <code>fin_parte_izquierda</code>, lo que indica que todos los elementos del subconjunto izquierdo ya se han añadido. Ahora queda comprobar si todavía hay elementos pendientes en el subconjunto derecho.
- <code>j</code> es igual que <code>fin_parte_derecha</code> por lo que aún queda un elemento por añadir.
    - Se guarda en la estructura auxiliar <code>(9)</code>
- <code>j</code> es mayor que <code>fin_parte_derecha</code>, ya se han guardado de forma ordenada todos los elementos de ambos subconjuntos.




***Llamada a merge (1.1.)***
-  Deben unirse <code>[3,9]</code> y  <code>[6]</code>
- <code>inicio_parte_izquierda = 0</code>, <code>inicio_parte_derecha = 1</code>, <code>fin_parte_izquierda = 0</code>, <code>fin_parte_derecha = 1</code>
- <code>i = inicio_parte_izquierda = 0</code>, <code>j = inicio_parte_derecha = 1</code>

    - Se compara el elemento en  <code>i</code> con elemento en <code>j</code>
        - <code>(3)</code> es menor que <code>(6)</code>, por lo que se guarda en una estructura auxiliar <code>(3)</code>. <code>i++</code>
    - Se compara el elemento en  <code>i</code> con elemento en <code>j</code>
        - <code>(9)</code> es mayor que <code>(6)</code>, por lo que se guarda en la estructura auxiliar <code>(6)</code> . <code>j++</code>
    - <code>j</code> es mayor que <code>fin_parte_derecha</code>, lo que indica que todos los elementos del subconjunto izquierdo ya se han añadido. Ahora queda comprobar si todavía hay elementos pendientes en el subconjunto izquierdo.
    - <code>i</code> es igual que <code>fin_parte_izquierda</code> por lo que aún queda un elemento por añadir.
        - Se guarda en la estructura auxiliar <code>(9)</code>
    - <code>i</code> es mayor que <code>fin_parte_izquierda</code>, ya se han guardado de forma ordenada todos los elementos de ambos subconjuntos.

    ***Llamada a merge (1.2.)***
    - Deben unirse <code>[1]</code> y  <code>[2]</code>
    - <code>inicio_parte_izquierda = 3</code>, <code>inicio_parte_derecha = 4</code>, <code>fin_parte_izquierda = 3</code>, <code>fin_parte_derecha = 4</code>
    - <code>i = inicio_parte_izquierda = 3</code>, <code>j = inicio_parte_derecha = 4</code>
    - Se compara el elemento en  <code>i</code> con elemento en <code>j</code>
        - <code>(1)</code> es menor que <code>(2)</code>, por lo que se guarda en una estructura auxiliar <code>(3)</code>. <code>i++</code>
    - <code>i</code> es mayor que <code>fin_parte_izquierda</code>, lo que indica que todos los elementos del subconjunto izquierdo ya se han añadido. Ahora queda comprobar si todavía hay elementos pendientes en el subconjunto derecho.
    - <code>j</code> es igual que <code>fin_parte_derecha</code> por lo que aún queda un elemento por añadir.
        - Se guarda en la estructura auxiliar <code>(2)</code>
    - <code>j</code> es mayor que <code>fin_parte_derecha</code>, ya se han guardado de forma ordenada todos los elementos de ambos subconjuntos.

    ***Llamada a merge (1.)***
    -  Deben unirse <code>[3, 6, 9]</code> y  <code>[1, 2]</code>
    - <code>inicio_parte_izquierda = 0</code>, <code>inicio_parte_derecha = 3</code>, <code>fin_parte_izquierda = 2</code>, <code>fin_parte_derecha = 4</code>
    - <code>i = inicio_parte_izquierda = 0</code>
    - <code>j = inicio_parte_derecha = 3</code>
    - Se compara el elemento en  <code>i</code> con elemento en <code>j</code>
        - <code>(3)</code> es mayor que <code>(1)</code>, por lo que se guarda en una estructura auxiliar <code>(1)</code>. <code>j++</code>
    - Se compara el elemento en  <code>i</code> con elemento en <code>j</code>
        - <code>(3)</code> es mayor que <code>(2)</code>, por lo que se guarda en la estructura auxiliar <code>(2)</code>. <code>j++</code>
    - <code>j</code> es mayor que <code>fin_parte_derecha</code>, lo que indica que todos los elementos del subconjunto izquierdo ya se han añadido. Ahora queda comprobar si todavía hay elementos pendientes en el subconjunto izquierdo.
    - <code>i</code> es menor que <code>fin_parte_izquierda</code> por lo que aún quedan elementos por añadir.
        - Se guarda en la estructura auxiliar <code>(3)</code>
    - <code>i</code> es menor que <code>fin_parte_izquierda</code> por lo que aún quedan elementos por añadir.
        - Se guarda en la estructura auxiliar <code>(6)</code>
    - <code>i</code> es igual que <code>fin_parte_izquierda</code> por lo que aún queda un elemento por añadir.
        - Se guarda en la estructura auxiliar <code>(9)</code>
    - <code>i</code> es mayor que <code>fin_parte_izquierda</code>, ya se han guardado de forma ordenada todos los elementos de ambos subconjuntos.


---
##  2. Algoritmo: QuickSort

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

***1. Estado inicial: <code>[3, 9, 6, 1, 2]</code>***
- <code>inicio = 0</code>, <code>fin = 4</code>, <code></code>
- Debe seleccionarse un pivote y crear dos subarrays. El de la izquierda contendrá los valores menores al pivote y el de la derecha los valores mayores a este. ***Llamamos a la función lomuto (1.)***
    - Resultado: <code>[1, 2, 6, 3, 9]</code>
- Se realiza la llamada recursiva con los elementos de la izquierda del pivote: <code>[1]</code>

    ***1.1. Subconjunto con el que se va a trabajar: [<code>1</code>, 2, 6, 3, 9 ]***
    - <code>inicio = 0</code>, <code>fin = 0</code>
    - Cuando <code>inicio == fin</code> el subarray contiene un solo elemento, por lo que no hay nada que comparar con el pivote. Se retorna entonces a la llamada recursiva anterior.

***1. Estado inicial ya actualizado:  <code>[1, 2, 6, 3, 9]</code>***
- La llamada recursiva sobre el subconjunto izquierdo (<code>[1]</code>) retorna los elementos ya ordenados.
- Se realiza la llamada recursiva con los elementos de la derecha: <code>[ 6, 3, 9 ]</code>

    ***1.2. Subconjunto con el que se va a trabajar: [ 1, 2, <code>6, 3, 9</code> ]***
    - <code>inicio = 2</code>, <code>fin = 4</code>
    - Debe seleccionarse un pivote y crear dos subarrays. El de la izquierda contendrá los valores menores al pivote y el de la derecha los valores mayores a este ***Llamamos a la función lomuto (1.2.)***
        - Resultado: <code>[1, 2, 6, 3, 9]</code>
    - Se realiza la llamada recursiva con los elementos de la izquierda del pivote: <code>[6, 3]</code>

        ***1.2.1. Subconjunto con el que se va a trabajar: [ 1, 2, <code>6, 3</code>, 9 ]***
        - <code>inicio = 2</code>, <code>fin = 3</code>
        - Debe seleccionarse un pivote y crear dos subarrays. El de la izquierda contendrá los valores menores al pivote y el de la derecha los valores mayores a este. ***Llamamos a la función lomuto (1.2.1.)***
            - Resultado: <code>[1, 2, 3, 6, 9]</code>
        - Se realiza la llamada recursiva con los elementos de la izquierda del pivote: <code>[]</code>

            ***1.2.1.1. Subconjunto con el que se va a trabajar: [ 1, 2, 3, 6, 9 ]***
            - <code>inicio = 2</code>, <code>fin = 1</code>
            - Cuando <code>inicio > fin</code> se está trabajando con un subarray vacío. Al no haber elementos que comparar, se retorna inmediatamente a la llamada recursiva anterior.

         ***1.2.1. Subconjunto con el que se va a trabajar (actualizado): [ 1, 2, <code>3, 6</code>, 9 ]***
        - - La llamada recursiva sobre el subconjunto izquierdo (<code>[]</code>) retorna los elementos ya ordenados.
        - Se realiza la llamada recursiva con los elementos de la derecha: <code>[ 6 ]</code>

            ***1.2.1.2. Subconjunto con el que se va a trabajar: [ 1, 2, 3, <code>6</code>, 9 ]***
            - <code>inicio = 3</code>, <code>fin = 3</code>
            - Cuando <code>inicio == fin</code> el subarray contiene un solo elemento, por lo que no hay nada que comparar con el pivote. Se retorna entonces a la llamada recursiva anterior.

         ***1.2.1. Subconjunto con el que se va a trabajar (actualizado): [ 1, 2, <code>3, 6</code>, 9 ]***
        - - La llamada recursiva sobre el subconjunto derecho (<code>[]</code>) retorna los elementos ya ordenados.
        - Ya no existen más valores que comparar u ordenar por lo que se vuelve a la llamada recurisva anterior.

    ***1.2. Subconjunto con el que se va a trabajar (actualizado): [ 1, 2, <code>3, 6, 9</code> ]***
    - - La llamada recursiva sobre el subconjunto izquierdo (<code>[3, 6]</code>) retorna los elementos ya ordenados.
    - Se realiza la llamada recursiva con los elementos de la derecha: <code>[]</code>

        ***1.2.2. Subconjunto con el que se va a trabajar (actualizado): [ 1, 2, 3, 6, 9 ]***
                - <code>inicio = 5</code>, <code>fin = 4</code>
                - Cuando <code>inicio > fin</code> se está trabajando con un subarray vacío. Al no haber elementos que comparar, se retorna inmediatamente a la llamada recursiva anterior.

    ***1.2. Subconjunto con el que se va a trabajar (actualizado): [ 1, 2, <code>3, 6, 9</code> ]***
    - - La llamada recursiva sobre el subconjunto derecha (<code>[]</code>) retorna los elementos ya ordenados.
    - Ya no existen más valores que comparar u ordenar por lo que se vuelve a la llamada recurisva anterior.

***1. Estado inicial (actualizado):  <code>[1, 2, 3, 6, 9]</code>***
- - La llamada recursiva sobre el subconjunto derecho (<code>[3, 6, 9]</code>) retorna los elementos ya ordenados.
- Con la finalización de esta llamada recursiva, se retorna el resultado a la llamada anterior. Dado que en este caso se trata de la llamada inicial (no existe una llamada padre), se obtiene finalmente el array completamente ordenado: <code>[ 1, 2, 3, 6, 9 ]</code>

-----------------------------------------------------------------------

***Llamada a lomuto (1.)***
- Deben ordenarse <code>[3, 9, 6, 1, 2]</code>
- <code>inicio = 0</code>, <code>final = 4</code>
- Se selecciona el último elemento como pivote.
    - <code>pivote = 2</code>
- <code>i = inicio -1 = -1</code>, <code>j = inicio</code>
- Se compara el elemento en  <code>j</code> con el <code>pivote</code>
    - <code>(3)</code> es mayor que <code>(2)</code>
- Se compara el elemento en  <code>j</code> con el <code>pivote</code>
    - <code>(9)</code> es mayor que <code>(2)</code>
- Se compara el elemento en  <code>j</code> con el <code>pivote</code>
    - <code>(6)</code> es mayor que <code>(2)</code>
- Se compara el elemento en  <code>j</code> con el <code>pivote</code>
    - <code>(1)</code> es menor que <code>(2)</code> --> <code>i++</code> 
    - Se intercambian los valores almanenados en <code>i</code> y <code>j</code>
        - Resultado del intercambio: <code>[1, 9, 6, 3, 2]</code>
- Se han comparado todos los elementos con el pivote, por lo que se coloca este en la posición correcta (siguiente posición al ultimo elemento menor encontrado, en este caso en la posición 1).
    - Resultado del intercambio:  <code>[1, 2, 6, 3, 9]</code>

***Llamada a lomuto (1.2.)***
- Deben ordenarse <code>[ 6, 3, 9 ]</code>
- <code>inicio = 2</code>, <code>final = 4</code>
- Se selecciona el último elemento como pivote.
    - <code>pivote = 9</code>
- <code>i = inicio -1 = 1</code>, <code>j = inicio</code>
- Se compara el elemento en  <code>j</code> con el <code>pivote</code>
    - <code>(6)</code> es menor que <code>(9)</code> --> <code>i++</code> 
    - Se intercambian los valores almanenados en <code>i</code> y <code>j</code>
        - Resultado del intercambio: <code>[ 6, 3, 9 ]</code>
- Se compara el elemento en  <code>j</code> con el <code>pivote</code>
    - <code>(3)</code> es menor que <code>(9)</code> --> <code>i++</code> 
    - Se intercambian los valores almanenados en <code>i</code> y <code>j</code>
        - Resultado del intercambio: <code>[ 6, 3, 9 ]</code>
- Se han comparado todos los elementos con el pivote, por lo que se coloca este en la posición correcta (siguiente posición al ultimo elemento menor encontrado, en este caso en la posición 4).
    - Resultado del intercambio:  <code>[1, 2, 6, 3, 9]</code>


***Llamada a lomuto (1.2.1)***
- Deben ordenarse <code>[ 6, 3 ]</code>
- <code>inicio = 2</code>, <code>final = 3</code>
- Se selecciona el último elemento como pivote.
    - <code>pivote = 3</code>
- <code>i = inicio -1 = 1</code>, <code>j = inicio</code>
- Se compara el elemento en  <code>j</code> con el <code>pivote</code>
    - <code>(6)</code> es mayor que <code>(3)</code>
- Se han comparado todos los elementos con el pivote, por lo que se coloca este en la posición correcta (siguiente posición al ultimo elemento menor encontrado, en este caso en la posición 2).
    - Resultado del intercambio:  <code>[1, 2, 3, 6, 9]</code>
