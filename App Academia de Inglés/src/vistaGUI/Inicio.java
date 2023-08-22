package vistaGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Inicio {

	private JFrame frame;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 554, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PanelPrincipal panelprincipal = new PanelPrincipal();
		frame.getContentPane().add(panelprincipal, BorderLayout.CENTER);
		
		//PanelUsuarioIngresar panelu = new PanelUsuarioIngresar();
		//frame.getContentPane().add(panelu, BorderLayout.CENTER);
		
	
		
	}

}
