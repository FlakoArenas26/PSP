package program2;

import javax.swing.*;
import java.io.File;

/**
 * Clase principal del programa que permite seleccionar un archivo o directorio
 * mediante un cuadro de diálogo y analiza el archivo o directorio seleccionado.
 */
public class Program2 {

    /**
     * Método principal que se ejecuta al iniciar el programa.
     * Muestra un cuadro de diálogo para seleccionar un archivo o directorio y realiza el análisis correspondiente.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        // Crear un cuadro de diálogo para seleccionar archivos o directorios.
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        // Mostrar el cuadro de diálogo y obtener el valor de retorno.
        int returnValue = fileChooser.showOpenDialog(null);

        // Si se selecciona un archivo o directorio, se obtiene el archivo seleccionado.
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // Verificar si el archivo seleccionado es un directorio.
            if (selectedFile.isDirectory()) {
                // Crear un objeto DirectoryAnalyzer para analizar el directorio.
                DirectoryAnalyzer directoryAnalyzer = new DirectoryAnalyzer(selectedFile);
                directoryAnalyzer.analyze();
            } 
            // Verificar si el archivo seleccionado es un archivo con extensión .java.
            else if (selectedFile.isFile() && selectedFile.getName().endsWith(".java")) {
                // Crear un objeto FileAnalyzer para analizar el archivo Java.
                FileAnalyzer fileAnalyzer = new FileAnalyzer(selectedFile);
                fileAnalyzer.analyze();
            } 
            // Si el archivo no es un directorio ni un archivo Java válido.
            else {
                System.out.println("El archivo seleccionado no es válido.");
            }
        } 
        // Si no se selecciona ningún archivo o directorio.
        else {
            System.out.println("No se ha seleccionado ningún archivo o directorio.");
        }
    }
}
