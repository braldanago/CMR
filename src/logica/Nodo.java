package logica;

import logica.procesos.IProceso;

public class Nodo {
	IProceso dato;
	Nodo nodoSiguiente;
	
	public IProceso getDato() {
		return dato;
	}
	public void setDato(IProceso dato) {
		this.dato = dato;
	}
	public Nodo getNodoSiguiente() {
		return nodoSiguiente;
	}
	public void setNodoSiguiente(Nodo nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}
	
	
}
