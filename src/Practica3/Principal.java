package Practica3;

import java.util.ArrayList;
/**
 * Pre: ---
 * Post: el metodo main es el encargado de crear el aeropuerto, los pasajeros y asignarles un avion y subimos a dos
 * 		pasajeros al avion, posteriormente mostramos los pasajeros que su id avion coincidda con la 123 y
 * 		hayan embarcado ya por ultimo mostramos el resto de pasajeros que no han embarcado.
 */
public class Principal {
	public static void main(String[] args) {
		Aeropuerto barajas = new Aeropuerto();

		barajas.entrarPasajero("Luis","123123123-H",123);
		barajas.entrarPasajero("Elene","321321321-D",23);
		barajas.entrarPasajero("Carmen","17799874-X",123);
		barajas.entrarPasajero("Manuel","22669988-D",123);

		barajas.getCola().show();
		barajas.getPila().show();

		System.out.println("\nEntrega documentación pasajero ");
		System.out.println("Entrega documentación pasajero ");
		barajas.entregarPasaporte();
		barajas.entregarPasaporte();

		System.out.println("\nPasajeros de: "+barajas.getLista().getIdAvion(123));
		barajas.getLista().getIdAvion(123).getAvion().mostrarpasajeros();

		barajas.entregarPasaporte();

		System.out.println("\nEntrega documentación pasajero ");
		System.out.println();
		System.out.println("pasajeros sobrantes: ");
		barajas.getPila().show();
		barajas.getCola().show();
	}
}
