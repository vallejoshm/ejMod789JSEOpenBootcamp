package funciones;

import java.io.*;
import java.util.*;

public class FuncionesDatosComplejos {

    public static String reverse(String texto) {

        StringBuilder textoInverso = new StringBuilder();
        for (int i = 0; i < texto.length(); i++){
            textoInverso.insert(0, texto.charAt(i));
        }
        return textoInverso.toString();
    }



    public static void mostrarValoresArrayUni(String[] cadenas){

        for (String cadena : cadenas){
            System.out.println(cadena);
        }
    }


    public static void mostrarValYPosArrayBid(int[][] numeros){

        for (int i = 0; i < numeros.length; i++){
            for (int j = 0; j < numeros[i].length; j++){
                System.out.println("Valor: " + numeros[i][j] + " || posición: (" +
                        i + ", " + j + ")");
            }
        }
    }

    public static void eliminarPosiciones(Integer[] posiciones, Vector vector){

        Arrays.sort(posiciones, Collections.reverseOrder());
        for (int index : posiciones) {
            vector.remove(index - 1);
        }
        /*for( int i = 0; i < posiciones.length; i++){
            int index = posiciones[i];
            vector.remove(index-1);
        }*/

        System.out.println(vector);

    }

    public static LinkedList copiarArrayToLinkedList(ArrayList arrayList){
        LinkedList<String> linkedList = new LinkedList<>();
        for (Object o : arrayList) {
            linkedList.add((String) o);
        }
        return linkedList;
    }

    public static void mostrarArrayYLinkedList(ArrayList arrayList, LinkedList linkedList){
        for(int i=0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
            System.out.println(linkedList.get(i));
        }
    }

    public static ArrayList cargarArrayList(int numInicio, int numFin){

        ArrayList<Integer> arrayListEnteros = new ArrayList<>();
        for ( int i = numInicio; i <=numFin; i++){
            arrayListEnteros.add(i);
        }

        return arrayListEnteros;
    }

    public static ArrayList eliminarPares(ArrayList<Integer> arrayList){
        ArrayList<Integer> nuevoArrayList = new ArrayList<Integer>();
        for (Integer num : arrayList){
            if (num % 2 != 0) nuevoArrayList.add(num);
        }

        return nuevoArrayList;
    }

    public static int dividePorCero(int a, int b) throws ArithmeticException {

        int resultado;
        try {
            resultado = a / b;
        }catch (ArithmeticException e){
            throw new ArithmeticException();
        }
        return resultado;
    }


    public static void copiarFichero(InputStream in, PrintStream out){

        try {
            int dato = in.read();

            while(dato != -1){
                out.write(dato);
                dato = in.read();
            }
            System.out.println(out);
        }catch (FileNotFoundException e){
            System.out.println("Esto no funciona, " + e.getMessage());
        } catch (IOException e) {
            System.out.println("No funciona, " + e.getMessage());
        }
    }

}

