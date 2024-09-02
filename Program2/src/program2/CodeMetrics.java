package program2;

/**
 * Clase que mantiene y muestra métricas de código, como el número de líneas, comentarios, clases y métodos.
 * 
 * Esta clase proporciona métodos para incrementar contadores de métricas y para mostrar los resultados.
 */
public class CodeMetrics {

    private int lineCount;     // Contador de líneas de código.
    private int commentCount;  // Contador de comentarios.
    private int classCount;    // Contador de clases.
    private int methodCount;   // Contador de métodos.

    /**
     * Constructor para inicializar un objeto CodeMetrics con contadores en cero.
     */
    public CodeMetrics() {
        this.lineCount = 0;
        this.commentCount = 0;
        this.classCount = 0;
        this.methodCount = 0;
    }

    /**
     * Incrementa el contador de líneas de código.
     */
    public void incrementLineCount() {
        lineCount++;
    }

    /**
     * Incrementa el contador de comentarios.
     */
    public void incrementCommentCount() {
        commentCount++;
    }

    /**
     * Incrementa el contador de clases.
     */
    public void incrementClassCount() {
        classCount++;
    }

    /**
     * Incrementa el contador de métodos.
     */
    public void incrementMethodCount() {
        methodCount++;
    }

    /**
     * Muestra las métricas de código en la consola.
     * 
     * Imprime el número total de líneas de código, comentarios, clases y métodos.
     */
    public void displayMetrics() {
        System.out.println("Líneas de código: " + lineCount);
        System.out.println("Comentarios: " + commentCount);
        System.out.println("Clases: " + classCount);
        System.out.println("Métodos: " + methodCount);
    }
}
