import java.io.BufferedReader;  //paquete que nos permite leer los archivos linea por linea
import java.io.FileReader;      //paquete que lee archivos en forma de texto
import java.io.IOException;     //en vez de terminar el programa si hay un fallo, continúa con mensajes de error sin terminar el programa de forma abrupta
import java.util.HashMap;       //almacena en pares la clave-valor, que en este caso usaremos como código postal - asentamiento
import java.util.Map;           //define como funciona el mapa

public class CP {
    public static void main(String[] args) {
        String archivo = "C:/Users/alexp/Downloads/codigos_postales_hmo.csv";  //archivo extraido de la asignación en teams, se guarda como variable string para poder ser procesado
        Map<String, Integer> contadorAsentamientos = new HashMap<>();           //Utilizamos el hashmap para guardar el codigo postal y asentamiento, siendo uno String y otro int
        String linea;   //declaramos el String que guarda cada linea que procesemos
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {  //Try para poder usar las excepciones y cierra el archivo cuando el programa termine, FileReader para abrir el archivo en modo lectura y BufferedReader para maximizar al FileReader
            while ((linea = br.readLine()) != null) {  //con BufferedReader podemos usar readline, y lo metemos en un bucle While, con el !=null queremos decir que se acaba hasta cuando no encuentre lineas
                String[] columnas = linea.split(",");  //Para procesar cada linea de datos se usa el split para separarlas
                String codigoPostal = columnas[0].trim();    //Recortamos los espacios de la columna donde se encuentran los codigos postales, la cual es la columna 0
                contadorAsentamientos.put(codigoPostal, contadorAsentamientos.getOrDefault(codigoPostal, 0) + 1);
            }
        } catch (IOException e) {
            System.err.println("Error al momento de abrir el archivo: " + e.getMessage());   //Al momento de ocurrir algun problema al abrir el archivo, se reportará en la consola
        }
        for (Map.Entry<String, Integer> entry : contadorAsentamientos.entrySet()) {  //En el mapa se devuelven todos los clave - valor
            System.out.println("Codigo postal: " +entry.getKey() + " - Numero de asentamientos: " + entry.getValue()); //imprime los valores que teniamos como postal y asentamientos en forma de lista
        }
    }       //OBSERVACIONES: No sabía cómo utilizar el lector de archivos, y menos cómo imprimirlos linea por linea bajo una condición, por lo que consulté videos en youtube, y a mis compañeros de curso.
            //               El tiempo empleado se puede contemplar el aproximadamente 2 horas si unicamente contamos que el tiempo que el proyecto estuvo abierto.
            //               La parte más complicada y siento que es lo más importante fue utilizar las librerías de HashMap, Map y BufferedReader, puesto a que solo había utilizado FileReader anteriormente, es una experiencia nueva.
            //               Hay aspectos a mejorar como lo es la presentación y eficacia del código, por lo que desconozco alguna otra manera de acomodar la información o hacer más sencilla la estructura.
            //               Github es la parte que dejé al final para subir una solo versión
}
