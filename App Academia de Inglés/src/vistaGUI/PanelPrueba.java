package vistaGUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.List;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.Label;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.SystemColor;

public class PanelPrueba extends JPanel {

	private float contadorNota = 0;
	private boolean q1 = false;
	private boolean q2 = false;
	private boolean q3 = false;
	private boolean q4 = false;
	private boolean q5 = false;
	private boolean q6 = false;
	private boolean q7 = false;
	private boolean q8 = false;
	private boolean q9 = false;
	private boolean q10 = false;

	public PanelPrueba() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelDERECHO = new JPanel();
		panelDERECHO.setBackground(new Color(0, 0, 160));
		add(panelDERECHO, BorderLayout.EAST);

		JPanel panelIZQUIERDO = new JPanel();
		panelIZQUIERDO.setBackground(new Color(0, 0, 160));
		add(panelIZQUIERDO, BorderLayout.WEST);

		JPanel panelCENTRO = new JPanel();
		panelCENTRO.setBackground(new Color(255, 255, 255));
		add(panelCENTRO, BorderLayout.CENTER);
		panelCENTRO.setLayout(new BorderLayout(0, 0));

		JPanel panelCENTRALNORTE = new JPanel();
		panelCENTRALNORTE.setForeground(new Color(255, 255, 255));
		panelCENTRALNORTE.setBackground(new Color(204, 0, 0));
		panelCENTRO.add(panelCENTRALNORTE, BorderLayout.NORTH);

