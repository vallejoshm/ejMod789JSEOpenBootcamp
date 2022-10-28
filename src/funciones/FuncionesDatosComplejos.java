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
        }catch (FileNotFoundException e){
            System.out.println("Esto no funciona, " + e.getMessage());
        } catch (IOException e) {
            System.out.println("No funciona, " + e.getMessage());
        }
    }

    public static void cargarPedido(PrintStream out) throws IOException {
        String continuar;
        boolean seguir = true;
        do {
            System.out.println("Ingrese el nombre de la herramienta solicitada: ");
            Scanner producto = new Scanner(System.in);
            String entradaProd = producto.nextLine();
            System.out.println("Ingrese la cantidad deseada: ");
            Scanner cantidad = new Scanner(System.in);
            String entradaCant = cantidad.nextLine();
            try {
                Integer.parseInt(entradaCant);
            }catch (Exception e){
                System.out.println("Reingrese la cantidad en formato numérico");
                continuar = "y";
                continue;
            }
            String salto = "\n";
            try {
                out.write(entradaProd.getBytes());
                out.write(salto.getBytes());
                out.write(entradaCant.getBytes());
                out.write(salto.getBytes());
                do {
                    System.out.println("¿Desea ingresar un nuevo producto?:(Y/N)");
                    Scanner next = new Scanner(System.in);
                    continuar = next.nextLine();
                    seguir = !continuar.equalsIgnoreCase("y") && !continuar.equalsIgnoreCase("n");
                } while (seguir);
            } catch (IOException e) {
                throw new IOException();
            }
        } while (continuar.equalsIgnoreCase("y"));
    }

    public static HashMap<String, Integer> crearMap(InputStream in) throws IOException {

        HashMap<String, Integer> map = new HashMap<>();
        try {
            String clave = null;
            Integer valor = null;
            int finPedido = 0;

            do {
                ArrayList<Integer> listaDatos = new ArrayList<>();
                int dato = in.read();
                finPedido = dato;

                while (dato != -1 && (char) dato != '\n') {
                    listaDatos.add(dato);
                    dato = in.read();
                }

                if (clave != null && listaDatos.size() > 0)
                    valor = Integer.parseInt(construirClaveValor(listaDatos).toString());
                else
                    clave = construirClaveValor(listaDatos).toString();

                if(clave.length() !=0 && valor != null) {
                    map.put(clave, valor);
                    clave = null;
                    valor = null;
                }
            } while (finPedido != -1);

        } catch (IOException e) {
            throw new IOException();
        }
        return map;
    }

    private static StringBuilder construirClaveValor(ArrayList<Integer> lista) {

        StringBuilder valorString = new StringBuilder();
        for (int elem : lista) {
            valorString.append((char) elem);
        }
        return valorString;
    }
}

