package logica;


import logica.procesadores.FabricaEscopeta;
import logica.procesadores.FabricaPistola;
import logica.procesadores.FabricaSniper;
import logica.recurso.Metal;

public class Sistema {
	private boolean juegoActivo;
	private Metal metal;
	private FabricaPistola fabPistola;
	private FabricaEscopeta fabEscopeta;
	private FabricaSniper fabSniper;
	
	
	public Sistema() {
		
		
		juegoActivo = true;
	}
	
	public Metal getMetal() {
		if(metal==null) {
			metal = Metal.getInstance();
		}
		return metal;
	}
	
	public FabricaPistola getFabricaPistola() {
		if(fabPistola==null) {
			fabPistola = new FabricaPistola();
			
		}
		return fabPistola;
	}

	public FabricaEscopeta getFabricaEscopeta() {
		if(fabEscopeta==null) {
			fabEscopeta = new FabricaEscopeta();
			
		}
		return fabEscopeta;
	}
	
	public FabricaSniper getFabricaSniper() {
		if(fabSniper==null) {
			fabSniper= new FabricaSniper();
		}
		return fabSniper;
	}

	public boolean isJuegoActivo() {
		return juegoActivo;
	}
	
	public void setJuegoActivo(boolean juegoActivo) {
		this.juegoActivo = juegoActivo;
	}
	
	
}
