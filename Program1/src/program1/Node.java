package program1;

/**
 * Clase que representa un nodo en una lista enlazada.
 * Cada nodo almacena un dato de tipo double y una referencia al siguiente nodo en la lista.
 */
public class Node {
    // Dato almacenado en el nodo
    double data;
    
    // Referencia al siguiente nodo en la lista
    Node next;

    /**
     * Constructor para crear un nuevo nodo con un dato específico.
     * El siguiente nodo se establece en null por defecto.
     *
     * @param data El dato a almacenar en el nodo.
     */
    public Node(double data) {
        this.data = data;  // Asigna el dato al campo data
        this.next = null;  // Inicializa la referencia al siguiente nodo como null
    }
}
