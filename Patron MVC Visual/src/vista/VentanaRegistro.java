package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.PersonaVo;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField textCod;
	private JTextField textNombre;
	private JTextField textEdad;
	private JTextField textProfesion;
	private JTextField textTelefono;
	private Coordinador miCoordinador;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrarPersonas = new JLabel("Registrar personas");
		lblRegistrarPersonas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRegistrarPersonas.setBounds(134, 26, 150, 14);
		contentPane.add(lblRegistrarPersonas);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(26, 70, 46, 14);
		contentPane.add(lblCdigo);
		
		textCod = new JTextField();
		textCod.setBounds(102, 67, 86, 20);
		contentPane.add(textCod);
		textCod.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(26, 108, 46, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(102, 105, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(238, 108, 46, 14);
		contentPane.add(lblEdad);
		
		textEdad = new JTextField();
		textEdad.setBounds(308, 105, 86, 20);
		contentPane.add(textEdad);
		textEdad.setColumns(10);
		
		JLabel lblProfesin = new JLabel("Profesi\u00F3n:");
		lblProfesin.setBounds(26, 150, 61, 14);
		contentPane.add(lblProfesin);
		
		textProfesion = new JTextField();
		textProfesion.setBounds(102, 147, 86, 20);
		contentPane.add(textProfesion);
		textProfesion.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(238, 150, 46, 14);
		contentPane.add(lblTelfono);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(308, 147, 86, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PersonaVo miPersona=new PersonaVo();
					miPersona.setIdPersona(Integer.parseInt(textCod.getText()));
					miPersona.setNombrePersona(textNombre.getText());
					miPersona.setTelefonoPersona(Integer.parseInt(textTelefono.getText()));
					miPersona.setEdadPersona(Integer.parseInt(textEdad.getText()));
					miPersona.setProfesionPersona(textProfesion.getText());
					
					miCoordinador.registrarPersona(miPersona);	
					limpiar();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botonGuardar.setBounds(81, 206, 89, 23);
		contentPane.add(botonGuardar);
		
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();	
			}

			
		});
		botonCancelar.setBounds(265, 206, 89, 23);
		contentPane.add(botonCancelar);
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	private void limpiar() 
	{
		textCod.setText("");
		textNombre.setText("");
		textEdad.setText("");
		textTelefono.setText("");
		textProfesion.setText("");
	}
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
