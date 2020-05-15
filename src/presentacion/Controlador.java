package presentacion;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import presentacion.vistas.VistaJuego;

public class Controlador implements KeyListener {
	private final VistaJuego ventana;
	//private JButton boton;
	
	
	
	public Controlador(VistaJuego window){
		ventana = window;
	}
	/*
	@Override
	public void mouseClicked(MouseEvent arg0) {

		boton =(JButton) arg0.getSource(); 
		if(boton == ventana.getBtnInsertarProcesoPistola()) {
			ventana.getModelo().getSistema().getFabricaPistola().llenarEnCaliente();
		}else if(boton == ventana.getBtnInsertarProcesoEscopeta()) {
			ventana.getModelo().getSistema().getFabricaEscopeta().llenarEnCaliente();
		}else if(boton == ventana.getBtnInsertarProcesoSniper()) {
			ventana.getModelo().getSistema().getFabricaSniper().llenarEnCaliente();
		}

	}*/

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_A) {
			ventana.getModelo().getSistema().getFabricaPistola().llenarEnCalienteRR();
		}else if (e.getKeyCode()==KeyEvent.VK_S) {
			ventana.getModelo().getSistema().getFabricaPistola().llenarEnCalienteSRTF();
		}else if (e.getKeyCode()==KeyEvent.VK_D) {
			ventana.getModelo().getSistema().getFabricaPistola().llenarEnCalienteFIFO();
		}else if(e.getKeyCode()==KeyEvent.VK_J) {
			ventana.getModelo().getSistema().getFabricaEscopeta().llenarEnCalienteRR();
		}else if(e.getKeyCode()==KeyEvent.VK_K) {
			ventana.getModelo().getSistema().getFabricaEscopeta().llenarEnCalienteSRTF();
		}else if(e.getKeyCode()==KeyEvent.VK_L) {
			ventana.getModelo().getSistema().getFabricaEscopeta().llenarEnCalienteFIFO();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {

	}

}
