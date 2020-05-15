package logica;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import logica.procesos.IProceso;

public class Cola {
	Nodo cabeza, fin;
	
	public void insertarNodo(IProceso dato){
		Nodo nuevo = new Nodo();
		nuevo.dato = dato;
		nuevo.nodoSiguiente = null;
		if(colaVacia()) {
			cabeza = nuevo;
			fin = nuevo;
		}else {
			fin.nodoSiguiente = nuevo;
			fin = nuevo;
		}
	}
	
	public IProceso atenderCola() {
		IProceso dato = null;
		if(!colaVacia()) {
			dato = cabeza.dato;
			cabeza = cabeza.nodoSiguiente;
		}
		return dato;		
	}
	
	public void imprimirCola() {
		Nodo aux = cabeza;
		while(!(aux==null)) {
			JOptionPane.showMessageDialog(null, aux.getDato());
			aux=aux.nodoSiguiente;
		}
	}
	
	public ArrayList<String> nombresNodos(){
		Nodo aux = cabeza;
		ArrayList<String> nombres = new ArrayList<String>();
		while(!(aux==null)) {
			nombres.add(aux.getDato().getNombreProceso());
			aux=aux.nodoSiguiente;
		}
		return nombres;
	}
	
	public ArrayList<Integer> getTiempos(){
		ArrayList<Integer> tiempos = new  ArrayList<Integer>();
		Nodo aux = cabeza;
		while(!(aux==null)) {
			tiempos.add(aux.getDato().getTiempoRestante());
			aux=aux.nodoSiguiente;
		}
		tiempos.sort(null);
		return tiempos;
	}
	
	public int contarNodos() {
		Nodo aux = cabeza;
		int suma=0;
		while(!(aux==null)) {
			suma = suma +1;
			aux=aux.nodoSiguiente;
		}
		return suma;
	}
	
	public void ordenarCola() {
		IProceso aux;
		Nodo q = cabeza;		
		
		while(q!=null){
			Nodo r = q.nodoSiguiente;
			while(r!=null){
				if((q.dato.getTiempoRestante()) > (r.dato.getTiempoRestante())){
					aux=q.dato;
					q.dato = (r).dato;
					(r).dato = aux;
				}
				r=r.nodoSiguiente;
			}
			q=q.nodoSiguiente;		
		}
	}
	
	public ArrayList<IProceso> despachar() {
		ArrayList<IProceso> procesos = new ArrayList<IProceso>();
		Nodo q = cabeza;
		Nodo r =null;
		while(q!=null){
			if(q.dato.getEnvejecimiento()>30 ) {
				if(q==cabeza) {
					procesos.add(q.dato);
					cabeza=q.nodoSiguiente;
					q.nodoSiguiente=null;
					q=cabeza;
				}else {
					procesos.add(q.dato);
					r.nodoSiguiente=q.nodoSiguiente;
					q.nodoSiguiente=null;
					q=r.nodoSiguiente;
				}
			}else {
				r=q;
				q=q.nodoSiguiente;
			}
		}
		return procesos;
	}
	
	
	public boolean colaVacia() {
		return cabeza==null;
	}
	
	
}
