import entidades.Alumno;
import entidades.Empleado;
import entidades.Libro;
import entidades.Producto;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//--------------------Ejercicio 1: Classe Alumno----------------------------------//
        System.out.println("--- Ejercicio 1 ---");

        List<Alumno> alumnos = List.of(
                Alumno.builder()
                        .nombre("Franco Dagostino")
                        .nota(8)
                        .curso("A")
                        .build(),

                Alumno.builder()
                        .nombre("Vicente Ibarzabal")
                        .nota(6)
                        .curso("A")
                        .build(),

                Alumno.builder()
                        .nombre("Rosario Gimenez")
                        .nota(5)
                        .curso("B")
                        .build(),

                Alumno.builder()
                        .nombre("Renzo Kam")
                        .nota(9)
                        .curso("B")
                        .build()
        );


        // 1. Obtener los nombres de los alumnos aprobados (nota ≥ 7) en mayúsculas y ordenados.

        List<String> nombresAprobados =
                alumnos.stream()
                .filter(alumno -> alumno.getNota() >= 7)
                .map(alumno -> alumno.getNombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Alumnos aprobados (ordenados y en mayúsculas):");
        nombresAprobados.forEach(System.out::println);

        // 2.Calcular el promedio general de notas.

        double promedioGeneral =  alumnos.stream()
        .collect(Collectors.averagingInt(Alumno::getNota));

        System.out.println("El promedio general es: " + promedioGeneral);

        //3. Agrupar alumnos por curso usando Collectors.groupingBy().

        Map<String,List<Alumno>> agrupadosPorCurso =
                alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));

        System.out.println("Alumnos agrupados por curso:");
        agrupadosPorCurso.forEach((curso, listaDeAlumnos) -> {
            System.out.println("Curso: " + curso);
            listaDeAlumnos.forEach(alumno -> System.out.println("  * " + alumno.getNombre()));
        });

        // 4. Obtener los 3 mejores promedios.

        Comparator<Alumno> porNotaDescendente =  Comparator
                .comparingInt(Alumno::getNota)
                .reversed();

        List<Alumno> mejores3Alumnos =
                alumnos.stream()
                        .sorted(porNotaDescendente)
                        .limit(3)
                .collect(Collectors.toList());

        System.out.println("Los 3 alumnos con mejores notas:");
        mejores3Alumnos.forEach(alumno ->
                System.out.println(" -> " + alumno.getNombre() + " (Nota: " + alumno.getNota() + ")")
        );

//--------------------Ejercicio 2: Classe Producto----------------------------------//
        System.out.println("--- Ejercicio 2 ---");

        List<Producto> productos = List.of(

          Producto.builder()
                  .nombre("Shampoo Triatop")
                  .categoria("Baño")
                  .precio(50.00)
                  .stock(30)
                  .build(),

          Producto.builder()
                  .nombre("Enjuague Elvive")
                  .categoria("Baño")
                  .precio(50.00)
                  .stock(40)
                  .build(),

          Producto.builder()
                  .nombre("Auriculares Redragon")
                  .categoria("Tecnologia")
                  .precio(110.00)
                  .stock(10)
                  .build(),


          Producto.builder()
                  .nombre("Mouse Logitech")
                  .categoria("Tecnologia")
                  .precio(130.00)
                  .stock(20)
                  .build(),

          Producto.builder()
                  .nombre("Plato Hondo")
                  .categoria("Hogar")
                  .precio(80.00)
                  .stock(30)
                  .build(),

          Producto.builder()
                  .nombre("Microondas")
                  .categoria("Hogar")
                  .precio(105.00)
                  .stock(5)
                  .build()

        );

        //1. Listar los productos con precio mayor a 100, ordenados por precio descendente
        Comparator<Producto> porPrecioDesc = Comparator
                .comparingDouble(Producto::getPrecio)
                .reversed();

        List<Producto> productosCaros =
                productos.stream()
                        .filter(producto -> producto.getPrecio() > 100)
                        .sorted(porPrecioDesc)
                        .collect(Collectors.toList());

        System.out.println("Productos con precio > 100 (ordenados por precio desc):");
        productosCaros.forEach(p ->
                System.out.println(" -> " + p.getNombre() + " ($" + p.getPrecio() + ")")
        );

        //2. Agrupar productos por categoría y calcular el stock total.
        Map<String, Integer> stockPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.summingInt(Producto::getStock)
                ));

        System.out.println("Stock total por categoría:");
        stockPorCategoria.forEach((categoria, stock) ->
                System.out.println(" -> " + categoria + ": " + stock + " unidades")
        );

        //3. Generar un String con "nombre (precio)" separado por ";".
        String productosString = productos.stream()
                .map(p -> p.getNombre() + " ($" + p.getPrecio() + ")")
                .collect(Collectors.joining("; "));

        System.out.println(productosString);

        //4. Calcular el precio promedio general y por categoría.
        double promedioGeneralProd = productos.stream()
                .collect(Collectors.averagingDouble(Producto::getPrecio));
        System.out.println("Precio promedio general: $" + promedioGeneralProd);

        Map<String, Double> promedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria, // Agrupa por categoría
                        Collectors.averagingDouble(Producto::getPrecio) // Promedia el precio de cada grupo
                ));

        System.out.println("Precio promedio por categoría:");
        promedioPorCategoria.forEach((categoria, promedio) ->
                System.out.println(" -> " + categoria + ": $" + String.format("%.2f", promedio))
        );

