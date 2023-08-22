package vistaGUI;

import javax.swing.JPanel;

import logica.LCurso;
import logica.LEstudiante;
import logica.LMatricular;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import bean.Curso;
import bean.Estudiante;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;

public class PanelMatricular extends JPanel {

	public PanelMatricular(Estudiante estudiante, Curso curso) {
		setLayout(new BorderLayout(0, 0));

		JPanel panelDERECHA = new JPanel();
		panelDERECHA.setBackground(new Color(0, 0, 160));
		add(panelDERECHA, BorderLayout.EAST);

		JPanel panelIZQUIERDA = new JPanel();
		panelIZQUIERDA.setBackground(new Color(0, 0, 160));
		add(panelIZQUIERDA, BorderLayout.WEST);

		JPanel panelCENTRAL = new JPanel();
		panelCENTRAL.setBackground(Color.WHITE);
		add(panelCENTRAL, BorderLayout.CENTER);
		panelCENTRAL.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblMatriculas = new JLabel("Matriculas");
		lblMatriculas.setVerticalAlignment(SwingConstants.TOP);
		lblMatriculas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatriculas.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelCENTRAL.add(lblMatriculas);

		JRadioButtonMenuItem menuOPCION1 = new JRadioButtonMenuItem("Continuar con la matrícula");
		menuOPCION1.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		panelCENTRAL.add(menuOPCION1);
		menuOPCION1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "!Bienvenido!");
				try {
					LMatricular matricula = new LMatricular(estudiante, curso);
					matricula.matricular();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"Por favor regístrese en un curso antes de realizar la matrícula");
				}
			}
		});

		JRadioButtonMenuItem menuOPCION2 = new JRadioButtonMenuItem("Consultar matrícula");
		menuOPCION2.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		panelCENTRAL.add(menuOPCION2);
		menuOPCION2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "!Bienvenido!");
				try {	
					LMatricular matricula = new LMatricular(estudiante, curso);
					matricula.buscarRegistroMatriculaPorCedula(estudiante.getCedula());
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, "Asegurese de estar matriculado");				
				}}
			}
		);

		JRadioButtonMenuItem menuOPCION3 = new JRadioButtonMenuItem("Cancelar matrícula");
		menuOPCION3.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		panelCENTRAL.add(menuOPCION3);
		menuOPCION3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LEstudiante est = new LEstudiante(null, null, null, null);
				boolean encontrado = est.buscarCedula(estudiante.getCedula());
				if (encontrado == true) {			
				    int opcion = JOptionPane.showOptionDialog(null, "¿Desea continuar con la cancelación de matrícula?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				    if (opcion == JOptionPane.YES_OPTION) {
				    	LMatricular matricula = new LMatricular(estudiante, curso);
				        matricula.eliminarRegistro(estudiante.getCedula());
				        matricula.eliminarRegistro(estudiante.getCedula());
				        LCurso c = new LCurso();
				        c.eliminarRegistro(estudiante.getCedula());
				        JOptionPane.showMessageDialog(null, "Proceso finalizado");
				    } else {
				        JOptionPane.showMessageDialog(null, "La matrícula sigue vigente");
				    }
				}
}
			}
		);

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
