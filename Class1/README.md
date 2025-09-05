# Búsquedas en Java

Este proyecto contiene ejemplos prácticos de **tres tipos de algoritmos de búsqueda**:
- **Búsqueda Lineal**
- **Búsqueda Binaria**
- **Búsqueda con Hashing**

El objetivo es que los estudiantes comprendan cómo funcionan, cuándo utilizarlos y cuáles son sus ventajas y limitaciones.

---

## Contenido
El programa principal se encuentra en la clase `Class1`.  
Mediante un menú, el usuario puede ejecutar distintos ejemplos de búsqueda:

- **Opción 1 → Búsqueda lineal**
- **Opción 2 → Búsqueda binaria**
- **Opción 3 → Búsqueda en tabla hash**
- **Opción -1 → Salir**

---

## 1. Búsqueda Lineal
### Idea principal
Recorre el array **elemento por elemento** hasta encontrar el valor buscado.  
Si se encuentra, devuelve la posición. Si no, devuelve -1.

## 2. Búsqueda Binaria
### Idea principal

Funciona en arrays ordenados.
Se compara el elemento buscado con el valor en la mitad del array:

Si es igual → encontrado.

Si es menor → se busca en la mitad izquierda.

Si es mayor → en la mitad derecha.

## 3. Búsqueda con Hashing
### Idea principal

Se usan tablas hash (HashMap en Java), donde cada elemento se asocia a una clave única.
La búsqueda es muy rápida porque no recorre toda la colección, sino que calcula directamente la posición del bucket.