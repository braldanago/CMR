package presentacion;


import logica.Sistema;
import presentacion.vistas.VistaJuego;

public class Modelo implements Runnable {
	private VistaJuego vistaJuego;
	private Sistema sistema;
	private Thread hiloJuego;
	private int tiempoJuego=0;
	
	public Modelo() {
		getVistaJuego().setLocation(0, 0);
		esperar(5);
		getVistaJuego().setVisible(true);
	}
	
	public Thread getHiloJuego() {
		if(hiloJuego==null) {
			hiloJuego = new Thread(this);
		}
		return hiloJuego;
	}
	
	public void iniciar() {
		
		getSistema().getFabricaPistola().start();
		esperar(5);
		getSistema().getFabricaEscopeta().start();
		esperar(5);
		//getSistema().getFabricaSniper().start();
		//esperar(5);
		getHiloJuego().start();
	
		
	}
	
	public Sistema getSistema() {
		if(sistema == null)
			sistema = new Sistema();
		return sistema;
	}
	
	public VistaJuego getVistaJuego() {
		if(vistaJuego == null)
			vistaJuego = new VistaJuego(this);
		return vistaJuego;
	}
	
	@Override
	public void run() {
		while(getSistema().isJuegoActivo()) {
			esperar(5);
			enviarEstadoMetal();
			esperar(5);
			enviarSeccionCriticaPistola();
			esperar(5);
			enviarSeccionCriticaEscopeta();
			//esperar(5);
			//enviarSeccionCriticaSniper();
			//esperar(5);
			esperar(1000);
			enviarColasPistola();
			esperar(5);
			enviarColasEscopeta();
			//esperar(5);
			//enviarColasSniper();
			esperar(5);
			enviarTiempoJuego();
		
		}
	}
	
	public void enviarTiempoJuego() {
		tiempoJuego = tiempoJuego+1;
		if(tiempoJuego<180) {
			getVistaJuego().cambiarTiempoJuego(tiempoJuego);
		}else {
			getSistema().setJuegoActivo(false);
			esperar(20);
			getVistaJuego().avisarFin();
		}

	}
	
	/*
	 * Envia datos a la vista para actualizar estado del metal
	 */
	public void enviarEstadoMetal() {
		if(getSistema().getMetal().isEstaDisponible()) {
			getVistaJuego().cambiarEstadoMetal(getSistema().getMetal().getImgDisponible());
		}else {
			getVistaJuego().cambiarEstadoMetal(getSistema().getMetal().getImgOcupado());
		}
	}
	
	
	/*
	 * Envia datos a la vista para actualizar seccion critica de fab pistolas
	 */
	public void enviarSeccionCriticaPistola() {
		getVistaJuego().cambiarProcesoPistola(getSistema().getFabricaPistola().getNombreProceso());
		getVistaJuego().cambiarTiempoRestantePistola(getSistema().getFabricaPistola().getTiempoEjecucion());
		getVistaJuego().cambiarQuantumPistola(getSistema().getFabricaPistola().getQuantum());
	}
	
