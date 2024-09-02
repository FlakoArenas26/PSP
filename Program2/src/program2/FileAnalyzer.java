package program2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que analiza un archivo Java para contar líneas de código, comentarios, clases y métodos.
 * 
 * Esta clase proporciona un análisis básico de archivos fuente en Java, contando el número de líneas,
 * comentarios, clases y métodos en el archivo Java especificado.
 */
public class FileAnalyzer {
    private File file;

    /**
     * Constructor para crear un objeto FileAnalyzer con un archivo específico.
     *
     * @param file El archivo Java que se analizará. Debe ser un archivo con extensión .java.
     */
    public FileAnalyzer(File file) {
        this.file = file;
    }

    /**
     * Analiza el archivo Java para contar líneas de código, comentarios, clases y métodos.
     * 
     * Este método lee el archivo línea por línea y realiza el siguiente análisis:
     * - Cuenta el número total de líneas.
     * - Detecta y cuenta los comentarios en línea (líneas que comienzan con ).
     * - Detecta y cuenta los comentarios en bloque (delimitados por "/*" y ).
     * - Cuenta el número de clases y/o interfaces definidas en el archivo.
     * - Cuenta el número de métodos definidos en el archivo.
     */
    public void analyze() {
        int lines = 0;       // Contador para el número total de líneas en el archivo.
        int comments = 0;    // Contador para el número de líneas con comentarios.
        int classes = 0;     // Contador para el número de clases e interfaces.
        int methods = 0;     // Contador para el número de métodos.

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean inBlockComment = false;

            // Leer el archivo línea por línea.
            while ((line = br.readLine()) != null) {
                lines++;  // Incrementa el contador de líneas.

                // Detectar y contar comentarios en línea.
                if (line.trim().startsWith("//")) {
                    comments++;
                }

                // Detectar y contar comentarios en bloque.
                if (line.contains("/*")) {
                    inBlockComment = true;
                }
                if (inBlockComment) {
                    comments++;
                }
                if (line.contains("*/")) {
                    inBlockComment = false;
                }

                // Detectar y contar declaraciones de clases e interfaces.
                if (line.matches("^\\s*(public|protected|private|static|abstract|final)?\\s*(class|interface)\\s+\\w+.*")) {
                    classes++;
                }

                // Detectar y contar declaraciones de métodos.
                if (line.matches("^\\s*(public|protected|private|static|abstract|final)?\\s*\\w+\\s+\\w+\\s*\\(.*\\)\\s*\\{?")) {
                    methods++;
                }
            }
        } catch (IOException e) {
            // Manejar excepciones de entrada/salida.
            e.printStackTrace();
        }

        // Imprimir los resultados del análisis.
        System.out.println("");
        System.out.println("Archivo: " + file.getName());
        System.out.println("");
        System.out.println("");
        System.out.println("Número de líneas con código: " + lines);
        System.out.println("Número de líneas con comentarios: " + comments);
        System.out.println("Número de clases: " + classes);
        System.out.println("Número de métodos: " + methods);
        System.out.println("");
    }
}
