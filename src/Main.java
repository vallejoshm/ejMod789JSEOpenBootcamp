import java.io.*;
import java.util.*;

import static funciones.FuncionesDatosComplejos.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Escribe el código que devuelva una cadena al revés.
        // Por ejemplo, la cadena "hola mundo", debe retornar "odnum aloh".

        String cadena = "Hola mundo!";
        System.out.println(reverse(cadena));

        //Crea un array unidimensional de Strings y recórrelo, mostrando únicamente sus valores.

        String[] cadenas = {"Hola", "mundo", "!!!"};
        mostrarValoresArrayUni(cadenas);

        //Crea un array bidimensional de enteros
        // y recórrelo, mostrando la posición y el valor de cada elemento en ambas dimensiones.

        int[][] numeros = {{1, 2, 3}, {4, 5, 6}};
        mostrarValYPosArrayBid(numeros);

        //Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos.
        // Elimina el 2o y 3er elemento y muestra el resultado final.

        Vector<String> vectorString = new Vector<>();
        vectorString.add("Hola");
        vectorString.add("Mundo");
        vectorString.add("!!!");
        vectorString.add("Adios");
        vectorString.add("Mundo");

        Integer[] posAEliminar = {2, 3};

        eliminarPosiciones(posAEliminar, vectorString);

        //Indica cuál es el problema de utilizar un Vector
        // con la capacidad por defecto si tuviésemos 1000 elementos para ser añadidos al mismo.
        //El problema es que se harían muchas copias de vectores hasta llegar a la capacidad necesaria,
        //lo mejor es inicializar la capacidad con el valor que sabemos que vamos a necesitar para evitarlo
        // y de esta manera evitar el excesivo uso de la memoria

        //Crea un ArrayList de tipo String, con 4 elementos. Cópialo en una LinkedList.
        // Recorre ambos mostrando únicamente el valor de cada elemento.


        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("cadena1");
        arrayList.add("cadena2");
        arrayList.add("cadena3");
        arrayList.add("cadena4");

        LinkedList<Object> linkedList = copiarArrayToLinkedList(arrayList);
        mostrarArrayYLinkedList(arrayList, linkedList);


        //Crea un ArrayList de tipo int, y, utilizando un bucle
        // rellénalo con elementos 1..10. A continuación, con otro bucle, recórrelo
        // y elimina los numeros pares. Por último, vuelve a recorrerlo y muestra el ArrayList final.
        // Si te atreves, puedes hacerlo en menos pasos, siempre y cuando cumplas el primer "for" de relleno.

        ArrayList arrayListEnteros;
        arrayListEnteros = cargarArrayList(1, 10);
        System.out.println("Lista de número impares: " + eliminarPares(arrayListEnteros));


        //Crea una función DividePorCero. Esta, debe generar una excepción ("throws") a su llamante del tipo
        // ArithmeticException que será capturada por su llamante (desde "main", por ejemplo). Si se dispara
        // la excepción, mostraremos el mensaje "Esto no puede hacerse". Finalmente, mostraremos en cualquier caso:
        // "Demo de código".

        try {
            dividePorCero(6, 0);
        }catch (Exception e) {
            System.out.println("Esto no puede hacerse");
        }finally {
            System.out.println("Demo de código.");
        }

        //Utilizando InputStream(lee) y PrintStream(crea), crea una función que reciba dos parámetros: "fileIn" y "fileOut".
        // La tarea de la función será realizar la copia del fichero dado en el parámetro "fileIn" al fichero dado
        // en "fileOut".

        try{
            InputStream in = new FileInputStream("C:\\Users\\Hernan\\Desktop\\Python\\notas.txt");
            PrintStream out = new PrintStream("copia.txt");
            copiarFichero(in, out);
            in.close();
        }catch (FileNotFoundException e){
            System.out.println("Esto no funciona, " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Sorpréndenos creando un programa de tu elección que utilice InputStream, PrintStream, excepciones,
        // un HashMap y un ArrayList, LinkedList o array.

        //compra de herramientas manuales
        //crear una entrada de datos mediante un scanner para ingresar nombre de herramienta y cantidad a comprar
        //que ingrese esta info a un fichero nuevo y salga de la creacion de la lista cuando no quiera cargar mas datos
        //desp que lea el fichero y cree n hashmap y que clave sea el nombre de la herramienta y su valor la cant
        //y que se pueda ver la lista completa con posibilidad de modificarla o enviarla a una lista de proveedores

        try {
            PrintStream out = new PrintStream("PedidoHerramientas.txt");
            cargarPedido(out);
        }catch(IOException e) {
            System.out.println("Esto no funciona: " + e.getMessage());
        }
        try {
            InputStream in = new FileInputStream("PedidoHerramientas.txt");
            HashMap<String, Integer> map = crearMap(in);
            System.out.println("Mapa: " + map);
        }catch (FileNotFoundException e){
            System.out.println("Esto no funciona: " + e.getMessage());
        }



    }
}