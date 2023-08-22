package vistaGUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import bean.Curso;
import logica.LCurso;
import logica.LEstudiante;
import logica.LMaterial;

import java.awt.Font;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JButton;

public class PanelEstudiante extends JPanel {

	
	public PanelEstudiante() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelDERECHA = new JPanel();
		panelDERECHA.setBackground(new Color(0, 0, 160));
		add(panelDERECHA, BorderLayout.WEST);
		
		JPanel panelIZQUIERDA = new JPanel();
		panelIZQUIERDA.setBackground(new Color(0, 0, 160));
		add(panelIZQUIERDA, BorderLayout.EAST);
		
		JPanel panelCENTRAL = new JPanel();
		panelCENTRAL.setBackground(new Color(255, 255, 255));
		add(panelCENTRAL, BorderLayout.CENTER);
		panelCENTRAL.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel TITULOMENU = new JLabel("Estudiantes");
		TITULOMENU.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		TITULOMENU.setVerticalAlignment(SwingConstants.TOP);
		TITULOMENU.setHorizontalAlignment(SwingConstants.CENTER);
		panelCENTRAL.add(TITULOMENU);
		
		JRadioButtonMenuItem menuOPCION1 = new JRadioButtonMenuItem("Ingresar un estudiante");
		menuOPCION1.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		panelCENTRAL.add(menuOPCION1);
		menuOPCION1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				PanelEstudiantesRegistrar n = new PanelEstudiantesRegistrar();
				add(n);
				revalidate();
				repaint();
			}
		});
		
		JRadioButtonMenuItem menuOPCION2 = new JRadioButtonMenuItem("Consultar un estudiante");
		menuOPCION2.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		panelCENTRAL.add(menuOPCION2);
		menuOPCION2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ced2 = JOptionPane.showInputDialog("Ingrese la cédula del estudiante");
				LEstudiante est = new LEstudiante(null,null,null,null);
				est.buscarEstudiantePorCedula(ced2);
			}
		});
		
		JRadioButtonMenuItem menuOPCION3 = new JRadioButtonMenuItem("Eliminar un estudiante");
		menuOPCION3.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		panelCENTRAL.add(menuOPCION3);
		menuOPCION3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ced2 = JOptionPane.showInputDialog("Ingrese la cédula del estudiante");
				LEstudiante est = new LEstudiante(null,null,null,null);
				est.eliminarRegistro(ced2);
			}
		});
		
		JRadioButtonMenuItem menuOPCION4 = new JRadioButtonMenuItem("Obtener material de estudio");
		menuOPCION4.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		panelCENTRAL.add(menuOPCION4);
		menuOPCION4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				String ced2 = JOptionPane.showInputDialog("Ingrese la cédula del estudiante");				
				LCurso elegir = new LCurso();
				Curso curso = elegir.buscarCursoPorCedula(ced2);
				JOptionPane.showMessageDialog(null, "Curso: " + curso.getCodigo());
				LMaterial material = new LMaterial();
				String enlace = material.buscarEnlacePorCodigo(curso.getCodigo());
				JOptionPane.showMessageDialog(null, "Aquí tienes material para tu clase: " + enlace);

			}
		});
		
		JRadioButtonMenuItem menuOPCION5 = new JRadioButtonMenuItem("Enlace a la sala");
		menuOPCION5.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		panelCENTRAL.add(menuOPCION5);
		menuOPCION5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {								
				JOptionPane.showMessageDialog(null, "Aquí tienes el link para tu clase: https://meet.google.com/gaq-nepg-ucf" );

			}
		});
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setForeground(new Color(255, 255, 255));
		btnRegresar.setBackground(new Color(196, 0, 0));
		btnRegresar.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
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
