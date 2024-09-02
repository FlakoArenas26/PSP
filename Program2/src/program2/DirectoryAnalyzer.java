package program2;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Clase que analiza un directorio para encontrar archivos Java y analizarlos.
 * 
 * Esta clase proporciona funcionalidades para explorar un directorio y sus subdirectorios,
 * buscando archivos con extensión `.java`. Cada archivo encontrado es analizado utilizando
 * la clase `FileAnalyzer`.
 */
public class DirectoryAnalyzer {
    private File directory;

    /**
     * Constructor para crear un objeto DirectoryAnalyzer con un directorio específico.
     *
     * @param directory El directorio que se analizará. Debe ser un directorio que contenga archivos .java.
     */
    public DirectoryAnalyzer(File directory) {
        this.directory = directory;
    }

    /**
     * Analiza el directorio seleccionado.
     * 
     * Este método verifica si el archivo proporcionado es un directorio. Si lo es, llama al método
     * `analyzeDirectory` para realizar el análisis. Si no es un directorio, se imprime un mensaje
     * indicando que el archivo seleccionado no es un directorio.
     */
    public void analyze() {
        if (directory.isDirectory()) {
            analyzeDirectory(directory);
        } else {
            System.out.println("El archivo seleccionado no es un directorio.");
        }
    }

    /**
     * Analiza el contenido del directorio dado.
     * 
     * Este método busca archivos con extensión `.java` en el directorio proporcionado y los analiza
     * utilizando `FileAnalyzer`. Luego, recursivamente analiza todos los subdirectorios.
     *
     * @param dir El directorio que se analizará.
     */
    private void analyzeDirectory(File dir) {
        // Filtrar los archivos con extensión .java
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });

        // Si se encontraron archivos .java, analizarlos
        if (files != null) {
            for (File file : files) {
                FileAnalyzer fileAnalyzer = new FileAnalyzer(file);
                fileAnalyzer.analyze();
            }

            // Recursivamente analizar subdirectorios
            File[] subDirs = dir.listFiles(File::isDirectory);
            if (subDirs != null) {
                for (File subDir : subDirs) {
                    analyzeDirectory(subDir);
                }
            }
        } else {
            System.out.println("No se encontraron archivos .java en el directorio.");
        }
    }
}
