package logica.procesadores;

import java.util.ArrayList;
import java.util.Random;

import logica.algoritmos.RoundRobin;
import logica.procesos.Calidad;
import logica.procesos.Ensamble;
import logica.procesos.Fabricacion;
import logica.procesos.IProceso;
import logica.recurso.Metal;

public class FabricaSniper extends Thread implements IFabrica {
	
	private boolean estaDisponible;
	private int tiempoEjecucion;
	private int tiempoSuspendido;
	private int quantum;
	private String nombreProceso;
	private RoundRobin roundRobin;
	
	private IProceso proceso=null;
	private Metal metal;
	
	public FabricaSniper() {
		this.estaDisponible=true;
		this.tiempoSuspendido=7;
		this.metal = Metal.getInstance();
		llenadoInicial();

	}
	
	public RoundRobin getRoundRobin() {
		if(roundRobin==null) {
			roundRobin = new RoundRobin();
		}
		return roundRobin;
	}
	
	@Override
	public boolean estaDisponible() {
		return this.estaDisponible;
	}
	
	@Override
	public void setEstaDisponible(boolean valor) {
		this.estaDisponible=valor;		
	}

	@Override
	public int getTiempoEjecucion() {
		return tiempoEjecucion;
	}
	

	
	@Override
	public int getQuantum() {
		return quantum;
	}
	

	@Override
	public String getNombreProceso() {
		return nombreProceso;
	}
	
	@Override
	public ArrayList<String> getListaProcesosListosRR(){
		return getRoundRobin().getColaListo().nombresNodos();
	}
	
	@Override
	public ArrayList<String> getListaProcesosSuspendidos(){
		return getRoundRobin().getColaEspera().nombresNodos();
	}
	
	@Override
	public ArrayList<String> getListaProcesosBloqueados(){
		return getRoundRobin().getColaBloqueado().nombresNodos();
	}
	
	@Override
	public ArrayList<String> getListaProcesosTerminados(){
		return getRoundRobin().getColaTerminado().nombresNodos();
	}


	public ArrayList<IProceso> hacerCola() {
		IProceso fabricacion,fabricacion1;
		IProceso ensamble,ensamble1;
		IProceso calidad,calidad1;
		ArrayList<IProceso> procesos = new ArrayList<IProceso>();
		
		fabricacion = new Fabricacion(1);
		ensamble = new Ensamble(1);
		calidad = new Calidad(1);
		fabricacion1 = new Fabricacion(1);
		ensamble1 = new Ensamble(1);
		calidad1 = new Calidad(1);
		
		procesos.add(calidad);
		procesos.add(fabricacion1);
		procesos.add(ensamble);
		procesos.add(ensamble1);
		procesos.add(fabricacion);
		procesos.add(calidad1);
		
		
		
		return procesos;
	}
	
	/*
	 * Llenado de la cola listo con la cola de procesos iniciales
	 */
	public void llenadoInicial() {
		getRoundRobin().llenarProcesosListo(hacerCola());
	}
	
	@Override
	public void llenarEnCalienteRR() {
		/*IProceso fabricacion;
		IProceso ensamble;
		IProceso calidad;
		
		fabricacion = new Fabricacion(1);
		ensamble = new Ensamble(null);
		calidad = new Calidad();
		
		int valor;
		Random ran = new Random(System.currentTimeMillis());

		valor = (ran.nextInt(3)+1);
		switch(valor){
			case 1:{
				getRoundRobin().getColaListo().insertarNodo(fabricacion);
				break;
			}
			case 2:{
				getRoundRobin().getColaListo().insertarNodo(ensamble);
				break;
			}
			case 3:{
				getRoundRobin().getColaListo().insertarNodo(calidad);
				break;
			}
		}
		ran.setSeed(ran.nextLong());*/
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 * Aqui se representa la seccion critica
	 */
	@Override
    public void run(){
		boolean enUso=false;
        while(true){
        	espera(1000);//velocidad
        	if(estaDisponible()) {
        		if(!getRoundRobin().getColaListo().colaVacia()) {
        			proceso = getRoundRobin().getColaListo().atenderCola();
        			tiempoEjecucion = proceso.getTiempoRestante();
        			quantum = proceso.getQuantum();
        			nombreProceso = proceso.getNombreProceso();
        			setEstaDisponible(false);
        		}else {
        			tiempoEjecucion = 0;
        			quantum = 0;
        			nombreProceso = "Ninguno";
        		}
        		
        	}else if(!estaDisponible()) {
        		if(tiempoEjecucion>0) {
        			if(quantum>0) {
        				espera(15);
        				if(proceso.getUsarRecurso() && !metal.isEstaDisponible() && !enUso) {
        					getRoundRobin().getColaBloqueado().insertarNodo(proceso);
        					enUso=false;
        					setEstaDisponible(true);
        				}else {
        					if(proceso.getUsarRecurso()) {
        						metal.setEstaDisponible(false);
        						enUso=true;
        					}
        					enUso=true;
        					tiempoEjecucion = tiempoEjecucion-1;
            				quantum = quantum-1;
        				}
        			}else {
        				if(proceso.getUsarRecurso()) {
            				metal.setEstaDisponible(true);
            				
            			}
        				enUso=false;
        				proceso.setQuantum(getRoundRobin().calcularQuantum(tiempoEjecucion));
        				proceso.setTiempoRestante(tiempoEjecucion);
        				getRoundRobin().getColaEspera().insertarNodo(proceso);
        				setEstaDisponible(true);
        			}
        			
        		}else {	
        			if(proceso.getUsarRecurso()) {
        				metal.setEstaDisponible(true);
        				
        			}
        			enUso=false;
        			getRoundRobin().getColaTerminado().insertarNodo(proceso);
        			setEstaDisponible(true);
        		}
        	}
        	if(!getRoundRobin().getColaEspera().colaVacia()) {
        		if(getRoundRobin().getColaListo().colaVacia()) {
        			getRoundRobin().getColaListo().insertarNodo(getRoundRobin().getColaEspera().atenderCola());
        		}else {
	        		if(tiempoSuspendido>0) {
	        			tiempoSuspendido = tiempoSuspendido-1;
	        		}else {
	        			getRoundRobin().getColaListo().insertarNodo(getRoundRobin().getColaEspera().atenderCola());
	        			tiempoSuspendido=7;
	        		}
        		}
        	}
        	if(!getRoundRobin().getColaBloqueado().colaVacia()) {
        		if(metal.isEstaDisponible()) {
        			getRoundRobin().getColaListo().insertarNodo(getRoundRobin().getColaBloqueado().atenderCola());
        		}
        	}
        }
    }
	
	
	private void espera(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
        	
        }
    }

	@Override
	public ArrayList<String> getListaProcesosListosSRTF() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getListaProcesosListosFIFO() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
