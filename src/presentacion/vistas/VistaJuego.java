package presentacion.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import presentacion.Controlador;
import presentacion.Modelo;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;

import java.awt.Color;
import javax.swing.ImageIcon;


import java.awt.List;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class VistaJuego extends JFrame {

	private JPanel contentPane;
	private Modelo modelo;
	private Controlador controlador;
	
	
	JLabel lblMetal;
	JLabel lblTitulo;
	JLabel lblFondo; 
	
	JLabel lblTiempoJuego;
	
	JLabel lblFabricaPistola;
	
	JLabel lblValorTiempoEjecucionPistola;
	JLabel lblValorQuantumPistola;
	JLabel lblNomProcesoPistola;
	List colaListoPistolas;
	List colaSuspendidoPistola;
	List colaBloqueadoPistola;
	List colaTerminadoPistola;
	
	JLabel lblValorTiempoEjecucionEscopeta;
	JLabel lblValorQuantumEscopeta;
	JLabel lblNomProcesoEscopeta;
	List colaListoEscopetas;
	List colaSuspendidoEscopeta;
	List colaBloqueadoEscopeta;
	List colaTerminadoEscopeta;
	
	JButton btnInsertarProcesoPistolaRR;
	JButton btnInsertarProcesoPistolaSRTF;
	JButton btnInsertarProcesoPistolaFIFO;
	
	
	JButton btnInsertarProcesoEscopeta;
	
	List colaListosFIFO;
	List colaListosSRTFPistol;
	
	private JLabel lblAvisar1;
	private JLabel lblAvisar2;
	private List colaListoSRTFEscopeta;
	private JLabel lblListoSrtf;
	private JButton btnK;
	private List colaListoFIFOEscopeta;
	private JLabel lblListoFifo_1;
	private JButton btnL;
	
	
	public VistaJuego(Modelo modelo) {
		setAutoRequestFocus(false);
		setResizable(false);
		setAlwaysOnTop(true);
		//setLocation(0, 0);
		setTitle("Round Robin");
		this.modelo=modelo;
		initComponents();
		capturarEventos();
		
	}
	
	
	public void initComponents() {
		setBounds(400, 500, 1206, 740);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		esperar(20);
		lblTitulo = new JLabel("GUN RACE");
		lblTitulo.setFont(new Font("Old English Text MT", Font.BOLD, 36));
		lblTitulo.setBounds(477, 23, 238, 32);
		contentPane.add(lblTitulo);
		
		esperar(20);
		lblMetal = new JLabel("New label");
		lblMetal.setIcon(new ImageIcon(VistaJuego.class.getResource("/imagenes/recurso/MetalDisponible.png")));
		lblMetal.setBounds(502, 42, 194, 194);
		contentPane.add(lblMetal);

		esperar(20);
		lblFabricaPistola = new JLabel("");
		lblFabricaPistola.setIcon(new ImageIcon(VistaJuego.class.getResource("/imagenes/Fabricas/FabricaPistola.png")));
		lblFabricaPistola.setBounds(150, 236, 260, 170);
		contentPane.add(lblFabricaPistola);
		
		esperar(20);
		JLabel lblTituloFabricaPistola = new JLabel("PISTOLAS");
		lblTituloFabricaPistola.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		lblTituloFabricaPistola.setBounds(240, 222, 89, 14);
		contentPane.add(lblTituloFabricaPistola);
		
		esperar(20);
		JLabel lblSeccionCriticaPistola = new JLabel("Seccion critica.");
		lblSeccionCriticaPistola.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSeccionCriticaPistola.setBounds(240, 402, 89, 14);
		contentPane.add(lblSeccionCriticaPistola);
		
		esperar(20);
		JLabel lblProcesoPistolas = new JLabel("Proceso:");
		lblProcesoPistolas.setBounds(237, 428, 74, 14);
		contentPane.add(lblProcesoPistolas);
		
		esperar(20);
		lblNomProcesoPistola = new JLabel("New label");
		lblNomProcesoPistola.setBounds(321, 428, 89, 14);
		contentPane.add(lblNomProcesoPistola);
		
		esperar(20);
		JLabel lblTiempoEjecucionPistola = new JLabel("Tiempo ejecucion:");
		lblTiempoEjecucionPistola.setBounds(237, 453, 117, 14);
		contentPane.add(lblTiempoEjecucionPistola);
		
		esperar(20);
		lblValorTiempoEjecucionPistola = new JLabel("New label");
		lblValorTiempoEjecucionPistola.setBounds(364, 453, 46, 14);
		contentPane.add(lblValorTiempoEjecucionPistola);
		
		esperar(20);
		JLabel lblQuantumPistola = new JLabel("Quantum:");
		lblQuantumPistola.setBounds(237, 478, 76, 14);
		contentPane.add(lblQuantumPistola);
		
		esperar(20);
		lblValorQuantumPistola = new JLabel("New label");
		lblValorQuantumPistola.setBounds(364, 478, 46, 14);
		contentPane.add(lblValorQuantumPistola);
		
		esperar(20);
		JLabel lblListoPistola = new JLabel("Listo RR");
		lblListoPistola.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblListoPistola.setBounds(160, 510, 46, 14);
		contentPane.add(lblListoPistola);
		
		esperar(20);
		JLabel lblSuspendidoPistola = new JLabel("Suspendido");
		lblSuspendidoPistola.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSuspendidoPistola.setBounds(423, 222, 72, 14);
		contentPane.add(lblSuspendidoPistola);
		
		esperar(20);
		JLabel lblBloqueadoPistola = new JLabel("Bloqueado");
		lblBloqueadoPistola.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBloqueadoPistola.setBounds(427, 371, 65, 14);
		contentPane.add(lblBloqueadoPistola);
		
		esperar(20);
		JLabel lblTerminadoPistola = new JLabel("Terminado");
		lblTerminadoPistola.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTerminadoPistola.setBounds(410, 511, 63, 14);
		contentPane.add(lblTerminadoPistola);
		
		esperar(20);
		colaListoPistolas = new List();
		colaListoPistolas.setForeground(new Color(0, 128, 0));
		colaListoPistolas.setFont(new Font("Agency FB", Font.PLAIN, 9));
		colaListoPistolas.setBounds(142, 530, 80, 102);
		contentPane.add(colaListoPistolas);
		
		esperar(20);
		colaSuspendidoPistola = new List();
		colaSuspendidoPistola.setForeground(Color.BLUE);
		colaSuspendidoPistola.setFont(new Font("Agency FB", Font.PLAIN, 9));
		colaSuspendidoPistola.setBounds(416, 242, 80, 102);
		contentPane.add(colaSuspendidoPistola);
		
		esperar(20);
		colaBloqueadoPistola = new List();
		colaBloqueadoPistola.setForeground(Color.RED);
		colaBloqueadoPistola.setFont(new Font("Agency FB", Font.PLAIN, 9));
		colaBloqueadoPistola.setBounds(416, 390, 80, 102);
		contentPane.add(colaBloqueadoPistola);
		
		esperar(20);
		colaTerminadoPistola = new List();
		colaTerminadoPistola.setFont(new Font("Agency FB", Font.PLAIN, 9));
		colaTerminadoPistola.setBounds(400, 530, 80, 102);
		contentPane.add(colaTerminadoPistola);
	
		//ELEMENTOS DE ESCOPETA
		esperar(20);
		JLabel lblFabricaEscopeta = new JLabel("");
		lblFabricaEscopeta.setIcon(new ImageIcon(VistaJuego.class.getResource("/imagenes/Fabricas/FabricaEscopeta.png")));
		lblFabricaEscopeta.setBounds(714, 234, 260, 170);
		contentPane.add(lblFabricaEscopeta);
		
		esperar(20);
		JLabel lblTituloFabricaEscopeta = new JLabel("ESCOPETAS");
		lblTituloFabricaEscopeta.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		lblTituloFabricaEscopeta.setBounds(779, 222, 117, 14);
		contentPane.add(lblTituloFabricaEscopeta);
		
		esperar(20);
		JLabel label = new JLabel("Seccion critica.");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(797, 400, 89, 14);
		contentPane.add(label);
		
		esperar(20);
		JLabel label_1 = new JLabel("Proceso:");
		label_1.setBounds(794, 426, 74, 14);
		contentPane.add(label_1);
		
		esperar(20);
		lblNomProcesoEscopeta = new JLabel("New label");
		lblNomProcesoEscopeta.setBounds(878, 426, 89, 14);
		contentPane.add(lblNomProcesoEscopeta);
		
		esperar(20);
		JLabel label_3 = new JLabel("Tiempo ejecucion:");
		label_3.setBounds(794, 451, 117, 14);
		contentPane.add(label_3);
		
		esperar(20);
		lblValorTiempoEjecucionEscopeta = new JLabel("New label");
		lblValorTiempoEjecucionEscopeta.setBounds(921, 451, 46, 14);
		contentPane.add(lblValorTiempoEjecucionEscopeta);
		
		esperar(20);
		JLabel label_5 = new JLabel("Quantum:");
		label_5.setBounds(794, 476, 76, 14);
		contentPane.add(label_5);
		
		esperar(20);
		lblValorQuantumEscopeta = new JLabel("New label");
		lblValorQuantumEscopeta.setBounds(921, 476, 46, 14);
		contentPane.add(lblValorQuantumEscopeta);
		
		esperar(20);
		JLabel label_2 = new JLabel("Listo");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(720, 510, 46, 14);
		contentPane.add(label_2);
		
		esperar(20);
		JLabel label_4 = new JLabel("Suspendido");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(988, 222, 72, 14);
		contentPane.add(label_4);
		
		esperar(20);
		JLabel label_6 = new JLabel("Bloqueado");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_6.setBounds(992, 369, 65, 14);
		contentPane.add(label_6);
		
		esperar(20);
		JLabel label_7 = new JLabel("Terminado");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_7.setBounds(958, 511, 63, 14);
		contentPane.add(label_7);
		
		esperar(20);
		colaListoEscopetas = new List();
		colaListoEscopetas.setForeground(new Color(0, 128, 0));
		colaListoEscopetas.setFont(new Font("Agency FB", Font.PLAIN, 9));
		colaListoEscopetas.setBounds(690, 530, 80, 102);
		contentPane.add(colaListoEscopetas);
		
		esperar(20);
		colaSuspendidoEscopeta = new List();
		colaSuspendidoEscopeta.setForeground(new Color(0, 0, 255));
		colaSuspendidoEscopeta.setFont(new Font("Agency FB", Font.PLAIN, 9));
		colaSuspendidoEscopeta.setBounds(981, 242, 80, 102);
		contentPane.add(colaSuspendidoEscopeta);
		
		esperar(20);
		colaBloqueadoEscopeta = new List();
		colaBloqueadoEscopeta.setForeground(new Color(255, 0, 0));
		colaBloqueadoEscopeta.setFont(new Font("Agency FB", Font.PLAIN, 9));
		colaBloqueadoEscopeta.setBounds(981, 388, 80, 102);
		contentPane.add(colaBloqueadoEscopeta);
		
		esperar(20);
		colaTerminadoEscopeta = new List();
		colaTerminadoEscopeta.setFont(new Font("Agency FB", Font.PLAIN, 9));
		colaTerminadoEscopeta.setBounds(953, 530, 80, 102);
		contentPane.add(colaTerminadoEscopeta);
		
		
		
		
		///////*INSERCION DE PROCESOS*//////////////////
		esperar(20);
		btnInsertarProcesoPistolaRR = new JButton("A");
		btnInsertarProcesoPistolaRR.setBounds(142, 638, 80, 32);
		contentPane.add(btnInsertarProcesoPistolaRR);
		
		esperar(20);
		btnInsertarProcesoEscopeta = new JButton("J");
		btnInsertarProcesoEscopeta.setBounds(690, 638, 80, 32);
		contentPane.add(btnInsertarProcesoEscopeta);
		
		esperar(20);
		
		colaListosSRTFPistol = new List();
		colaListosSRTFPistol.setForeground(new Color(0, 128, 0));
		colaListosSRTFPistol.setFont(new Font("Agency FB", Font.PLAIN, 9));
		colaListosSRTFPistol.setBounds(228, 530, 80, 102);
		contentPane.add(colaListosSRTFPistol);
		
		JLabel lblTiempo = new JLabel("TIEMPO");
		lblTiempo.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		lblTiempo.setBounds(953, 39, 89, 14);
		contentPane.add(lblTiempo);
		
		esperar(20);
		lblTiempoJuego = new JLabel("0");
		lblTiempoJuego.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTiempoJuego.setBounds(970, 53, 58, 49);
		contentPane.add(lblTiempoJuego);
		
		esperar(20);
		
		colaListosFIFO = new List();
		colaListosFIFO.setForeground(new Color(0, 128, 0));
		colaListosFIFO.setFont(new Font("Agency FB", Font.PLAIN, 9));
		colaListosFIFO.setBounds(314, 530, 80, 102);
		contentPane.add(colaListosFIFO);
		
		JLabel lblListoSrft = new JLabel("Listo srft");
		lblListoSrft.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblListoSrft.setBounds(240, 510, 64, 14);
		contentPane.add(lblListoSrft);
		
		JLabel lblListoFifo = new JLabel("Listo fifo");
		lblListoFifo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblListoFifo.setBounds(329, 510, 65, 14);
		contentPane.add(lblListoFifo);
		
		btnInsertarProcesoPistolaSRTF = new JButton("S");
		btnInsertarProcesoPistolaSRTF.setBounds(228, 638, 80, 32);
		contentPane.add(btnInsertarProcesoPistolaSRTF);
		
		btnInsertarProcesoPistolaFIFO = new JButton("D");
		btnInsertarProcesoPistolaFIFO.setBounds(314, 638, 80, 32);
		contentPane.add(btnInsertarProcesoPistolaFIFO);
		
		lblAvisar1 = new JLabel("JUEGO");
		lblAvisar1.setForeground(new Color(255, 0, 0));
		lblAvisar1.setFont(new Font("Stencil", Font.PLAIN, 57));
		lblAvisar1.setBounds(174, 109, 227, 102);
		lblAvisar1.setVisible(false);
		contentPane.add(lblAvisar1);
		
		lblAvisar2 = new JLabel("TERMINADO");
		lblAvisar2.setForeground(Color.RED);
		lblAvisar2.setFont(new Font("Stencil", Font.PLAIN, 57));
		lblAvisar2.setBounds(755, 109, 375, 102);
		lblAvisar2.setVisible(false);
		contentPane.add(lblAvisar2);
		
		colaListoSRTFEscopeta = new List();
		colaListoSRTFEscopeta.setForeground(new Color(0, 128, 0));
		colaListoSRTFEscopeta.setFont(new Font("Agency FB", Font.PLAIN, 9));
		colaListoSRTFEscopeta.setBounds(779, 530, 80, 102);
		contentPane.add(colaListoSRTFEscopeta);
		
		lblListoSrtf = new JLabel("Listo SRTF");
		lblListoSrtf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblListoSrtf.setBounds(791, 510, 64, 14);
		contentPane.add(lblListoSrtf);
		
		btnK = new JButton("K");
		btnK.setBounds(779, 638, 80, 32);
		contentPane.add(btnK);
		
		colaListoFIFOEscopeta = new List();
		colaListoFIFOEscopeta.setForeground(new Color(0, 128, 0));
		colaListoFIFOEscopeta.setFont(new Font("Agency FB", Font.PLAIN, 9));
		colaListoFIFOEscopeta.setBounds(865, 530, 80, 102);
		contentPane.add(colaListoFIFOEscopeta);
		
		lblListoFifo_1 = new JLabel("Listo FIFO");
		lblListoFifo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblListoFifo_1.setBounds(877, 510, 64, 14);
		contentPane.add(lblListoFifo_1);
		
		btnL = new JButton("L");
		btnL.setBounds(865, 638, 80, 32);
		contentPane.add(btnL);
		
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VistaJuego.class.getResource("/imagenes/mapa.png")));
		lblFondo.setBounds(0, 0, 1200, 701);
		contentPane.add(lblFondo);

		this.setVisible(true);
		
	}
	
    public Modelo getModelo() {
        return modelo;
    }
    
    public Controlador getControlador() {
    	if(controlador==null) {
    		controlador = new Controlador(this);
    	}
    	return controlador;
    }
    
    /*
     * Cambia una imagen segun el estado del recurso metalico
     */
    public void cambiarEstadoMetal(String texto) {
    	lblMetal.setIcon(new ImageIcon(VistaJuego.class.getResource(texto)));
    }
    
    
    
    //////////////////*METODOS PISTOLA*///////////////////////////////
    /*
     * Cambia el nombre del proceso que esta en la seccion critica de la fabrica de pistola
     */
    public void cambiarProcesoPistola(String nombre) {
    	lblNomProcesoPistola.setText(nombre);
    }
    
    /*
     * Cambia el quantum del proceso que esta en la seccion critica de la fabrica de pistola
     */
    public void cambiarQuantumPistola(int valor) {
    	lblValorQuantumPistola.setText(""+valor);
    }
    
    /*
     * Cambia el tiempo restante del proceso que esta en la seccion critica de la fabrica de pistola
     */
    public void cambiarTiempoRestantePistola(int valor) {
    	lblValorTiempoEjecucionPistola.setText(""+valor);
    }
    
    /*
     * Recibe arreglo de valores para llenar la "cola" de listos en pistola
     */
	public void llenarListosPistola(ArrayList<String> listos) {
    	String valor = null;
    	int i = 0;
    	colaListoPistolas.removeAll();
    	while(listos.size()>i) {
    		valor = listos.get(i);
    		colaListoPistolas.add(valor);
    		i++;
    	}
    }
	/*
     * Recibe arreglo de valores para llenar la "cola" de suspendidos en pistola
     */
	public void llenarSuspendidosPistola(ArrayList<String> susp) {
    	String valor = null;
    	int i = 0;
    	colaSuspendidoPistola.removeAll();
    	while(susp.size()>i) {
    		valor = susp.get(i);
    		colaSuspendidoPistola.add(valor);
    		i++;
    	}
    }
    
	/*
     * Recibe arreglo de valores para llenar la "cola" de bloqueados en pistola
     */
	public void llenarBloqueadosPistola(ArrayList<String> bloq) {
    	String valor = null;
    	int i = 0;
    	colaBloqueadoPistola.removeAll();
    	while(bloq.size()>i) {
    		valor = bloq.get(i);
    		colaBloqueadoPistola.add(valor);
    		i++;
    	}
    }
    
	/*
     * Recibe arreglo de valores para llenar la "cola" de terminados en pistola
     */
	public void llenarTerminadosPistola(ArrayList<String> ter) {
    	String valor = null;
    	int i = 0;
    	colaTerminadoPistola.removeAll();
    	while(ter.size()>i) {
    		valor = ter.get(i);
    		colaTerminadoPistola.add(valor);
    		i++;
    	}
    }
    
	public void llenarListosFIFO(ArrayList<String> ter) {
    	String valor = null;
    	int i = 0;
    	colaListosFIFO.removeAll();
    	while(ter.size()>i) {
    		valor = ter.get(i);
    		colaListosFIFO.add(valor);
    		i++;
    	}
    }
	
	public void llenarListosSRTF(ArrayList<String> ter) {
    	String valor = null;
    	int i = 0;
    	colaListosSRTFPistol.removeAll();
    	while(ter.size()>i) {
    		valor = ter.get(i);
    		colaListosSRTFPistol.add(valor);
    		i++;
    	}
    }
	
	////////////////////////////////  *METODOS ESCOPETA*  ////////////////////////////////////////
    /*
     * Cambia el nombre del proceso que esta en la seccion critica de la fabrica de Escopeta
     */
    public void cambiarProcesoEscopeta(String nombre) {
    	lblNomProcesoEscopeta.setText(nombre);
    }
    
    /*
     * Cambia el quantum del proceso que esta en la seccion critica de la fabrica de Escopeta
     */
    public void cambiarQuantumEscopeta(int valor) {
    	lblValorQuantumEscopeta.setText(""+valor);
    }
    
    /*
     * Cambia el tiempo restante del proceso que esta en la seccion critica de la fabrica de Escopeta
     */
    public void cambiarTiempoRestanteEscopeta(int valor) {
    	lblValorTiempoEjecucionEscopeta.setText(""+valor);
    }
    
    /*
     * Recibe arreglo de valores para llenar la "cola" de listos en Escopeta
     */
	public void llenarListosEscopeta(ArrayList<String> listos) {
    	String valor = null;
    	int i = 0;
    	colaListoEscopetas.removeAll();
    	while(listos.size()>i) {
    		valor = listos.get(i);
    		colaListoEscopetas.add(valor);
    		i++;
    	}
    }
	
	public void llenarListosSRTFEscopeta(ArrayList<String> listos) {
    	String valor = null;
    	int i = 0;
    	colaListoSRTFEscopeta.removeAll();
    	while(listos.size()>i) {
    		valor = listos.get(i);
    		colaListoSRTFEscopeta.add(valor);
    		i++;
    	}
    }
	
	public void llenarListosFIFOEscopeta(ArrayList<String> listos) {
    	String valor = null;
    	int i = 0;
    	colaListoFIFOEscopeta.removeAll();
    	while(listos.size()>i) {
    		valor = listos.get(i);
    		colaListoFIFOEscopeta.add(valor);
    		i++;
    	}
    }
	
	/*
     * Recibe arreglo de valores para llenar la "cola" de suspendidos en Escopeta
     */
	public void llenarSuspendidosEscopeta(ArrayList<String> susp) {
    	String valor = null;
    	int i = 0;
    	colaSuspendidoEscopeta.removeAll();
    	while(susp.size()>i) {
    		valor = susp.get(i);
    		colaSuspendidoEscopeta.add(valor);
    		i++;
    	}
    }
    
	/*
     * Recibe arreglo de valores para llenar la "cola" de bloqueados en VEscopeta
     */
	public void llenarBloqueadosEscopeta(ArrayList<String> bloq) {
    	String valor = null;
    	int i = 0;
    	colaBloqueadoEscopeta.removeAll();
    	while(bloq.size()>i) {
    		valor = bloq.get(i);
    		colaBloqueadoEscopeta.add(valor);
    		i++;
    	}
    }
    
	/*
     * Recibe arreglo de valores para llenar la "cola" de terminados en Escopeta
     */
	public void llenarTerminadosEscopeta(ArrayList<String> ter) {
    	String valor = null;
    	int i = 0;
    	colaTerminadoEscopeta.removeAll();
    	while(ter.size()>i) {
    		valor = ter.get(i);
    		colaTerminadoEscopeta.add(valor);
    		i++;
    	}
    }
	
	
	
	public void cambiarTiempoJuego(int valor) {
		lblTiempoJuego.setText(""+valor);
	}
	
    /*
     * Captura de eventos del mouse en la vista
     */
    private void capturarEventos() {
    	colaListoPistolas.addKeyListener(getControlador());
    }
    
    public void avisarFin() {
    	lblAvisar1.setVisible(true);
    	lblAvisar2.setVisible(true);
    }
    
    private void esperar(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
        }
    }
}
