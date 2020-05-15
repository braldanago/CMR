package logica.procesos;



public class Ensamble extends Thread implements IProceso{
	private int tiempoInicial;
	private int tiempoRestante;
	private boolean usarRecurso;
	private int quantum;
	private int envejecimiento;
	private int prioridad;
	private boolean sinTerminar;

	public Ensamble(int prioridad) {
		this.usarRecurso=false;//Indica que el proceso de ensamble NO usara el recurso que es el metal
		tiempoInicial = 7;
		this.tiempoRestante = this.tiempoInicial;
		envejecimiento=0;
		this.prioridad=prioridad;
		sinTerminar=true;
		this.quantum=4;
		//run();
	}
	
	@Override
	public String getNombreProceso() {
		return "Ensamble "+envejecimiento;
	}

	@Override
	public int getTiempoInicial() {
		return this.tiempoInicial;
	}

	@Override
	public void setTiempoInicial(int tiempoIni) {
		this.tiempoInicial=tiempoIni;
	}

	@Override
	public int getTiempoRestante() {
		return this.tiempoRestante;
	}

	@Override
	public void setTiempoRestante(int tiempoRest) {
		this.tiempoRestante= tiempoRest;
		
	}

	@Override
	public boolean getUsarRecurso() {
		return this.usarRecurso;
	}

	@Override
	public int getQuantum() {
		return this.quantum;
	}

	@Override
	public void setQuantum(int valor) {
		this.quantum=valor;
	}
	
	@Override
	public int getEnvejecimiento() {
		return this.envejecimiento;
	}

	@Override
	public void setEnvejecimiento(int valor) {
		this.envejecimiento = valor;
	}

	@Override
	public int getPrioridad() {
		return prioridad;
	}

	@Override
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	@Override
	public boolean isSinTerminar() {
		return sinTerminar;
	}
	@Override
	public void setSinTerminar(boolean sinTerminar) {
		this.sinTerminar = sinTerminar;
	}

	@Override
    public void run(){
		while(sinTerminar) {
			espera(1000);
			envejecimiento = envejecimiento+1;
		}
	}

	private void espera(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
        	
        }
    }
	
}
