package vistaGUI;

import javax.swing.JPanel;
import logica.LUsuario;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PanelUsuarioIngresar extends JPanel implements ActionListener {
	private JTextField textUSUARIO;
	private JPasswordField passwordField;

	public PanelUsuarioIngresar() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelCENTRAL = new JPanel();
		panelCENTRAL.setBackground(new Color(255, 255, 255));
		add(panelCENTRAL, BorderLayout.CENTER);
		panelCENTRAL.setLayout(new GridLayout(6, 3, 0, 0));

		JLabel label_1 = new JLabel("");
		label_1.setIcon(null);
		label_1.setBackground(new Color(255, 255, 255));
		panelCENTRAL.add(label_1);

		JLabel lblUSUARIO = new JLabel("Usuario:");
		lblUSUARIO.setHorizontalAlignment(SwingConstants.CENTER);
		lblUSUARIO.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelCENTRAL.add(lblUSUARIO);
		lblUSUARIO.setLabelFor(textUSUARIO);

		JLabel label_2 = new JLabel("");
		panelCENTRAL.add(label_2);

		JLabel label_3 = new JLabel("");
		panelCENTRAL.add(label_3);

		textUSUARIO = new JTextField();
		textUSUARIO.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textUSUARIO.setHorizontalAlignment(SwingConstants.CENTER);
		textUSUARIO.setColumns(5);
		panelCENTRAL.add(textUSUARIO);

		JLabel label_4 = new JLabel("");
		panelCENTRAL.add(label_4);

		JLabel label_6 = new JLabel("");
		panelCENTRAL.add(label_6);

		JLabel lblCONTRASEÑA = new JLabel("Contraseña:");
		lblCONTRASEÑA.setHorizontalAlignment(SwingConstants.CENTER);
		lblCONTRASEÑA.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelCENTRAL.add(lblCONTRASEÑA);
		lblCONTRASEÑA.setLabelFor(passwordField);

		JLabel label_7 = new JLabel("");
		panelCENTRAL.add(label_7);

		JLabel label_10 = new JLabel("");
		panelCENTRAL.add(label_10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		panelCENTRAL.add(passwordField);

		JLabel label_11 = new JLabel("");
		panelCENTRAL.add(label_11);

		JLabel lblNewLabel = new JLabel("");
		panelCENTRAL.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		panelCENTRAL.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		panelCENTRAL.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		panelCENTRAL.add(lblNewLabel_3);

		JButton btnINGRESAR = new JButton("Ingresar");
		btnINGRESAR.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panelCENTRAL.add(btnINGRESAR);
		btnINGRESAR.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String usuario = textUSUARIO.getText();
		        String clave = new String(passwordField.getPassword());
		        LUsuario x = new LUsuario();		        
		        boolean ingreso = false;		        
		        if (!usuario.isEmpty() && !clave.isEmpty()) {
		            ingreso = x.verificarCredenciales(usuario, clave);
		        }		        
		        if (ingreso==true) {
		            removeAll();
		            PanelMenuPrincipal n = new PanelMenuPrincipal();
		            add(n);
		            revalidate();
		            repaint();
		        } else {
		            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta.");
		            textUSUARIO.setText("");
		            passwordField.setText("");
		            textUSUARIO.requestFocusInWindow();
		            removeAll();
		            PanelUsuarioIngresar n = new PanelUsuarioIngresar();
					add(n);
					revalidate();
					repaint();
		        }
		    }
		});


		JPanel panelIZQUIERDA = new JPanel();
		panelIZQUIERDA.setBackground(new Color(0, 0, 160));
		add(panelIZQUIERDA, BorderLayout.WEST);

		JPanel panelDERECHA = new JPanel();
		panelDERECHA.setBackground(new Color(0, 0, 160));
		add(panelDERECHA, BorderLayout.EAST);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
