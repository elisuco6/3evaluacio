package Practica3;

/**
 * Pre: ---
 * Post: Creamos el objeto aeropuerto que va contener la pila, la cola
 *       y por ultimo una lista enlazada ya programadas
 */
public class Aeropuerto {
 private Stack pila;
 private Heap cola;
 private SimpleLinkedList lista;

 /**
  * Pre: ---
  * Post: declaramos un constructor completo
  */
 public Aeropuerto(Stack pila, Heap cola, SimpleLinkedList lista) {
  this.pila = pila;
  this.cola = cola;
  this.lista = lista;
 }

 /**
  * Pre: ---
  * Post: Creamos otro metodo contructor para crear la lista enlazada simple
  */
 public Aeropuerto(){
  SimpleLinkedList listaAviones = new SimpleLinkedList();

/*
 * Creamos los Aviones y asignamos el objeto al nodo
 */
   Avion creado = new Avion(123);
   Avion creado2 = new Avion(23);
   Node avion = new Node();
   Node avion2 = new Node();
   avion.setAvion(creado);
   avion2.setAvion(creado2);

   /*
    * Ahora añairemos los Aviones a la lista enlazada simple
    */
   listaAviones.add(avion);
   listaAviones.add(avion2);

   //declaramos la lista enlazada simple y creamos la pila y la cola
  this.lista = listaAviones;
  this.pila = new Stack();
  this.cola = new Heap();
 }
//Getter y Setter de los objetos
 public Stack getPila() {
  return pila;
 }

 public void setPila(Stack pila) {
  this.pila = pila;
 }

 public Heap getCola() {
  return cola;
 }

 public void setCola(Heap cola) {
  this.cola = cola;
 }

 public SimpleLinkedList getLista() {
  return lista;
 }

 public void setLista(SimpleLinkedList lista) {
  this.lista = lista;
 }

 /**
  * Pre: ---
  * Post: En este metodo recogemos los datos del pasajero y dentro recorremos la lista
  *       y comprobamos que el id del avion coincida con el id del pasajero y creamos un objeto pasajero
  *       y un nuevo nodo que nuevamente asignamos
  *
  */
 public void entrarPasajero(String nombre, String dni, int idAvion){
  for (int i=0;i<lista.getSize();i++){
   if(lista.get(i).getAvion().getId() == idAvion) {
    Pasajeros pasajero = new Pasajeros(nombre, dni, lista.get(i).getAvion());
    Node1 node = new Node1();
    node.setPasajeros(pasajero);
    //comprobamos el espacio de la cola si es menor de 2 entonces añadimos un nodo de persona
    if (cola.getSize() < 2) {
     cola.push(node);
     //cuando la cola esta llena hacemos lo mismo con la fila
    } else if (pila.getSize() < 3) {
     pila.push(node);
    } else {
     //si estan llenas mostramos este aviso
     System.out.println("estamos llenos");
    }
    break;
   }
  }
 }

 /**
  * Pre: ---
  * Post: en este metodo llamamos al pasajero y si la cola esta llena entonces empezamos sacando pasajeros de la cola
  *       cuando este vacia empezara con la pila, por ultimo meteremos los pasajeros que han salido a la lista de su
  *       avion
  */
 public void entregarPasaporte(){
  Node1 pasajero;

  if (!cola.isEmpty()){
   pasajero = cola.pop();
  } else {
   pasajero = pila.pop();
  }

  pasajero.getPasajeros().getIdAvion().getListapasajerosenelavion().add(pasajero.getPasajeros());
 }

 /**
  * Pre: ---
  * Post: es un metodo que solo se usa para mostrar lo que hay dentro de cada objeto.
  */
 public void mostrartodo(){
  cola.show();
  pila.show();
  lista.show();
 }
}