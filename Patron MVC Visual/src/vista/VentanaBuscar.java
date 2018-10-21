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
import modelo.Logica;
import modelo.PersonaVo;

public class VentanaBuscar extends JFrame {

	private JPanel contentPane;
	private JTextField textCod;
	private JTextField textNombre;
	private JTextField textEdad;
	private JTextField textProfesion;
	private JTextField textTelefono;
	private Coordinador miCoordinador;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBuscar frame = new VentanaBuscar();
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
	public VentanaBuscar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 434, 262);
		contentPane.add(panel);
		
		JLabel lblBuscarPersonas = new JLabel("Buscar personas");
		lblBuscarPersonas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuscarPersonas.setBounds(134, 26, 150, 14);
		panel.add(lblBuscarPersonas);
		
		JLabel label_1 = new JLabel("C\u00F3digo:");
		label_1.setBounds(26, 70, 46, 14);
		panel.add(label_1);
		
		textCod = new JTextField();
		textCod.setColumns(10);
		textCod.setBounds(102, 67, 86, 20);
		panel.add(textCod);
		
		JLabel label_2 = new JLabel("Nombre:");
		label_2.setBounds(26, 108, 46, 14);
		panel.add(label_2);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(102, 105, 86, 20);
		panel.add(textNombre);
		
		JLabel label_3 = new JLabel("Edad:");
		label_3.setBounds(238, 108, 46, 14);
		panel.add(label_3);
		
		textEdad = new JTextField();
		textEdad.setColumns(10);
		textEdad.setBounds(308, 105, 86, 20);
		panel.add(textEdad);
		
		JLabel label_4 = new JLabel("Profesi\u00F3n:");
		label_4.setBounds(26, 150, 61, 14);
		panel.add(label_4);
		
		textProfesion = new JTextField();
		textProfesion.setColumns(10);
		textProfesion.setBounds(102, 147, 86, 20);
		panel.add(textProfesion);
		
		JLabel label_5 = new JLabel("Tel\u00E9fono:");
		label_5.setBounds(238, 150, 46, 14);
		panel.add(label_5);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(308, 147, 86, 20);
		panel.add(textTelefono);
		
		botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PersonaVo miPersona=new PersonaVo();
					miPersona.setIdPersona(Integer.parseInt(textCod.getText()));
					miPersona.setNombrePersona(textNombre.getText());
					miPersona.setTelefonoPersona(Integer.parseInt(textTelefono.getText()));
					miPersona.setEdadPersona(Integer.parseInt(textEdad.getText()));
					miPersona.setProfesionPersona(textProfesion.getText());

					miCoordinador.modificarPersona(miPersona);
					
					if (Logica.modificaPersona==true) {
						habilita(true, false, false, false, false, true, false, true, true);	
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botonGuardar.setBounds(37, 193, 89, 23);
		panel.add(botonGuardar);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				volver();
			}

			
		});
		botonCancelar.setBounds(153, 227, 89, 23);
		panel.add(botonCancelar);
		
		botonBuscar = new JButton("OK");
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonaVo miPersona=miCoordinador.buscarPersona(textCod.getText());
				if (miPersona!=null)
				{
					muestraPersona(miPersona);
				}
				else if(Logica.consultaPersona==true){
					JOptionPane.showMessageDialog(null, "La persona no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		botonBuscar.setBounds(195, 66, 47, 23);
		panel.add(botonBuscar);
		
		botonModificar = new JButton("Modificar");
		botonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilita(false, true, true, true, true, false, true, false, false);
			}
		});
		botonModificar.setBounds(153, 193, 89, 23);
		panel.add(botonModificar);
		
		botonEliminar = new JButton("Eliminar");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textCod.getText().equals(""))
				{
					int respuesta=JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar la Persona?", "Confirmación", JOptionPane.YES_NO_OPTION);
							
					
					if (respuesta == JOptionPane.YES_NO_OPTION)
					{
						miCoordinador.eliminarPersona(textCod.getText());
						limpiar();
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Ingrese un numero de Documento", "Información",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		botonEliminar.setBounds(274, 193, 89, 23);
		panel.add(botonEliminar);
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	/**
	 * permite cargar los datos de la persona consultada
	 * @param miPersona
	 */
	private void muestraPersona(PersonaVo miPersona) {
		textNombre.setText(miPersona.getNombrePersona());
		textEdad.setText(miPersona.getEdadPersona()+"");
		textTelefono.setText(miPersona.getTelefonoPersona()+"");
		textProfesion.setText(miPersona.getProfesionPersona());
		habilita(true, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textCod.setText("");
		textNombre.setText("");
		textEdad.setText("");
		textTelefono.setText("");
		textProfesion.setText("");
		habilita(true, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param codigo
	 * @param nombre
	 * @param edad
	 * @param tel
	 * @param profesion
	 * @param cargo
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean codigo, boolean nombre, boolean edad, boolean tel, boolean profesion,	 boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textCod.setEditable(codigo);
		textNombre.setEditable(nombre);
		textEdad.setEditable(edad);
		textTelefono.setEditable(tel);
		textProfesion.setEditable(profesion);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