//--------------------Ejercicio 3: Classe Libro----------------------------------//
        System.out.println("--- Ejercicio 2 ---");

        List<Libro> libros = List.of(
                Libro.builder()
                        .titulo("El Aleph")
                        .autor("Borges")
                        .paginas(150)
                        .precio(100.0)
                        .build(),

                Libro.builder()
                        .titulo("Cien Años de Soledad")
                        .autor("Garcia Marquez")
                        .paginas(450)
                        .precio(150.0)
                        .build(),

                Libro.builder()
                        .titulo("Ficciones")
                        .autor("Borges")
                        .paginas(200)
                        .precio(110.0)
                        .build(),

                Libro.builder()
                        .titulo("Rayuela")
                        .autor("Cortazar")
                        .paginas(550)
                        .precio(180.0)
                        .build(),

                Libro.builder()
                        .titulo("El Amor en Tiempos de Cólera")
                        .autor("Garcia Marquez")
                        .paginas(350)
                        .precio(140.0)
                        .build()
        );

        //1. Listar los títulos de los libros con más de 300 páginas, ordenados alfabéticamente.
        List<String> titulosLargos = libros.stream()
                .filter(libro -> libro.getPaginas() > 300)
                .map(Libro::getTitulo)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Libros con más de 300 páginas:");
        titulosLargos.forEach(titulo -> System.out.println(" -> " + titulo));

        //2.Calcular el promedio de páginas de todos los libros.
        double promedioPaginas = libros.stream()
                .collect(Collectors.averagingInt(Libro::getPaginas));

        System.out.println("Promedio de páginas general: " + promedioPaginas);

        //3.Agrupar los libros por autor y contar cuántos libros tiene cada uno.
        Map<String, Long> librosPorAutor = libros.stream()
                .collect(Collectors.groupingBy(
                        Libro::getAutor,
                        Collectors.counting() // Colector "hijo" que cuenta los elementos del grupo
                ));

        System.out.println("Cantidad de libros por autor:");
        librosPorAutor.forEach((autor, cantidad) ->
                System.out.println(" -> " + autor + ": " + cantidad + " libro(s)")
        );

        //4.Obtener el libro más caro de la lista.
        Optional<Libro> libroMasCaro = libros.stream()
                .max(Comparator.comparingDouble(Libro::getPrecio));

        if (libroMasCaro.isPresent()) {
            Libro libro = libroMasCaro.get();
            System.out.println("El libro más caro es: " + libro.getTitulo() + " ($" + libro.getPrecio() + ")");
        } else {
            System.out.println("No hay libros en la lista.");
        }

 //--------------------Ejercicio 4: Classe Empleado----------------------------------//
        System.out.println("--- Ejercicio 4 (Empleado) ---");

        List<Empleado> empleados = List.of(
                Empleado.builder()
                        .nombre("Ana")
                        .departamento("Ventas")
                        .salario(2500.0)
                        .edad(30)
                        .build(),

                Empleado.builder()
                        .nombre("Luis")
                        .departamento("IT")
                        .salario(3500.0)
                        .edad(25)
                        .build(),

                Empleado.builder()
                        .nombre("Carla")
                        .departamento("Ventas")
                        .salario(1800.0)
                        .edad(42)
                        .build(),

                Empleado.builder()
                        .nombre("Pedro")
                        .departamento("RRHH")
                        .salario(2200.0)
                        .edad(28)
                        .build(),

                Empleado.builder()
                        .nombre("Maria")
                        .departamento("IT")
                        .salario(3200.0)
                        .edad(35)
                        .build()
        );


                //1. Obtener la lista de empleados cuyo salario sea mayor a 2000, ordenados por salario descendente.
                System.out.println("\n--- Ejercicio 4.1 ---");
        List<Empleado> empleadosSalarioAlto = empleados.stream()
                .filter(e -> e.getSalario() > 2000)
                .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
                .collect(Collectors.toList());

        System.out.println("Empleados con salario > 2000 (ordenados desc):");
        empleadosSalarioAlto.forEach(e ->
                System.out.println(" -> " + e.getNombre() + " ($" + e.getSalario() + ")")
        );

        // 2.Calcular el salario promedio general.
        System.out.println("\n--- Ejercicio 4.2 ---");
        double salarioPromedio = empleados.stream()
                .collect(Collectors.averagingDouble(Empleado::getSalario));

        System.out.println("Salario promedio general: $" + String.format("%.2f", salarioPromedio));


        //3. Agrupar los empleados por departamento y calcular la suma de salarios de cada uno.
        System.out.println("\n--- Ejercicio 4.3 ---");
        Map<String, Double> sumaSalariosPorDepto = empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::getDepartamento,
                        Collectors.summingDouble(Empleado::getSalario)
                ));

        System.out.println("Suma de salarios por departamento:");
        sumaSalariosPorDepto.forEach((depto, suma) ->
                System.out.println(" -> " + depto + ": $" + suma)
        );

        // 4. Obtener los nombres de los 2 empleados más jóvenes.
        System.out.println("\n--- Ejercicio 4.4 ---");
        List<String> empleadosMasJovenes = empleados.stream()
                .sorted(Comparator.comparingInt(Empleado::getEdad))
                .limit(2)
                .map(Empleado::getNombre)
                .collect(Collectors.toList());

        System.out.println("Los 2 empleados más jóvenes:");
        empleadosMasJovenes.forEach(nombre -> System.out.println(" -> " + nombre));
        

    }
}