package vistaGUI;

import javax.swing.JPanel;
import logica.LCurso;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.border.SoftBevelBorder;

import logica.LEstudiante;
import logica.LEstudianteData;

import javax.swing.border.BevelBorder;

public class PanelPrincipal extends JPanel implements ActionListener {

	public PanelPrincipal() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(30, 50, 130));
		panelTitulo.setForeground(new Color(255, 255, 255));
		add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel TituloApp = new JLabel("LET'S BE FLUENT");
		TituloApp.setForeground(new Color(255, 255, 255));
		TituloApp.setFont(new Font("Segoe UI Black", Font.PLAIN, 19));
		TituloApp.setLabelFor(panelTitulo);
		TituloApp.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitulo.add(TituloApp);
		
		JLabel logo2 = new JLabel("");
		logo2.setIcon(new ImageIcon("C:\\Users\\USUARIO\\Downloads\\LOGO11.png"));
		panelTitulo.add(logo2);

		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(new Color(202, 0, 0));
		add(panelInferior, BorderLayout.SOUTH);

		JLabel PiedePagina = new JLabel("Keep it simple!");
		PiedePagina.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		PiedePagina.setForeground(new Color(255, 255, 255));
		panelInferior.add(PiedePagina);

		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(new Color(255, 255, 255));
		panelCentro.setForeground(new Color(0, 0, 160));
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\USUARIO\\Downloads\\englishmessage.gif"));
		panelCentro.add(lblNewLabel);

		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(panelIzquierdo, BorderLayout.WEST);
		panelIzquierdo.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel TituloMenu = new JLabel("¡Bienvenido!");
		TituloMenu.setBackground(new Color(255, 255, 255));
		TituloMenu.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		TituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		TituloMenu.setForeground(new Color(0, 64, 128));
		panelIzquierdo.add(TituloMenu);

		JRadioButtonMenuItem Opcion1 = new JRadioButtonMenuItem("Ver cursos disponibles");
		Opcion1.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		Opcion1.setBackground(new Color(255, 255, 255));
		Opcion1.setHorizontalAlignment(SwingConstants.CENTER);
		Opcion1.setForeground(new Color(0, 64, 128));
		panelIzquierdo.add(Opcion1);
		Opcion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LCurso x = new LCurso();
				x.cargarCursos();
				x.mostrarCursosDisponibles2();
			}
		});

		JRadioButtonMenuItem Opcion2 = new JRadioButtonMenuItem("Regístrese");
		Opcion2.setBackground(new Color(255, 255, 255));
		Opcion2.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		Opcion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCentro.removeAll();
				PanelUsuarioRegistrar n = new PanelUsuarioRegistrar();
				panelCentro.add(n);
				panelCentro.revalidate();
				panelCentro.repaint();
			}
		});
		
		panelIzquierdo.add(Opcion2);
		Opcion2.setHorizontalAlignment(SwingConstants.CENTER);
		Opcion2.setForeground(new Color(0, 64, 128));
		panelIzquierdo.add(Opcion2);

		JRadioButtonMenuItem Opcion3 = new JRadioButtonMenuItem("Ingresar");
		Opcion3.setBackground(new Color(255, 255, 255));
		Opcion3.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		Opcion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCentro.removeAll();
				PanelUsuarioIngresar n = new PanelUsuarioIngresar();
				//removeAll();
				panelCentro.add(n);
				panelCentro.revalidate();
				panelCentro.repaint();
			}
		});
		panelIzquierdo.add(Opcion3);
		Opcion3.setHorizontalAlignment(SwingConstants.CENTER);
		Opcion3.setForeground(new Color(0, 64, 128));
		panelIzquierdo.add(Opcion3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
