package logica.algoritmos;

import java.util.ArrayList;

import logica.Cola;
import logica.procesos.IProceso;

public class Srtf {
	private Cola listo;
	
	public Srtf() {
		
	}
	
	public void llenarProcesosListo(ArrayList<IProceso> objetos) {
		
		IProceso dato = null;
		int i=0;
		while(objetos.size()>i) {
			dato = objetos.get(i);
			getColaListo().insertarNodo(dato);
			i++;
		}
		getColaListo().ordenarCola();
	}
	
	public Cola getColaListo() {
		if(listo == null)
			listo = new Cola();
		return listo;
	}
}
