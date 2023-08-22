package vistaGUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.print.attribute.standard.JobPrioritySupported;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import bean.Usuario;
import logica.LUsuario;

import java.awt.FlowLayout;
import java.awt.GridLayout;

public class PanelUsuarioRegistrar extends JPanel implements ActionListener {
	private JTextField textField_1;
	private JPasswordField passwordField_1;

	/**
	 * Create the panel.
	 */
	public PanelUsuarioRegistrar() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelDERECHA = new JPanel();
		panelDERECHA.setBackground(new Color(0, 0, 160));
		add(panelDERECHA, BorderLayout.EAST);

		JPanel panelIZQUIERDA = new JPanel();
		panelIZQUIERDA.setBackground(new Color(0, 0, 160));
		add(panelIZQUIERDA, BorderLayout.WEST);

		JPanel panelCENTRAL_1 = new JPanel();
		panelCENTRAL_1.setBackground(new Color(255, 255, 255));
		add(panelCENTRAL_1, BorderLayout.CENTER);
		panelCENTRAL_1.setLayout(new GridLayout(6, 3, 0, 0));

		JLabel label_1 = new JLabel("");
		panelCENTRAL_1.add(label_1);

		JLabel lblIngreseUnUsuario = new JLabel("Ingrese un usuario:");
		lblIngreseUnUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseUnUsuario.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelCENTRAL_1.add(lblIngreseUnUsuario);

		JLabel label_2 = new JLabel("");
		panelCENTRAL_1.add(label_2);

		JLabel label_3 = new JLabel("");
		panelCENTRAL_1.add(label_3);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblIngreseUnUsuario.setLabelFor(textField_1);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(5);
		panelCENTRAL_1.add(textField_1);

		JLabel label_4 = new JLabel("");
		panelCENTRAL_1.add(label_4);

		JLabel label_6 = new JLabel("");
		panelCENTRAL_1.add(label_6);

		JLabel lblIngreseUnaContrasea = new JLabel("Ingrese una contraseña:");
		lblIngreseUnaContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseUnaContrasea.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelCENTRAL_1.add(lblIngreseUnaContrasea);

		JLabel label_7 = new JLabel("");
		panelCENTRAL_1.add(label_7);

		JLabel label_10 = new JLabel("");
		panelCENTRAL_1.add(label_10);

		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblIngreseUnaContrasea.setLabelFor(passwordField_1);
		passwordField_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCENTRAL_1.add(passwordField_1);

		JLabel label_11 = new JLabel("");
		panelCENTRAL_1.add(label_11);

		JLabel lblNewLabel = new JLabel("");
		panelCENTRAL_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		panelCENTRAL_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		panelCENTRAL_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		panelCENTRAL_1.add(lblNewLabel_3);

		JButton btnREGISTRAR = new JButton("Registrarme");
		btnREGISTRAR.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelCENTRAL_1.add(btnREGISTRAR);
		btnREGISTRAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() instanceof JButton) {
					JButton source = (JButton) e.getSource();

					if (source.getText().equals("Registrarme")) {
						String usuario = textField_1.getText();
						String clave = new String(passwordField_1.getPassword());

						if (!usuario.isEmpty() && !clave.isEmpty()) {
							datosUsuario(usuario, clave);
						} else {
							JOptionPane.showMessageDialog(null, "Campos vacíos");
						}
					}
				}
			}
		});
	}

	private void datosUsuario(String usuario, String clave) {
		Usuario us = new Usuario();
		us.setUsuario(usuario);
		us.setClave(clave);
		LUsuario x = new LUsuario();
		boolean validar = x.buscarUsuario2(us.getUsuario());
		if (validar == true) {
			JOptionPane.showMessageDialog(null, "Usuario existente, por favor ingrese uno nuevo");
			removeAll();
			PanelUsuarioRegistrar n = new PanelUsuarioRegistrar();
			add(n);
			revalidate();
			repaint();
		} else {
			x.insertar(us);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
