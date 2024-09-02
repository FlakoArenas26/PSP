package program1;

/**
 * Clase que calcula la media y la desviación estándar de una lista enlazada de números.
 */
public class Mean {
    private LinkedList list; // Lista enlazada que contiene los datos

    /**
     * Constructor para crear un objeto Mean con una lista enlazada específica.
     *
     * @param list La lista enlazada que contiene los datos sobre los que se calcularán las estadísticas.
     */
    public Mean(LinkedList list) {
        this.list = list;
    }

    /**
     * Calcula la media (promedio) de los datos en la lista enlazada.
     *
     * @return La media de los datos en la lista.
     * @throws ArithmeticException Si la lista está vacía (es decir, el conteo de elementos es 0).
     */
    public double obtainAverage() {
        double sum = 0;  // Suma acumulativa de los datos
        int count = 0;   // Contador de elementos en la lista
        Node current = list.getHead();  // Obtiene la cabeza de la lista utilizando el método getHead()
        
        while (current != null) {  // Recorre la lista hasta llegar al final
            sum += current.data;  // Acumula el valor de cada nodo
            count++;              // Incrementa el contador de elementos
            current = current.next; // Avanza al siguiente nodo
        }
        
        // Verifica si la lista está vacía
        if (count == 0) {
            throw new ArithmeticException("No se puede calcular la media de una lista vacía.");
        }
        
        return sum / count;  // Calcula y devuelve la media
    }

    /**
     * Calcula la desviación estándar de los datos en la lista enlazada.
     *
     * @return La desviación estándar de los datos en la lista.
     * @throws ArithmeticException Si la lista está vacía (es decir, el conteo de elementos es 0).
     */
    public double obtainStandardDeviation() {
        double mean = obtainAverage();  // Obtiene la media para usar en el cálculo de desviación estándar
        double sum = 0;                // Suma acumulativa de las diferencias cuadradas respecto a la media
        int count = 0;                 // Contador de elementos en la lista
        Node current = list.getHead(); // Obtiene la cabeza de la lista utilizando el método getHead()
        
        while (current != null) {  // Recorre la lista hasta llegar al final
            sum += Math.pow(current.data - mean, 2);  // Acumula el cuadrado de la diferencia respecto a la media
            count++;              // Incrementa el contador de elementos
            current = current.next; // Avanza al siguiente nodo
        }
        
        // Verifica si la lista está vacía
        if (count == 0) {
            throw new ArithmeticException("No se puede calcular la desviación estándar de una lista vacía.");
        }
        
        return Math.sqrt(sum / count);  // Calcula y devuelve la desviación estándar
    }
}
