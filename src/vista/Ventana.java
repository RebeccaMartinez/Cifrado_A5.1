package vista;
import logica.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class Ventana extends JFrame implements ActionListener {

	//MARGENES PANEL
	
	private static final int TOP = 20;
	private static final int BOT = 20;
	private static final int LEFT = 10;
	private static final int RIGHT = 10;
	
	private static final int HGAP = 10;	//separación horizontal
	private static final int VGAP = 10;	//separación vertical
	
	private static final int ANCHO_REG = 150;
	private static final int ALTO_REG = 20;
	
	private static final int ALTO = 500;
	private static final int ANCHO = 400;
	
	private static final String CIFRAR = "cifrar";

	//COMPONENTES
	private JButton btnCifrar;
	private JTextField tfR1;
	private JTextField tfR2;
	private JTextField tfR3;
	private JTextField tfR4;
	private JTextArea taMensaje;
	private JTextArea taRespuesta;
	
	public Ventana() {
		
		setLayout(new BorderLayout());
		setSize(ANCHO, ALTO);
		setTitle("Cifrado A5/1");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		inicializarPanelSuperior();
		inicializarPanelCentral();
		inicializarPanelInferior();
	}
	
	private void inicializarPanelSuperior(){
	
	JPanel panRegistros = new JPanel();
	panRegistros.setLayout(new GridLayout(4, 1, HGAP, VGAP));
	panRegistros.setBorder(BorderFactory.createEmptyBorder(TOP, LEFT, BOT, RIGHT));
	
	//Panel R1
	JPanel panR1 = new JPanel ();
	panR1.setBorder(BorderFactory.createEmptyBorder(TOP, 0, 0, 0));	
	
	JLabel lblR1 = new JLabel ("R1:");
	panR1.add(lblR1);
	
	JTextField tfR1 = new JTextField();
	tfR1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	tfR1.setPreferredSize(new Dimension(ANCHO_REG, ALTO_REG));
	panR1.add(tfR1);
	setTfR1(tfR1);
	
	//Panel R2
	JPanel panR2 = new JPanel ();
	panR2.setBorder(BorderFactory.createEmptyBorder(TOP, 0, 0, 0));	
	
	JLabel lblR2 = new JLabel ("R2:");
	panR2.add(lblR2);
	
	JTextField tfR2 = new JTextField();
	tfR2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	tfR2.setPreferredSize(new Dimension(ANCHO_REG, ALTO_REG));
	panR2.add(tfR2);
	setTfR2(tfR2);

	//Panel R3
	JPanel panR3 = new JPanel ();
	panR3.setBorder(BorderFactory.createEmptyBorder(TOP, 0, 0, 0));	

	JLabel lblR3 = new JLabel ("R3:");
	panR3.add(lblR3);
	
	JTextField tfR3 = new JTextField();
	tfR3.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	tfR3.setPreferredSize(new Dimension(ANCHO_REG, ALTO_REG));
	panR3.add(tfR3);
	setTfR3(tfR3);

	
	//Panel 4
	JPanel panR4 = new JPanel ();
	panR4.setBorder(BorderFactory.createEmptyBorder(TOP, 0, 0, 0));	

	JLabel lblR4 = new JLabel ("Tam:");
	panR4.add(lblR4);
	
	JTextField tfR4 = new JTextField();
	tfR4.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	tfR4.setPreferredSize(new Dimension(ANCHO_REG, ALTO_REG));
	panR4.add(tfR4);
	setTfR4(tfR4);

	panRegistros.add(panR1);
	panRegistros.add(panR2);
	panRegistros.add(panR3);
	panRegistros.add(panR4);


	add(panRegistros, BorderLayout.NORTH);
	}

	private void inicializarPanelCentral(){
		
		JPanel panTextos = new JPanel();
		panTextos.setLayout(new GridLayout(1, 1, HGAP, VGAP));
		panTextos.setBorder(BorderFactory.createEmptyBorder(TOP, LEFT, BOT, RIGHT));
				
		JTextArea taRespuesta = new JTextArea (30,10);
		taRespuesta.setLineWrap(true);
		taRespuesta.setWrapStyleWord(true);
		taRespuesta.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		taRespuesta.setEnabled(false); //desactiva el textarea
		Color c = getBackground();
		taRespuesta.setBackground(c);
		taRespuesta.setDisabledTextColor(Color.black);
		setTaRespuesta(taRespuesta);
		panTextos.add(taRespuesta);

		
		JScrollPane scrollPane = new JScrollPane(taRespuesta); 
		panTextos.add(scrollPane, BorderLayout.CENTER);
		
		add(panTextos);
	}
	
	private void inicializarPanelInferior(){
		
		JPanel panBotones = new JPanel();
		add(panBotones, BorderLayout.SOUTH);
		panBotones.setBorder(BorderFactory.createEmptyBorder(0, 0, BOT, 0));

		JButton bCifrar = new JButton("Cifrar");
		bCifrar.addActionListener(this);
		bCifrar.setActionCommand(CIFRAR);
		panBotones.add(bCifrar);
		setBtnCifrar(bCifrar);
	}
	
	private void cifrar(){

		getTaRespuesta().setText(Cifrador.cifrar(tfR1.getText(), tfR2.getText(), tfR3.getText(), tfR4.getText()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		String x = e.getActionCommand();
		if (x == CIFRAR)
			cifrar();
	}
	
	public static void main(String[] args) {
		Ventana miVentana;
		miVentana = new Ventana();
		miVentana.setVisible(true);
	}

//Getters y Setters
	public JButton getBtnCifrar() {
		return btnCifrar;
	}

	public void setBtnCifrar(JButton btnCifrar) {
		this.btnCifrar = btnCifrar;
	}

	public JTextArea getTaMensaje() {
		return taMensaje;
	}

	public void setTaMensaje(JTextArea taMensaje) {
		this.taMensaje = taMensaje;
	}

	public JTextArea getTaRespuesta() {
		return taRespuesta;
	}

	public void setTaRespuesta(JTextArea taRespuesta) {
		this.taRespuesta = taRespuesta;
	}

	public JTextField getTfR1() {
		return tfR1;
	}

	public void setTfR1(JTextField tfR1) {
		this.tfR1 = tfR1;
	}

	public JTextField getTfR2() {
		return tfR2;
	}

	public void setTfR2(JTextField tfR2) {
		this.tfR2 = tfR2;
	}


	public JTextField getTfR3() {
		return tfR3;
	}

	public void setTfR3(JTextField tfR3) {
		this.tfR3 = tfR3;
	}

	public JTextField getTfR4() {
		return tfR4;
	}

	public void setTfR4(JTextField tfR4) {
		this.tfR4 = tfR4;
	}
}
