# 🧮 Trabajo Práctico: Programación Funcional en Java

**Autor:** Franco D'Agostino

Este repositorio contiene las soluciones al **Trabajo Práctico de Programación Funcional* de la **Materia de Desarrollo de Software de la carrera Ingeniería en Sistemas (UTN)**.  
El objetivo principal es aplicar los conceptos de la **programación funcional en Java**, utilizando la **API de Streams** y **expresiones Lambda**.

---

## 🚀 Conceptos Aplicados

Este proyecto demuestra el uso de las siguientes características de **Java 8+**:

### 🔹 API de Streams (`.stream()`)
Procesamiento declarativo de colecciones.

### 🔹 Expresiones Lambda
Implementación concisa de interfaces funcionales (para `filter`, `map`, etc.).

### 🔹 Method References (`::`)
Referencias a métodos (ej. `Alumno::getNota`) para un código más limpio.

---

## 🧩 Operaciones Intermedias

- **`filter(Predicate)`**: Para seleccionar elementos (ej. notas >= 7, precio > 100).  
- **`map(Function)`**: Para transformar elementos (ej. `alumno.getNombre().toUpperCase()`).  
- **`sorted()`**: Para ordenamiento natural (alfabético).  
- **`sorted(Comparator)`**: Para ordenamiento personalizado (ej. por nota descendente).  
- **`limit(n)`**: Para restringir el número de resultados (ej. los 3 mejores).

---

## 🧮 Operaciones Terminales y Collectors

- **`collect(Collectors.toList())`**: Para agrupar resultados en una `List`.  
- **`collect(Collectors.averagingInt()` / `averagingDouble())`**: Para calcular promedios.  
- **`collect(Collectors.joining(delimiter))`**: Para unir `String`s.  
- **`reduce()`**: Para operaciones de acumulación personalizadas (como la suma de notas).  
- **`max(Comparator)`**: Para encontrar el elemento máximo (ej. el libro más caro).  
- **`collect(Collectors.groupingBy(...))`**: Para agrupar elementos en un `Map` (ej. por curso, categoría o departamento).  
- **`collect(Collectors.groupingBy(..., downstreamCollector))`**: Para realizar una segunda operación en los grupos:
  - `Collectors.counting()`: Contar elementos por grupo.  
  - `Collectors.summingInt()` / `summingDouble()`: Sumar valores por grupo.  
  - `Collectors.averagingDouble()`: Promediar valores por grupo.

---

## 🧱 Otras Clases Utilizadas

- **`Optional<T>`**: Para manejar de forma segura la posible ausencia de un valor (devuelto por `.max()`).  
- **`Comparator`**: Para definir lógicas de ordenamiento complejas.  
- **`Lombok`**: Para reducir el código *boilerplate* (getters, setters, builders) en las clases de entidad (`Alumno`, `Producto`, `Libro`, `Empleado`).

---

## 📂 Ejercicios Resueltos

El proyecto está dividido en cuatro casos prácticos, cada uno con su clase de entidad:

1. **Caso Práctico 1:** `Alumno`  
2. **Caso Práctico 2:** `Producto`  
3. **Caso Práctico 3:** `Libro`  
4. **Caso Práctico 4:** `Empleado`
