package program1;

/**
 * Clase que representa una lista enlazada simple.
 */
public class LinkedList {
    // Nodo inicial de la lista
    private Node head;

    /**
     * Constructor de la lista enlazada.
     * Inicializa la lista como vacía.
     */
    public LinkedList() {
        this.head = null;
    }

    /**
     * Añade un nuevo nodo al frente de la lista.
     * @param data El dato a almacenar en el nuevo nodo.
     */
    public void addAtFront(double data) {
        Node newNode = new Node(data); // Crea un nuevo nodo con el dato proporcionado
        newNode.next = head;           // El siguiente del nuevo nodo será el nodo actual en la cabeza
        head = newNode;                // La cabeza de la lista ahora es el nuevo nodo
    }

    /**
     * Verifica si la lista está vacía.
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return head == null; // La lista está vacía si la cabeza es null
    }

    /**
     * Añade un nuevo nodo al final de la lista.
     * @param data El dato a almacenar en el nuevo nodo.
     */
    public void addAtEnd(double data) {
        Node newNode = new Node(data); // Crea un nuevo nodo con el dato proporcionado
        if (isEmpty()) {               // Si la lista está vacía
            head = newNode;            // La cabeza de la lista es el nuevo nodo
        } else {
            Node current = head;       // Comienza desde la cabeza de la lista
            while (current.next != null) { // Recorre la lista hasta el último nodo
                current = current.next;
            }
            current.next = newNode;    // El último nodo ahora apunta al nuevo nodo
        }
    }

    /**
     * Imprime todos los elementos de la lista, separados por ' => '.
     */
    public void printList() {
        Node current = head;           // Comienza desde la cabeza de la lista
        if (current != null) {
            System.out.print(current.data); // Imprime el dato del primer nodo
            current = current.next;     // Avanza al siguiente nodo
        }
        while (current != null) {
            System.out.print(" => " + current.data); // Imprime el dato del nodo actual precedido por ' => '
            current = current.next;     // Avanza al siguiente nodo
        }
        System.out.println();         // Nueva línea al final de la impresión
    }

    /**
     * Obtiene todos los datos de la lista como un array de double.
     * @return Un array que contiene todos los datos de la lista.
     */
    public double[] getDataAsArray() {
        int size = getSize();          // Obtiene el tamaño de la lista
        double[] data = new double[size]; // Crea un array para almacenar los datos
        Node current = head;           // Comienza desde la cabeza de la lista
        int i = 0;
        while (current != null) {
            data[i] = current.data;    // Almacena el dato del nodo en el array
            i++;
            current = current.next;     // Avanza al siguiente nodo
        }
        return data;                   // Devuelve el array con todos los datos
    }

    /**
     * Obtiene el número de nodos en la lista.
     * @return El tamaño de la lista.
     */
    public int getSize() {
        int size = 0;
        Node current = head;           // Comienza desde la cabeza de la lista
        while (current != null) {
            size++;                    // Incrementa el tamaño por cada nodo
            current = current.next;     // Avanza al siguiente nodo
        }
        return size;                  // Devuelve el tamaño de la lista
    }

    /**
     * Obtiene el nodo inicial de la lista.
     * @return El nodo cabeza de la lista.
     */
    public Node getHead() {
        return head;                  // Devuelve el nodo cabeza
    }
}
