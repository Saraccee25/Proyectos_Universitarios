package vistaGUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import logica.LEstudiante;
import logica.LUsuario;
import bean.Estudiante;

public class PanelEstudiantesRegistrar extends JPanel {
	private JTextField textFieldCedula;
	private JTextField textFieldNombre;
	private JTextField textFieldCORREO;
	private JTextField textFieldFecha;

	public PanelEstudiantesRegistrar() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelIZQUIERDA = new JPanel();
		panelIZQUIERDA.setBackground(new Color(0, 0, 160));
		add(panelIZQUIERDA, BorderLayout.WEST);

		JPanel panelDERECHA = new JPanel();
		panelDERECHA.setBackground(new Color(0, 0, 160));
		add(panelDERECHA, BorderLayout.EAST);

		JPanel panelCENTRO = new JPanel();
		add(panelCENTRO, BorderLayout.CENTER);
		panelCENTRO.setLayout(new GridLayout(6, 4, 0, 0));

		JLabel lblNewLabelVACIO1 = new JLabel("");
		panelCENTRO.add(lblNewLabelVACIO1);

		JLabel lbCEDULA = new JLabel("Ingrese la cédula:");
		lbCEDULA.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelCENTRO.add(lbCEDULA);

		textFieldCedula = new JTextField();
		textFieldCedula.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lbCEDULA.setLabelFor(textFieldCedula);
		panelCENTRO.add(textFieldCedula);
		textFieldCedula.setColumns(10);

		JLabel lblNewLabelVACIO2 = new JLabel("");
		panelCENTRO.add(lblNewLabelVACIO2);

		JLabel lblNewLabel_8 = new JLabel("");
		panelCENTRO.add(lblNewLabel_8);

		JLabel lbNOMBRE = new JLabel("Ingrese el nombre");
		lbNOMBRE.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelCENTRO.add(lbNOMBRE);
		lbNOMBRE.setLabelFor(textFieldNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		panelCENTRO.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblNewLabelVACIO3 = new JLabel("");
		panelCENTRO.add(lblNewLabelVACIO3);

		JLabel lblNewLabelVACIO4 = new JLabel("");
		panelCENTRO.add(lblNewLabelVACIO4);

		JLabel lbCORREO = new JLabel("Ingrese el correo:");
		lbCORREO.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelCENTRO.add(lbCORREO);
		lbCORREO.setLabelFor(textFieldCORREO);

		textFieldCORREO = new JTextField();
		textFieldCORREO.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		textFieldCORREO.setColumns(10);
		panelCENTRO.add(textFieldCORREO);

		JLabel lblNewLabelVACIO5 = new JLabel("");
		panelCENTRO.add(lblNewLabelVACIO5);

		JLabel lblNewLabel = new JLabel("");
		panelCENTRO.add(lblNewLabel);

		JLabel lbFECHA = new JLabel("Ingrese la fecha de nacimiento:");
		lbFECHA.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelCENTRO.add(lbFECHA);

		textFieldFecha = new JTextField();
		textFieldFecha.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		textFieldFecha.setColumns(10);
		panelCENTRO.add(textFieldFecha);

		JLabel lblNewLabel_1 = new JLabel("");
		panelCENTRO.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		panelCENTRO.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		panelCENTRO.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		panelCENTRO.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		panelCENTRO.add(lblNewLabel_5);
				
				JButton btnRegresar = new JButton("Regresar");
				btnRegresar.setForeground(Color.WHITE);
				btnRegresar.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
				btnRegresar.setBackground(new Color(196, 0, 0));
				panelCENTRO.add(btnRegresar);
				btnRegresar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						removeAll();
						PanelEstudiante n = new PanelEstudiante();
						add(n);
						revalidate();
						repaint();
					}
				});

		JLabel lblNewLabel_7 = new JLabel("");
		panelCENTRO.add(lblNewLabel_7);
		
				JButton btnNewREGISTRAR = new JButton("Registrar");
				btnNewREGISTRAR.setFont(new Font("Segoe UI Black", Font.PLAIN, 22));
				panelCENTRO.add(btnNewREGISTRAR);
				btnNewREGISTRAR.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						datosEstudiante();
					}

				});

		JLabel lblNewLabel_10 = new JLabel("");
		panelCENTRO.add(lblNewLabel_10);

		JLabel lblNewLabel_9 = new JLabel("");
		add(lblNewLabel_9, BorderLayout.NORTH);

	}

	private void datosEstudiante() {
		String cedula = textFieldCedula.getText();
		String nombre = textFieldNombre.getText();
		String correoElectronico = textFieldCORREO.getText();
		String fechaNacimientoStr = textFieldFecha.getText();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
		Estudiante est = new Estudiante(cedula, nombre, fechaNacimiento, correoElectronico);
		est.setCedula(cedula);
		LEstudiante estu = new LEstudiante(null, null, null, null);
		boolean cedulaExistente = estu.validarcc(cedula);
		if (cedulaExistente) {
			JOptionPane.showMessageDialog(null,
					"ERROR! La cédula ingresada ya pertenece a un estudiante, por favor intente de nuevo:");
			removeAll();
			PanelEstudiantesRegistrar n = new PanelEstudiantesRegistrar();
			add(n);
			revalidate();
			repaint();
		}
		est.setNombre(nombre);
		est.setCorreoElectronico(correoElectronico);
		est.setFechaNacimiento(fechaNacimiento);	
		estu.registrarEstudiante(est);
		removeAll();
		PanelEstudiante c = new PanelEstudiante();
		add(c);
		revalidate();
		repaint();
	}

}
