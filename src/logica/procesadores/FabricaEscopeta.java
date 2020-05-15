package logica.procesadores;

import java.util.ArrayList;
import java.util.Random;

import logica.algoritmos.Fifo;
import logica.algoritmos.RoundRobin;
import logica.algoritmos.Srtf;
import logica.procesos.Calidad;
import logica.procesos.Ensamble;
import logica.procesos.Fabricacion;
import logica.procesos.IProceso;
import logica.recurso.Metal;

public class FabricaEscopeta extends Thread implements IFabrica {
	private boolean estaDisponible;
	private int tiempoEjecucion;
	private int tiempoSuspendido;
	private int quantum;
	private int prioridad;
	private String nombreProceso;
	private RoundRobin roundRobin;
	private Fifo fifo;
	private Srtf srtf;
	
	private IProceso proceso=null;
	private Metal metal;
	
	public FabricaEscopeta() {
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
	
	public Fifo getFIFO() {
		if(fifo==null){
			fifo = new Fifo();
		}
		return fifo;
	}
	
	public Srtf getSRTF() {
		if(srtf==null) {
			srtf = new Srtf();
		}
		return srtf;
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
	public ArrayList<String> getListaProcesosListosSRTF(){
		return getSRTF().getColaListo().nombresNodos();
	}
	@Override
	public ArrayList<String> getListaProcesosListosFIFO(){
		return getFIFO().getColaListo().nombresNodos();
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

	/**
	 * @return una cola de procesos iniciales para la cola de listo para RR
	 */
	public ArrayList<IProceso> hacerColaRR() {
		Fabricacion fabricacion,fabricacion1;
		Ensamble ensamble,ensamble1;
		Calidad calidad,calidad1;
		ArrayList<IProceso> procesos = new ArrayList<IProceso>();
		
		fabricacion = new Fabricacion(1);
		ensamble = new Ensamble(1);
		calidad = new Calidad(1);
		fabricacion1 = new Fabricacion(1);
		ensamble1 = new Ensamble(1);
		calidad1 = new Calidad(1);
		fabricacion.start();
		ensamble.start();
		calidad.start();
		fabricacion1.start();
		ensamble1.start();
		calidad1.start();
	
		procesos.add(fabricacion1);
		procesos.add(ensamble1);
		procesos.add(calidad1);
		procesos.add(ensamble);
		procesos.add(fabricacion);
		procesos.add(calidad);
		
		return procesos;
	}
	
	public ArrayList<IProceso> hacerColaSRTF() {
		Fabricacion fabricacion,fabricacion1;
		Ensamble ensamble,ensamble1;
		Calidad calidad,calidad1;
		ArrayList<IProceso> procesos = new ArrayList<IProceso>();
		
		fabricacion = new Fabricacion(2);
		ensamble = new Ensamble(2);
		calidad = new Calidad(2);
		fabricacion1 = new Fabricacion(2);
		ensamble1 = new Ensamble(2);
		calidad1 = new Calidad(2);
		
		fabricacion.setTiempoRestante(16);
		ensamble.setTiempoRestante(15);
		calidad.setTiempoRestante(14);;
		fabricacion1.setTiempoRestante(13);
		ensamble1.setTiempoRestante(12);
		calidad1.setTiempoRestante(11);
		
		fabricacion.start();
		ensamble.start();
		calidad.start();
		fabricacion1.start();
		ensamble1.start();
		calidad1.start();
	
		procesos.add(fabricacion1);
		procesos.add(calidad1);
		procesos.add(ensamble);
		procesos.add(calidad);
		procesos.add(ensamble1);
		procesos.add(fabricacion);
		
		return procesos;
	}
	
	public ArrayList<IProceso> hacerColaFIFO() {
		Fabricacion fabricacion,fabricacion1;
		Ensamble ensamble,ensamble1;
		Calidad calidad,calidad1;
		ArrayList<IProceso> procesos = new ArrayList<IProceso>();
		
		fabricacion = new Fabricacion(3);
		ensamble = new Ensamble(3);
		calidad = new Calidad(3);
		fabricacion1 = new Fabricacion(3);
		ensamble1 = new Ensamble(3);
		calidad1 = new Calidad(3);
		fabricacion.start();
		ensamble.start();
		calidad.start();
		fabricacion1.start();
		ensamble1.start();
		calidad1.start();
	
		procesos.add(ensamble1);
		procesos.add(ensamble);
		procesos.add(calidad1);
		procesos.add(fabricacion1);
		procesos.add(fabricacion);
		procesos.add(calidad);
		
		return procesos;
	}
	/*
	 * Llenado de la cola listo con la cola de procesos iniciales
	 */
	public void llenadoInicial() {
		getRoundRobin().llenarProcesosListo(hacerColaRR());
		getSRTF().llenarProcesosListo(hacerColaSRTF());
		getFIFO().llenarProcesosListo(hacerColaFIFO());
	}
	
	

	@Override
	public void llenarEnCalienteRR() {
		Fabricacion fabricacion;
		Ensamble ensamble;
		Calidad calidad;
		
		fabricacion = new Fabricacion(1);
		ensamble = new Ensamble(1);
		calidad = new Calidad(1);
		
		int valor;
		Random ran = new Random(System.currentTimeMillis());

		valor = (ran.nextInt(3)+1);
		switch(valor){
			case 1:{
				fabricacion.start();
				getRoundRobin().getColaListo().insertarNodo(fabricacion);
				break;
			}
			case 2:{
				ensamble.start();
				getRoundRobin().getColaListo().insertarNodo(ensamble);
				break;
			}
			case 3:{
				calidad.start();
				getRoundRobin().getColaListo().insertarNodo(calidad);
				break;
			}
		}
		ran.setSeed(ran.nextLong());
	}
	
	public void llenarEnCalienteSRTF() {
		Fabricacion fabricacion;
		Ensamble ensamble;
		Calidad calidad;
		
		fabricacion = new Fabricacion(2);
		ensamble = new Ensamble(2);
		calidad = new Calidad(2);
		
		int valor;
		Random ran = new Random(System.currentTimeMillis());

		valor = (ran.nextInt(3)+1);
		switch(valor){
			case 1:{
				fabricacion.start();
				getSRTF().getColaListo().insertarNodo(fabricacion);
				break;
			}
			case 2:{
				ensamble.start();
				getSRTF().getColaListo().insertarNodo(ensamble);
				break;
			}
			case 3:{
				calidad.start();
				getSRTF().getColaListo().insertarNodo(calidad);
				break;
			}
		}
		getSRTF().getColaListo().ordenarCola();
		ran.setSeed(ran.nextLong());
	}
	
	public void llenarEnCalienteFIFO() {
		Fabricacion fabricacion;
		Ensamble ensamble;
		Calidad calidad;
		
		fabricacion = new Fabricacion(3);
		ensamble = new Ensamble(3);
		calidad = new Calidad(3);
		
		int valor;
		Random ran = new Random(System.currentTimeMillis());

		valor = (ran.nextInt(3)+1);
		switch(valor){
			case 1:{
				fabricacion.start();
				getFIFO().getColaListo().insertarNodo(fabricacion);
				break;
			}
			case 2:{
				ensamble.start();
				getFIFO().getColaListo().insertarNodo(ensamble);
				break;
			}
			case 3:{
				calidad.start();
				getFIFO().getColaListo().insertarNodo(calidad);
				break;
			}
		}
		ran.setSeed(ran.nextLong());
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
        	
        	despacharFIFO();
        	despacharSRTF();
        	
        	if(estaDisponible()) {
        		if(!getRoundRobin().getColaListo().colaVacia()) {
        			proceso = getRoundRobin().getColaListo().atenderCola();
        			tiempoEjecucion = proceso.getTiempoRestante();
        			quantum = proceso.getQuantum();
        			prioridad= proceso.getPrioridad();
        			nombreProceso = proceso.getNombreProceso();
        			setEstaDisponible(false);
        		}else {
        			if(!getSRTF().getColaListo().colaVacia()) {
        				proceso = getSRTF().getColaListo().atenderCola();
            			tiempoEjecucion = proceso.getTiempoRestante();
            			quantum = proceso.getQuantum();
            			prioridad= proceso.getPrioridad();
            			nombreProceso = proceso.getNombreProceso();
            			setEstaDisponible(false);
        			}else {
        				if(!getFIFO().getColaListo().colaVacia()) {
        					proceso = getFIFO().getColaListo().atenderCola();
                			tiempoEjecucion = proceso.getTiempoRestante();
                			quantum = 0;
                			prioridad= proceso.getPrioridad();
                			nombreProceso = proceso.getNombreProceso();
                			setEstaDisponible(false);
        				}else {
        					tiempoEjecucion = 0;
                			quantum = 0;
                			nombreProceso = "Ninguno";
        				}
        			}
 
        		}
        	}else if(!estaDisponible()) {
        		if(tiempoEjecucion>0) {
        			
        			if(prioridad==1) {
        				
	        			if(quantum>0) {
	        				espera(5);
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
	        				proceso.setQuantum(getRoundRobin().calcularQuantum(tiempoEjecucion));//se asigna quantum
	        				proceso.setTiempoRestante(tiempoEjecucion);
	        				getRoundRobin().getColaEspera().insertarNodo(proceso);
	        				setEstaDisponible(true);
	        			}
	        			
        			}else if(prioridad==2) {
        				
        				/*/* borrar *////////////
        				if(quantum>0) {
	        				espera(5);
	        				
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
	        				proceso.setQuantum(getRoundRobin().calcularQuantum(tiempoEjecucion));//se asigna quantum
	        				proceso.setTiempoRestante(tiempoEjecucion);
	        				getRoundRobin().getColaEspera().insertarNodo(proceso);
	        				setEstaDisponible(true);
	        			}
        				/*/*////////////*///////////////////
        				
        				
        			}else if(prioridad==3) {       //////////*/*PRIORIDAD 3*///////////////
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
        					quantum = 0;
        				}
        			}
        			
        		}else {	
        			if(proceso.getUsarRecurso()) {
        				metal.setEstaDisponible(true);
        			}
        			enUso=false;
        			proceso.setSinTerminar(false);
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
        	//REVISAR
        	nombreProceso = proceso.getNombreProceso();
        }
    }
	
	public void despacharFIFO() {
		int i=0;
		IProceso aux;
		ArrayList<IProceso> procesos = new ArrayList<IProceso>();
		procesos=getFIFO().getColaListo().despachar();
		while(procesos.size()>i) {
			aux=procesos.get(i);
			aux.setPrioridad(2);
			aux.setEnvejecimiento(0);
			getSRTF().getColaListo().insertarNodo(aux);
			i++;
		}
	}
	
	public void despacharSRTF() {
		int i=0;
		IProceso aux;
		ArrayList<IProceso> procesos = new ArrayList<IProceso>();
		procesos=getSRTF().getColaListo().despachar();
		while(procesos.size()>i) {
			aux=procesos.get(i);
			aux.setPrioridad(1);
			aux.setEnvejecimiento(0);
			getRoundRobin().getColaListo().insertarNodo(aux);
			i++;
		}
	}
	
	
	private void espera(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
        	
        }
    }

}
