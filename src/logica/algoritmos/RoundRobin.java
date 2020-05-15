package logica.algoritmos;

import java.util.ArrayList;

import logica.Cola;
import logica.procesos.IProceso;

public class RoundRobin {
	private Cola listo, suspendido, bloqueado,terminado;
	
	/*
	 * Llenado de las colas a partir de un array
	 * Llenado inicial.
	 */
	
	public void llenarProcesosListo(ArrayList<IProceso> objetos) {
		
		IProceso dato = null;
		int i=0;
		while(objetos.size()>i) {
			dato = objetos.get(i);
			getColaListo().insertarNodo(dato);
			i++;
		}
	}
	
	
	public int calcularQuantum(int valor) {
		int dato=0;
		int tamaño= getColaListo().getTiempos().size();
		if(tamaño>0) {
			if(tamaño%2==0){
				dato = ( getColaListo().getTiempos().get((tamaño/2)-1) + getColaListo().getTiempos().get((tamaño/2)) )/2; 
			}else {
				dato = getColaListo().getTiempos().get((tamaño-1)/2);
			}
			if(dato>valor) {
				dato = valor;
			}
		}else {
			dato = valor;
		}
		
		return dato;
	}
	
	
	/*
	 * gets colas listo espera bloqueado
	 */
	public Cola getColaListo() {
		if(listo == null)
			listo = new Cola();
		return listo;
	}
	public Cola getColaEspera() {
		if(suspendido == null)
			suspendido = new Cola();
		return suspendido;
	}
	public Cola getColaBloqueado() {
		if(bloqueado == null)
			bloqueado = new Cola();
		return bloqueado;
	}
	
	public Cola getColaTerminado() {
		if(terminado == null) {
			terminado = new Cola();
		}
		return terminado;
	}
	
	
	
}
