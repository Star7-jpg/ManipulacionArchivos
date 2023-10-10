import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ManipulacionArchivo {
    
    public static int contarLineasArchivo(String name){
        File archivo; 
        FileReader reader; 
        BufferedReader bufer; 
        int numLineas = 0;
        try{
            archivo = new File("C:\\archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);

            //Contar las líneas que contiene el archivo
            while ((bufer.readLine()) != null) {
                numLineas++;
            }
            reader.close();
        }catch(Exception e){
            System.out.println("Error al leer el archivo: " + e.toString());
        }
        return numLineas;
    }    

    public static String[] stringToArrary (String name){
        File archivo;
        FileReader reader;
        BufferedReader bufer;
        String linea;
        String[] array = null;
        int t;
        int i = 0;

        try{
            t = contarLineasArchivo(name);
            array = new String[t];
            archivo = new File("C:\\archivos\\" + name + ".txt");       
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);
            while ((linea = bufer.readLine()) != null) {
                array[i] = linea;
                i++;
            }
            reader.close();
        }catch(Exception e){
            System.out.println("Error al leer el archivo: " + e.toString());
        }
        return array;
    }

    public static int[] fileToIntArray(String name){
        File archivo; 
        FileReader reader; 
        BufferedReader bufer; 
        String linea;
        int[] array = null;
        int t;
        int i = 0;

        try{
            t = contarLineasArchivo(name);
            array = new int[t];
            archivo = new File("C:\\archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);

            while ((linea = bufer.readLine()) != null) {
                array[i] = Integer.parseInt(linea);
                i++;
            }
            reader.close();
        }catch(Exception e){
            System.out.println("Error al leer el archivo: " + e.toString());
        }
        return array;
    }
    
    public static void writeFile(String name){
        //un apuntador a un espacio físico del dd
        FileWriter archivo;
        
        //La llave de acceso para escribir el archivo
        PrintWriter writer;

        //Para escribir del teclado al dd
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

        String entrada;
        char respuesta;

        try {
            //Apuntador al archivo que se va a crear
            archivo = new FileWriter("C:\\archivos\\" + name + ".txt");
            
            //Abrir el archivo en modo escritura
            writer = new PrintWriter(archivo);

            do{
                System.out.println("Escribe datos para guardar al archivo");
                entrada = bufer.readLine();

                //Guardar lo recuperado desde teclado al archivo
                writer.println(entrada);
                System.out.println("Escribe x para salir, cualquier otra tecla para continuar");
                entrada = bufer.readLine();
                respuesta = entrada.charAt(0);
            }while (respuesta != 'x');
            archivo.close();
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo: " + e.toString());
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        String[] textos;
        int[] numeros;

        System.out.println("Lectura de un archivo de texto: ");
        System.out.println("Escribe el nombre del archivo: ");
        fileName = bufer.readLine();
        textos = stringToArrary(fileName);
        System.out.println("Contenido del arreglo de textos: ");
        for(String unTexto : textos){
            System.out.println(unTexto);
        }

        System.out.println("Lectura de datos númericos: ");
        System.out.println("Escribe el nombre del archivo: ");
        fileName = bufer.readLine();
        numeros = fileToIntArray(fileName);
        System.out.println("Contenido del arreglo de números: ");
        for(int unNumero : numeros){
            System.out.println(unNumero);
        }

        System.out.println("Crear un archivo de texto: ");
        System.out.println("Escribe el nombre del archivo a crear: ");
        fileName = bufer.readLine();
        writeFile(fileName);
    }
}