		JLabel lblPRUEBA = new JLabel("Bienvenido a nuestra prueba diágnostica");
		lblPRUEBA.setForeground(new Color(255, 255, 255));
		lblPRUEBA.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(0, 0, 160));
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenuPrincipal pmp = new PanelMenuPrincipal();
				removeAll();
				add(pmp);
				revalidate();
				repaint();
			}
		});
		
		GroupLayout gl_panelCENTRALNORTE = new GroupLayout(panelCENTRALNORTE);
		gl_panelCENTRALNORTE.setHorizontalGroup(
			gl_panelCENTRALNORTE.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCENTRALNORTE.createSequentialGroup()
					.addGap(170)
					.addComponent(lblPRUEBA)
					.addGap(142)
					.addComponent(btnCancelar)
					.addContainerGap())
		);
		gl_panelCENTRALNORTE.setVerticalGroup(
			gl_panelCENTRALNORTE.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCENTRALNORTE.createSequentialGroup()
					.addContainerGap(5, Short.MAX_VALUE)
					.addGroup(gl_panelCENTRALNORTE.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(lblPRUEBA))
					.addGap(11))
		);
		panelCENTRALNORTE.setLayout(gl_panelCENTRALNORTE);

		JPanel panelCENTRALDERECHO = new JPanel();
		panelCENTRO.add(panelCENTRALDERECHO, BorderLayout.EAST);
		panelCENTRALDERECHO.setLayout(new BorderLayout(0, 0));

		JPanel panelINTERIOR2 = new JPanel();
		panelINTERIOR2.setBackground(new Color(255, 255, 255));
		panelCENTRALDERECHO.add(panelINTERIOR2, BorderLayout.CENTER);
		panelINTERIOR2.setLayout(new GridLayout(10, 5, 0, 0));

		JLabel lblQ1 = new JLabel("Question 1:");
		lblQ1.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelINTERIOR2.add(lblQ1);

		JRadioButton rdbtnQ1A = new JRadioButton("a");
		rdbtnQ1A.setBackground(SystemColor.control);
		rdbtnQ1A.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ1A);
		rdbtnQ1A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ1A.isSelected()) {
					q1 = true;
					contadorNota += 0.5;
				} else {
					q1 = false;
				}
			}
		});

		JRadioButton rdbtnQ1B = new JRadioButton("b");
		rdbtnQ1B.setBackground(SystemColor.control);
		rdbtnQ1B.setForeground(new Color(0, 0, 0));
		rdbtnQ1B.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ1B);
		rdbtnQ1B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnQ1B.isSelected()) {
					q1 = true;
				} else {
					q1 = false;
				}
			}
		});

		JRadioButton rdbtnQ1C = new JRadioButton("c");
		rdbtnQ1C.setBackground(new Color(240, 240, 240));
		rdbtnQ1C.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ1C);
		rdbtnQ1C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnQ1C.isSelected()) {
					q1 = true;
				} else {
					q1 = false;
				}
			}
		});

		JRadioButton rdbtnQ1D = new JRadioButton("d");
		rdbtnQ1D.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ1D);
		rdbtnQ1D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnQ1D.isSelected()) {
					q1 = true;
				} else {
					q1 = false;
				}
			}
		});

		JLabel lblQ2 = new JLabel("Question 2:");
		lblQ2.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelINTERIOR2.add(lblQ2);

		JRadioButton rdbtnQ2A = new JRadioButton("a");
		rdbtnQ2A.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ2A);
		rdbtnQ2A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ2A.isSelected()) {
					q2 = true;
				} else {
					q2 = false;
				}
			}
		});

		JRadioButton rdbtnQ2B = new JRadioButton("b");
		rdbtnQ2B.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ2B);
		rdbtnQ2B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ2B.isSelected()) {
					q2 = true;
				} else {
					q2 = false;
				}
			}
		});

		JRadioButton rdbtnQ2C = new JRadioButton("c");
		rdbtnQ2C.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ2C);
		rdbtnQ2C.addActionListener(new ActionListener() { // respuesta correcta pregunta 2
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ2C.isSelected()) {
					q2 = true;
					contadorNota += 0.5;
				} else {
					q2 = false;
				}
			}
		});

		JRadioButton rdbtnQ2D = new JRadioButton("d");
		rdbtnQ2D.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ2D);
		rdbtnQ2D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ2D.isSelected()) {
					q2 = true;
				} else {
					q2 = false;
				}
			}
		});

		JLabel lblQ3 = new JLabel("Question 3:");
		lblQ3.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelINTERIOR2.add(lblQ3);

		JRadioButton rdbtnQ3A = new JRadioButton("a");
		rdbtnQ3A.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ3A);
		rdbtnQ3A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnQ3A.isSelected()) {
					q3 = true;
					contadorNota += 0.5;
				} else {
					q3 = false;
				}
			}
		});

		JRadioButton rdbtnQ3B = new JRadioButton("b");
		rdbtnQ3B.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ3B);
		rdbtnQ3B.addActionListener(new ActionListener() { // respuesta correcta pregunta 3
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ3B.isSelected()) {
					q3 = true;

				} else {
					q3 = false;
				}
			}
		});

		JRadioButton rdbtnQ3C = new JRadioButton("c");
		rdbtnQ3C.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ3C);
		rdbtnQ3C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ3C.isSelected()) {
					q3 = true;
				} else {
					q3 = false;
				}
			}
		});

		JRadioButton rdbtnQ3D = new JRadioButton("d");
		rdbtnQ3D.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ3D);
		rdbtnQ3D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ3D.isSelected()) {
					q3 = true;
				} else {
					q3 = false;
				}
			}
		});

		JLabel lblQ4 = new JLabel("Question 4:");
		lblQ4.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelINTERIOR2.add(lblQ4);

		JRadioButton rdbtnQ4A = new JRadioButton("a");
		rdbtnQ4A.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ4A);
		rdbtnQ4A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnQ4A.isSelected()) {
					q4 = true;
				} else {
					q4 = false;
				}
			}
		});

		JRadioButton rdbtnQ4B = new JRadioButton("b");
		rdbtnQ4B.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ4B);
		rdbtnQ4B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnQ4B.isSelected()) {
					q4 = true;
				} else {
					q4 = false;
				}
			}
		});

		JRadioButton rdbtnQ4C = new JRadioButton("c");
		rdbtnQ4C.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ4C);
		rdbtnQ4C.addActionListener(new ActionListener() { // respuesta correcta pregunta 4
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ4C.isSelected()) {
					q4 = true;
					contadorNota += 0.5;
				} else {
					q4 = false;
				}
			}
		});

		JRadioButton rdbtnQ4D = new JRadioButton("d");
		rdbtnQ4D.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ4D);
		rdbtnQ4D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnQ4D.isSelected()) {
					q4 = true;
				} else {
					q4 = false;
				}
			}
		});

		JLabel lblQ5 = new JLabel("Question 5:");
		lblQ5.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelINTERIOR2.add(lblQ5);

		JRadioButton rdbtnQ5A = new JRadioButton("a");
		rdbtnQ5A.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ5A);
		rdbtnQ5A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ5A.isSelected()) {
					q5 = true;
				} else {
					q5 = false;
				}
			}
		});

		JRadioButton rdbtnQ5B = new JRadioButton("b");
		rdbtnQ5B.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ5B);
		rdbtnQ5B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ5B.isSelected()) {
					q5 = true;
				} else {
					q5 = false;
				}
			}
		});

		JRadioButton rdbtnQ5C = new JRadioButton("c");
		rdbtnQ5C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		panelINTERIOR2.add(rdbtnQ5C);
		rdbtnQ5C.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		rdbtnQ5C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ5C.isSelected()) {
					q5 = true;
				} else {
					q5 = false;
				}
			}
		});

		JRadioButton rdbtnQ5D = new JRadioButton("d");
		rdbtnQ5D.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ5D);
		rdbtnQ5D.addActionListener(new ActionListener() { // respuesta correcta pregunta 5
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ5D.isSelected()) {
					q5 = true;
					contadorNota += 0.5;
				} else {
					q5 = false;
				}
			}
		});
		JLabel lblQ6 = new JLabel("Question 6:");
		lblQ6.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelINTERIOR2.add(lblQ6);

		JRadioButton rdbtnQ6A = new JRadioButton("a");
		rdbtnQ6A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		panelINTERIOR2.add(rdbtnQ6A);
		rdbtnQ6A.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		rdbtnQ6A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnQ6A.isSelected()) {
					q6 = true;
				} else {
					q6 = false;
				}

			}
		});

		JRadioButton rdbtnQ6B = new JRadioButton("b");
		rdbtnQ6B.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ6B);
		rdbtnQ6B.addActionListener(new ActionListener() { // respuesta correcta pregunta 6
			public void actionPerformed(ActionEvent e) {
				if (rdbtnQ6B.isSelected()) {
					q6 = true;
					contadorNota += 0.5;
				} else {
					q6 = false;
				}
			}
		});

		JRadioButton rdbtnQ6C = new JRadioButton("c");
		rdbtnQ6C.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ6C);
		rdbtnQ6C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ6C.isSelected()) {
					q6 = true;
				} else {
					q6 = false;
				}
			}
		});

		JRadioButton rdbtnQ6D = new JRadioButton("d");
		rdbtnQ6D.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ6D);
		rdbtnQ6D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ6D.isSelected()) {
					q6 = true;
				} else {
					q6 = false;
				}
			}
		});

		JLabel lblQ7 = new JLabel("Question 7:");
		lblQ7.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelINTERIOR2.add(lblQ7);

		JRadioButton rdbtnQ7A = new JRadioButton("a");
		rdbtnQ7A.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ7A);
		rdbtnQ7A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ7A.isSelected()) {
					q7 = true;
				} else {
					q7 = false;
				}
			}
		});

		JRadioButton rdbtnQ7B = new JRadioButton("b");
		rdbtnQ7B.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ7B);
		rdbtnQ7B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ7B.isSelected()) {
					q7 = true;
				} else {
					q7 = false;
				}
			}
		});

		JRadioButton rdbtnQ7C = new JRadioButton("c");
		rdbtnQ7C.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ7C);
		rdbtnQ7C.addActionListener(new ActionListener() { // respuesta correcta pregunta 7
			public void actionPerformed(ActionEvent e) {
				if (rdbtnQ7C.isSelected()) {
					q7 = true;
					contadorNota += 0.5;
				} else {
					q7 = false;
				}
			}
		});

		JRadioButton rdbtnQ7D = new JRadioButton("d");
		rdbtnQ7D.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ7D);
		rdbtnQ7D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ7D.isSelected()) {
					q7 = true;
				} else {
					q7 = false;
				}
			}
		});

		JLabel lblQ8 = new JLabel("Question 8:");
		lblQ8.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelINTERIOR2.add(lblQ8);

		JRadioButton rdbtnQ8A = new JRadioButton("a");
		rdbtnQ8A.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ8A);
		rdbtnQ8A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ8A.isSelected()) {
					q8 = true;
				} else {
					q8 = false;
				}
			}
		});

		JRadioButton rdbtnQ8B = new JRadioButton("b");
		rdbtnQ8B.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ8B);
		rdbtnQ8B.addActionListener(new ActionListener() { // respuesta correcta pregunta 8
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ8B.isSelected()) {
					q8 = true;
					contadorNota += 0.5;
				} else {
					q8 = false;
				}
			}
		});

		JRadioButton rdbtnQ8C = new JRadioButton("c");
		rdbtnQ8C.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ8C);
		rdbtnQ8C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ8C.isSelected()) {
					q8 = true;
				} else {
					q8 = false;
				}
			}
		});

		JRadioButton rdbtnQ8D = new JRadioButton("d");
		rdbtnQ8D.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ8D);
		rdbtnQ8D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ8D.isSelected()) {
					q8 = true;
				} else {
					q8 = false;
				}
			}
		});

		JLabel lblQ9 = new JLabel("Question 9:");
		lblQ9.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelINTERIOR2.add(lblQ9);

		JRadioButton rdbtnQ9A = new JRadioButton("a");
		rdbtnQ9A.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ9A);
		rdbtnQ9A.addActionListener(new ActionListener() { // respuesta correcta pregunta 9
			public void actionPerformed(ActionEvent e) {
				if (rdbtnQ9A.isSelected()) {
					q9 = true;
					contadorNota += 0.5;
				} else {
					q9 = false;
				}
			}
		});

		JRadioButton rdbtnQ9B = new JRadioButton("b");
		rdbtnQ9B.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ9B);
		rdbtnQ9B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnQ9B.isSelected()) {
					q9 = true;
				} else {
					q9 = false;
				}

			}
		});

		JRadioButton rdbtnQ9C = new JRadioButton("c");
		rdbtnQ9C.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ9C);
		rdbtnQ9C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnQ9C.isSelected()) {
					q9 = true;
				} else {
					q9 = false;
				}
			}
		});

		JRadioButton rdbtnQ9D = new JRadioButton("d");
		rdbtnQ9D.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ9D);
		rdbtnQ9D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ9D.isSelected()) {
					q9 = true;
				} else {
					q9 = false;
				}
			}
		});

		JLabel lblQ10 = new JLabel("Question 10:");
		lblQ10.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelINTERIOR2.add(lblQ10);

		JRadioButton rdbtnQ10A = new JRadioButton("a");
		rdbtnQ10A.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ10A);
		rdbtnQ10A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ10A.isSelected()) {
					q10 = true;
				} else {
					q10 = false;
				}
			}
		});

		JRadioButton rdbtnQ10B = new JRadioButton("b");
		rdbtnQ10B.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ10B);
		rdbtnQ10B.addActionListener(new ActionListener() { // respuesta correcta pregunta 10
			public void actionPerformed(ActionEvent e) {
				if (rdbtnQ10B.isSelected()) {
					q10 = true;
					contadorNota += 0.5;
				} else {
					q10 = false;
				}
			}
		});

		JRadioButton rdbtnQ10C = new JRadioButton("c");
		rdbtnQ10C.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ10C);
		rdbtnQ10C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ10C.isSelected()) {
					q10 = true;
				} else {
					q10 = false;
				}
			}
		});

		JRadioButton rdbtnQ10D = new JRadioButton("d");
		rdbtnQ10D.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelINTERIOR2.add(rdbtnQ10D);
		rdbtnQ10D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnQ10D.isSelected()) {
					q10 = true;
					contadorNota += 0.5;
				} else {
					q10 = false;
				}
			}
		});

		JPanel panelINTERIOR3 = new JPanel();
		panelINTERIOR3.setBackground(new Color(255, 255, 255));
		panelCENTRALDERECHO.add(panelINTERIOR3, BorderLayout.NORTH);

		JLabel lblSELECCIONEOPC = new JLabel("Mark your answer:");
		lblSELECCIONEOPC.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		panelINTERIOR3.add(lblSELECCIONEOPC);

		JPanel panelCENTRAL = new JPanel();
		panelCENTRAL.setBackground(new Color(255, 255, 255));
		panelCENTRO.add(panelCENTRAL, BorderLayout.CENTER);
		panelCENTRAL.setLayout(new BorderLayout(0, 0));

		JPanel panelTEXTO = new JPanel();
		panelTEXTO.setBackground(new Color(255, 255, 255));
		panelCENTRAL.add(panelTEXTO, BorderLayout.CENTER);
		panelTEXTO.setLayout(new BorderLayout(0, 0));

		JTextPane textPaneTEXTO = new JTextPane();
		textPaneTEXTO.setEditable(false);
		textPaneTEXTO.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		textPaneTEXTO.setText(
				"1.\tWhat is the correct word order in a basic English sentence?\r\na)\tSubject - Verb - Object\r\nb)\tObject - Subject - Verb\r\nc)\tVerb - Object - Subject\r\nd)\tObject - Verb - Subject\r\n\r\n2.\tChoose the correct form of the verb to complete the sentence:\r\nShe ________ to the store yesterday.\r\na)\tgo\r\nb)\tgoes\r\nc)\twent\r\nd)\tgone\r\n\r\n3.\tWhich sentence uses the correct comparative form?\r\na)\tThis book is more interesting than the other one.\r\nb)\tThis book is interestinger than the other one.\r\nc)\tThis book is interestingest than the other one.\r\nd)\tThis book is interesting than the other one.\r\n\r\n4.\tWhat is the correct plural form of \"child\"?\r\na)\tchilds\r\nb)\tchildrens\r\nc)\tchildren\r\nd)\tchildes\r\n\r\n5.\tChoose the correct preposition to complete the sentence:\r\nHe's been working ________ that company for five years.\r\na)\ton\r\nb)\tat\r\nc)\tin\r\nd)\tfor\r\n\r\n6.\tWhich sentence is grammatically correct?\r\na)\tI have been to Paris last year.\r\nb)\tI went to Paris last year.\r\nc)\tI did go to Paris last year.\r\nd)\tI was go to Paris last year.\r\n\r\n7.\tChoose the correct word to complete the sentence:\r\nShe ________ the piano since she was five years old.\r\na)\tplayed\r\nb)\tis playing\r\nc)\thas been playing\r\nd)\tplays\r\n\r\n8.\tWhat is the correct form of the verb to complete the sentence:\r\nThey ________ a lot of money last month.\r\na)\tspends\r\nb)\tspent\r\nc)\tspend\r\nd)\thave spent\r\n\r\n9.\tChoose the correct word to complete the sentence:\r\nI'm not sure if I ________ to the party tonight.\r\na)\twill go\r\nb)\tgo\r\nc)\tgoing\r\nd)\twent\r\n\r\n10.\tWhich sentence uses the correct word order for an interrogative sentence?\r\na)\tAre where you from?\r\nb)\tFrom where are you?\r\nc)\tYou are from where?\r\nd)\tWhere are you from?\r\n");
		panelTEXTO.add(textPaneTEXTO, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane(panelTEXTO);
		panelCENTRAL.add(scrollPane, BorderLayout.EAST);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		JButton Finalizar = new JButton("Finalizar");
		Finalizar.setBackground(new Color(0, 0, 160));
		Finalizar.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		Finalizar.setForeground(new Color(255, 255, 255));
		panelCENTRAL.add(Finalizar, BorderLayout.SOUTH);
		Finalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (q1 && q2 && q3 && q4 && q5 && q6 && q7 && q8 && q9 && q10) {
					JOptionPane.showMessageDialog(null, "Su puntaje es. " + contadorNota);
					if (contadorNota <= 2) {
						JOptionPane.showMessageDialog(null,
								"Según tu calificación podrías tomas los cursos: \n" + "A1 \n" + "A2 \n");
						PanelMenuPrincipal pmp = new PanelMenuPrincipal();
						removeAll();
						add(pmp);
						revalidate();
						repaint();
					} else if (contadorNota >= 2 && contadorNota >= 4) {
						JOptionPane.showMessageDialog(null,
								"Según tu calificación podrías tomas los cursos: \n" + "B1 \n" + "B2 \n");
						PanelMenuPrincipal pmp = new PanelMenuPrincipal();
						removeAll();
						add(pmp);
						revalidate();
						repaint();
					} else {
						JOptionPane.showMessageDialog(null,
								"Según tu calificación podrías tomas los cursos: \n" + "B2+ \n" + "C1 \n");
						PanelMenuPrincipal pmp = new PanelMenuPrincipal();
						removeAll();
						add(pmp);
						revalidate();
						repaint();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor complete el formulario");
				}
				

			}
		});

		JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
		verticalScrollBar.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				JScrollBar scrollBar = (JScrollBar) e.getSource();
				int extent = scrollBar.getModel().getExtent();
				int maximum = scrollBar.getModel().getMaximum();
				int value = scrollBar.getValue();

				if (value + extent >= maximum) {
					scrollPane.setViewportView(panelTEXTO);
					scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					JViewport viewport = scrollPane.getViewport();
					viewport.setViewPosition(new Point(0, panelTEXTO.getHeight()));
				}
			}
		});
	}
}
