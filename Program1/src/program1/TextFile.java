package program1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase para leer datos de un archivo CSV y almacenar los datos en una lista enlazada.
 */
public class TextFile {
    private String file; // Ruta del archivo CSV

    /**
     * Constructor para crear un objeto TextFile con la ruta del archivo especificada.
     *
     * @param file La ruta del archivo CSV que se leerá.
     */
    public TextFile(String file) {
        this.file = file;
    }

    /**
     * Lee la primera columna del archivo CSV y almacena los valores en una lista enlazada.
     *
     * @return Una lista enlazada que contiene los valores de la primera columna del archivo CSV.
     */
    public LinkedList readFile1() {
        LinkedList list1 = new LinkedList(); // Lista enlazada para almacenar los datos de la primera columna
        try (BufferedReader br = new BufferedReader(new FileReader(file))) { // Abre el archivo para lectura
            String line;
            while ((line = br.readLine()) != null) { // Lee línea por línea
                // Eliminar BOM y caracteres no deseados
                line = line.replace("\uFEFF", "").trim();
                String[] columns = line.split(","); // Divide la línea en columnas por la coma
                try {
                    // Convertir el primer valor de la columna a double y agregar a la lista
                    list1.addAtEnd(Double.parseDouble(columns[0].trim()));
                } catch (NumberFormatException e) {
                    System.err.println("Error al convertir el valor a decimal: " + columns[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Maneja errores de lectura del archivo
        }
        return list1; // Devuelve la lista enlazada con los datos de la primera columna
    }

    /**
     * Lee la segunda columna del archivo CSV y almacena los valores en una lista enlazada.
     *
     * @return Una lista enlazada que contiene los valores de la segunda columna del archivo CSV.
     */
    public LinkedList readFile2() {
        LinkedList list2 = new LinkedList(); // Lista enlazada para almacenar los datos de la segunda columna
        try (BufferedReader br = new BufferedReader(new FileReader(file))) { // Abre el archivo para lectura
            String line;
            while ((line = br.readLine()) != null) { // Lee línea por línea
                // Eliminar BOM y caracteres no deseados
                line = line.replace("\uFEFF", "").trim();
                String[] columns = line.split(","); // Divide la línea en columnas por la coma
                try {
                    // Convertir el segundo valor de la columna a double y agregar a la lista
                    list2.addAtEnd(Double.parseDouble(columns[1].trim()));
                } catch (NumberFormatException e) {
                    System.err.println("Error al convertir el valor a decimal: " + columns[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Maneja errores de lectura del archivo
        }
        return list2; // Devuelve la lista enlazada con los datos de la segunda columna
    }
}
