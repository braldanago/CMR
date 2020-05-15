package logica.recurso;

public class Metal {
	private static Metal instancia = new Metal();
	private boolean estaDisponible;
	
	private Metal() {
		this.estaDisponible=true;
	}
	
	
	/**
	 * @return instancia unica del metal (singleton)
	 */
	public static Metal getInstance() {
		return instancia;
	}
	
	
	/**
	 * @return the estaDisponible
	 */
	public boolean isEstaDisponible() {
		return estaDisponible;
	}
	
	
	/**
	 * @param estaDisponible the estaDisponible to set
	 */
	public void setEstaDisponible(boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}
	
	
	public String getImgOcupado() {
		return "/imagenes/recurso/MetalBloqueado.png";
	}
	
	
	public String getImgDisponible() {
		return "/imagenes/recurso/MetalDisponible.png";
	}
	

}
