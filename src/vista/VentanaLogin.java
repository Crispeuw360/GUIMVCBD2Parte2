package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import modelo.Usuario;

import javax.swing.JLabel;

public class VentanaLogin extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoUsuario;
	private JPasswordField campoContrasena;
	private JButton btnLogin;
	private JLabel lblNewLabel_1;
	private LoginControlador cont;

	public VentanaLogin(LoginControlador controlador) {
		this.cont=controlador;
		setTitle("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(197, 97, 96, 19);
		contentPane.add(campoUsuario);
		campoUsuario.setColumns(10);
		
		campoContrasena = new JPasswordField();
		campoContrasena.setBounds(200, 148, 105, 19);
		contentPane.add(campoContrasena);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(160, 209, 85, 21);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(78, 100, 109, 16);
		contentPane.add(lblNewLabel);
		
		JLabel Contarseña = new JLabel("Contarseña");
		Contarseña.setBounds(78, 151, 109, 16);
		contentPane.add(Contarseña);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(78, 240, 274, 23);
		contentPane.add(lblNewLabel_1);
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnLogin) {
		 if (cont.comprobarUsuario(new Usuario (campoUsuario.getText(),new String(campoContrasena.getPassword())))) {
			 lblNewLabel_1.setText("Usuario Logeado");
			 VentanaOpciones v=new  VentanaOpciones(cont);
			 v.setVisible(true);
			 
		 }else {
			 lblNewLabel_1.setText("Usuario no encontrado");
		 }
		}
		
	}
}
