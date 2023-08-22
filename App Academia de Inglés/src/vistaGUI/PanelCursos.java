package vistaGUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import bean.Curso;
import bean.Estudiante;
import logica.LCurso;
import logica.LEstudiante;
import vista.VistaEstudiante;
import vista.VistaMatricular;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;

public class PanelCursos extends JPanel {

	public PanelCursos() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelDERECHA = new JPanel();
		panelDERECHA.setBackground(new Color(0, 0, 160));
		add(panelDERECHA, BorderLayout.EAST);

		JPanel panelDERECHA_1 = new JPanel();
		panelDERECHA_1.setBackground(new Color(0, 0, 160));
		add(panelDERECHA_1, BorderLayout.WEST);

		JPanel panelCENTRAL = new JPanel();
		panelCENTRAL.setBackground(Color.WHITE);
		add(panelCENTRAL, BorderLayout.CENTER);
		panelCENTRAL.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel TITULOMENU = new JLabel("Cursos");
		TITULOMENU.setVerticalAlignment(SwingConstants.TOP);
		TITULOMENU.setHorizontalAlignment(SwingConstants.CENTER);
		TITULOMENU.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelCENTRAL.add(TITULOMENU);

		JRadioButtonMenuItem menuOPCION1 = new JRadioButtonMenuItem("Mostrar cursos disponibles");
		menuOPCION1.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		panelCENTRAL.add(menuOPCION1);
		menuOPCION1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LCurso x = new LCurso();
				x.cargarCursos();
				x.mostrarCursosDisponibles2();
			}
		});

		JRadioButtonMenuItem menuOPCION2 = new JRadioButtonMenuItem("Separar cupo en un curso");
		menuOPCION2.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		panelCENTRAL.add(menuOPCION2);
		menuOPCION2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "!Bienvenido! Aquí separas cupo en alguno de nuestros cursos");
				String cedula = JOptionPane.showInputDialog("Ingrese cedula del estudiante:");
				LEstudiante lest = new LEstudiante(null, null, null, null);
				boolean exist = lest.buscarCedula(cedula);
				if (exist == false) {
					JOptionPane.showMessageDialog(null,
							"El estudiante no se encuentra registrado, por favor registrelo primero");
					PanelEstudiantesRegistrar y = new PanelEstudiantesRegistrar();
					removeAll();
					add(y);
					revalidate();
					repaint();
				} else {
					LCurso x = new LCurso();
					x.cargarCursos();
					x.mostrarCursosDisponibles2();
					int codigo = Integer
							.parseInt(JOptionPane.showInputDialog("Ingrese el código del curso que le interesa"));
					x.registrarCursos(cedula, codigo);
				}

			}
		});

		JRadioButtonMenuItem menuOPCION3 = new JRadioButtonMenuItem("Matricularme en un curso");

		menuOPCION3.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		panelCENTRAL.add(menuOPCION3);
		menuOPCION3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LCurso x = new LCurso();
				JOptionPane.showMessageDialog(null,
						"!Bienvenido! Aquí te matricularás en un curso, recuerda que debes separar tu cupo primero");
				String ced = JOptionPane.showInputDialog(null, "Ingrese identificación de estudiante a matricular:");
				boolean existe = x.buscarCedula(ced);
				if (existe == false) {
					JOptionPane.showMessageDialog(null, "No existe estudiante registrado en el curso, vamos a registrarlo ahora");
					x = new LCurso();
					x.cargarCursos();
					x.mostrarCursosDisponibles2();
					Curso curso2 = x.elegirCursoPorCodigo();
					LEstudiante estudiante = new LEstudiante(null, null, null, null);
					Estudiante est = estudiante.buscarEstudiante(ced);
					PanelMatricular pm = new PanelMatricular(est,curso2);
					removeAll();
					add(pm);
					revalidate();
					repaint();
				} else {
					x = new LCurso();
					Curso curso2 = x.buscarCursoPorCedula(ced);
					LEstudiante estudiante = new LEstudiante(null, null, null, null);
					Estudiante est = estudiante.buscarEstudiante(ced);
					PanelMatricular pm = new PanelMatricular(est,curso2);
					removeAll();
					add(pm);
					revalidate();
					repaint();
				}

			}
		});

		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		btnRegresar.setBackground(new Color(196, 0, 0));
		panelCENTRAL.add(btnRegresar);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				PanelMenuPrincipal n = new PanelMenuPrincipal();
				add(n);
				revalidate();
				repaint();
			}
		});

	}

}
