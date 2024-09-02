package program1;

import javax.swing.*;
import java.io.File;

/**
 * Clase principal que ejecuta el programa para leer datos de un archivo,
 * procesar estos datos en listas enlazadas, y calcular estadísticas.
 * Permite al usuario seleccionar el archivo CSV a través de una interfaz gráfica.
 */
public class Program1 {

    /**
     * Método principal que inicia la ejecución del programa.
     * Abre un cuadro de diálogo para que el usuario seleccione un archivo CSV,
     * y luego procesa los datos del archivo en listas enlazadas para calcular
     * y mostrar estadísticas como la media y la desviación estándar.
     * 
     * @param args Los argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        // Crear una instancia de JFileChooser para permitir al usuario seleccionar un archivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona el archivo CSV");

        // Mostrar el cuadro de diálogo y obtener la selección del usuario
        int userSelection = fileChooser.showOpenDialog(null);

        // Verificar si el usuario ha seleccionado un archivo
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            File file = fileChooser.getSelectedFile();
            System.out.println("Archivo seleccionado: " + file.getAbsolutePath());

            // Crear una instancia de TextFile con la ruta del archivo seleccionado
            TextFile textFile = new TextFile(file.getAbsolutePath());

            // Leer las columnas del archivo y almacenarlas en las listas enlazadas
            LinkedList list1 = textFile.readFile1();
            LinkedList list2 = textFile.readFile2();

            // Crear instancias de la clase Mean para calcular la media y desviación estándar
            Mean mean1 = new Mean(list1);
            Mean mean2 = new Mean(list2);

            // Imprimir resultados para la primera lista
            System.out.println("");
            System.out.println("");
            System.out.println("Lista 1:");
            System.out.println("");
            // Imprimir todos los elementos de la lista 1
            list1.printList();
            System.out.println("");
            // Calcular y mostrar la media de la lista 1
            System.out.println("Media de la Lista 1: " + mean1.obtainAverage());
            System.out.println("");
            // Calcular y mostrar la desviación estándar de la lista 1
            System.out.println("Desviación Estándar de la Lista 1: " + mean1.obtainStandardDeviation());
            System.out.println("");
            // Imprimir resultados para la segunda lista
            System.out.println("");
            System.out.println("");
            System.out.println("Lista 2:");
            System.out.println("");
            // Imprimir todos los elementos de la lista 2
            list2.printList();
            System.out.println("");
            // Calcular y mostrar la media de la lista 2
            System.out.println("Media de la Lista 2: " + mean2.obtainAverage());
            System.out.println("");
            // Calcular y mostrar la desviación estándar de la lista 2
            System.out.println("Desviación Estándar de la Lista 2: " + mean2.obtainStandardDeviation());
            System.out.println("");
        } else {
            // Mensaje cuando no se selecciona ningún archivo
            System.out.println("No se seleccionó ningún archivo.");
        }
    }
}
