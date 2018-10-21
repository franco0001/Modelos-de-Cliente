package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaPrincipal extends JFrame {
 
	private JPanel contentPane;
	//agregue
	private Coordinador miCoordinador;
	public String textoIntroduccion="Esta aplicación presenta un ejemplo práctico del patron "
			+ "de diseño MVC.\n\n"
			+ "La aplicación permite registrar, actualizar, buscar y eliminar registros de una tabla Persona." +
			"tambien son vinculados algunos conceptos de los Patrones Value Object y Data Access Objetc\n";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonRegistrar = new JButton("Registrar");
		botonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miCoordinador.mostrarVentanaRegistro();
			}
		});
		botonRegistrar.setBounds(76, 228, 89, 23);
		contentPane.add(botonRegistrar);
		
		JButton botonBuscar = new JButton("Buscar");
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				miCoordinador.mostrarVentanaConsulta();
			}
		});
		botonBuscar.setBounds(277, 228, 89, 23);
		contentPane.add(botonBuscar);
		
		JTextArea areaIntroduccion = new JTextArea();
		areaIntroduccion.setBounds(76, 44, 290, 126);
		areaIntroduccion.setText(textoIntroduccion);
		contentPane.add(areaIntroduccion);
		
		JLabel lblElijaLaoperacinHa = new JLabel("Elija la operaci\u00F3n ha realizar");
		lblElijaLaoperacinHa.setBounds(76, 183, 232, 14);
		contentPane.add(lblElijaLaoperacinHa);
		
		JLabel lblPatrnModeloVista = new JLabel("Patr\u00F3n Modelo Vista Controlador");
		lblPatrnModeloVista.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPatrnModeloVista.setBounds(75, 11, 211, 14);
		contentPane.add(lblPatrnModeloVista);
	}
	
	public void setCoordinador(Coordinador miCoordinador){
		this.miCoordinador=miCoordinador;
	}
}
