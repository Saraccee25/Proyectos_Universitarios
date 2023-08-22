package vistaGUI;

import javax.swing.JPanel;
import logica.LCurso;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import bean.Curso;
import bean.Estudiante;
import java.awt.Font;
import javax.swing.JRadioButtonMenuItem;
import logica.LEstudiante;
import logica.LEstudianteData;
public class PanelMenuPrincipal extends JPanel {

	public PanelMenuPrincipal() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelDERECHA = new JPanel();
		panelDERECHA.setBackground(new Color(0, 0, 160));
		add(panelDERECHA, BorderLayout.EAST);

		JPanel panelIZQUIERDA = new JPanel();
		panelIZQUIERDA.setBackground(new Color(0, 0, 160));
		add(panelIZQUIERDA, BorderLayout.WEST);

		JPanel panelCENTRO = new JPanel();
		panelCENTRO.setBackground(new Color(255, 255, 255));
		add(panelCENTRO, BorderLayout.CENTER);
		panelCENTRO.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblTITULO = new JLabel("Menú Principal");
		lblTITULO.setBackground(new Color(255, 255, 255));
		lblTITULO.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblTITULO.setVerticalAlignment(SwingConstants.TOP);
		lblTITULO.setHorizontalAlignment(SwingConstants.CENTER);
		panelCENTRO.add(lblTITULO);

		JRadioButtonMenuItem mpOPC1 = new JRadioButtonMenuItem("Estudiantes");
		mpOPC1.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		panelCENTRO.add(mpOPC1);
		mpOPC1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				PanelEstudiante n = new PanelEstudiante();
				add(n);
				revalidate();
				repaint();
			}
		});

		JRadioButtonMenuItem mpOPC2 = new JRadioButtonMenuItem("Cursos");
		mpOPC2.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		panelCENTRO.add(mpOPC2);
		mpOPC2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				PanelCursos n = new PanelCursos();
				add(n);
				revalidate();
				repaint();
			}
		});

		JRadioButtonMenuItem mpOPC3 = new JRadioButtonMenuItem("Matrículas");
		mpOPC3.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		panelCENTRO.add(mpOPC3);
		mpOPC3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LEstudiante x = new LEstudiante(null, null, null, null);
				String cedula = JOptionPane.showInputDialog(null, "Ingrese cedula del estudiante:");
				Estudiante z = x.buscarEstudiante(cedula);
				LCurso lcurso = new LCurso();
				Curso y = lcurso.buscarCursoPorCedula(cedula);
				removeAll();
				PanelMatricular n = new PanelMatricular(z,y);
				add(n);
				revalidate();
				repaint();
			}
		});

		JRadioButtonMenuItem mpOPC4 = new JRadioButtonMenuItem("Consultar estudiantes mayores de edad");
		mpOPC4.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		panelCENTRO.add(mpOPC4);
		mpOPC4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LEstudiante uno = new LEstudiante(null, null, null, null);
				uno.crearArchivoSerializadoMayoresEdad("./archivos/EstudiantesMayores.txt");
				LEstudianteData x = new LEstudianteData();
				x.LeerArchivo();
			}
		});
		
		JRadioButtonMenuItem mpOPC5 = new JRadioButtonMenuItem("Tomar prueba diagnóstica");
		mpOPC5.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		panelCENTRO.add(mpOPC5);
		mpOPC5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelPrueba prueba = new PanelPrueba();
				removeAll();
				add(prueba);
				revalidate();
				repaint();
			}
		});

	}

}