	public void enviarSeccionCriticaEscopeta() {
		getVistaJuego().cambiarProcesoEscopeta(getSistema().getFabricaEscopeta().getNombreProceso());
		getVistaJuego().cambiarTiempoRestanteEscopeta(getSistema().getFabricaEscopeta().getTiempoEjecucion());
		getVistaJuego().cambiarQuantumEscopeta(getSistema().getFabricaEscopeta().getQuantum());
	}
	/*
	public void enviarSeccionCriticaSniper() {
		getVistaJuego().cambiarProcesoSniper(getSistema().getFabricaSniper().getNombreProceso());
		getVistaJuego().cambiarTiempoRestanteSniper(getSistema().getFabricaSniper().getTiempoEjecucion());
		getVistaJuego().cambiarQuantumSniper(getSistema().getFabricaSniper().getQuantum());
	}
	*/
	
	
	/*
	 * Envia informacion de las colas que pertenecen a la fabrica de pistolas hacia la vista
	 */
	public void enviarColasPistola() {
		enviarListosPistola();
		enviarSuspendidosPistola();
		enviarBloqueadosPistola();
		enviarTerminadosPistola();
		enviarListosSRTFPistola();
		enviarListosFIFOPistola();
	}
	public void enviarListosPistola() {
		getVistaJuego().llenarListosPistola(getSistema().getFabricaPistola().getListaProcesosListosRR());
	}
	public void enviarSuspendidosPistola() {
		getVistaJuego().llenarSuspendidosPistola(getSistema().getFabricaPistola().getListaProcesosSuspendidos());
	}
	public void enviarBloqueadosPistola() {
		getVistaJuego().llenarBloqueadosPistola(getSistema().getFabricaPistola().getListaProcesosBloqueados());
	}
	public void enviarTerminadosPistola() {
		getVistaJuego().llenarTerminadosPistola(getSistema().getFabricaPistola().getListaProcesosTerminados());
	}
	
	public void enviarListosSRTFPistola() {
		getVistaJuego().llenarListosSRTF(getSistema().getFabricaPistola().getListaProcesosListosSRTF());
	}
	
	public void enviarListosFIFOPistola() {
		getVistaJuego().llenarListosFIFO(getSistema().getFabricaPistola().getListaProcesosListosFIFO());
	}
	
	
	
	/*
	 * Envia informacion de las colas que pertenecen a la fabrica de escopetas hacia la vista
	 */
	
	public void enviarColasEscopeta() {
		enviarListosEscopeta();
		enviarSuspendidosEscopeta();
		enviarBloqueadosEscopeta();
		enviarTerminadosEscopeta();
		enviarListosSRTFEscopeta();
		enviarListosFIFOEscopeta() ;
	}
	public void enviarListosEscopeta() {
		getVistaJuego().llenarListosEscopeta(getSistema().getFabricaEscopeta().getListaProcesosListosRR());
	}
	public void enviarSuspendidosEscopeta() {
		getVistaJuego().llenarSuspendidosEscopeta(getSistema().getFabricaEscopeta().getListaProcesosSuspendidos());
	}
	public void enviarBloqueadosEscopeta() {
		getVistaJuego().llenarBloqueadosEscopeta(getSistema().getFabricaEscopeta().getListaProcesosBloqueados());
	}
	public void enviarTerminadosEscopeta() {
		getVistaJuego().llenarTerminadosEscopeta(getSistema().getFabricaEscopeta().getListaProcesosTerminados());
	}
	public void enviarListosSRTFEscopeta() {
		getVistaJuego().llenarListosSRTFEscopeta(getSistema().getFabricaEscopeta().getListaProcesosListosSRTF());
	}
	public void enviarListosFIFOEscopeta() {
		getVistaJuego().llenarListosFIFOEscopeta(getSistema().getFabricaEscopeta().getListaProcesosListosFIFO());
	}
	
	
	
	
	/*
	 * Envia informacion de las colas que pertenecen a la fabrica de snipers hacia la vista
	 */
	/*
	public void enviarColasSniper() {
		enviarListosSniper();
		enviarSuspendidosSniper();
		enviarBloqueadosSniper();
		enviarTerminadosSniper();
	}
	public void enviarListosSniper() {
		getVistaJuego().llenarListosSniper(getSistema().getFabricaSniper().getListaProcesosListos());
	}
	public void enviarSuspendidosSniper() {
		getVistaJuego().llenarSuspendidosSniper(getSistema().getFabricaSniper().getListaProcesosSuspendidos());
	}
	public void enviarBloqueadosSniper() {
		getVistaJuego().llenarBloqueadosSniper(getSistema().getFabricaSniper().getListaProcesosBloqueados());
	}
	public void enviarTerminadosSniper() {
		getVistaJuego().llenarTerminadosSniper(getSistema().getFabricaSniper().getListaProcesosTerminados());
	}
	*/
	
	
	private void esperar(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
        }
    }
	
	
}
