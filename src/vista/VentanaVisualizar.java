package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;

public class VentanaVisualizar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBoxUsuarios;
	private LoginControlador cont;
	
	public VentanaVisualizar(JFrame parent, LoginControlador cont) {
		this.cont= cont;
		setTitle("Ventana Visualizar");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel labelUsuario = new JLabel("Usuarios");
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setBounds(135, 11, 153, 29);
		contentPanel.add(labelUsuario);
		
		comboBoxUsuarios = new JComboBox();
		comboBoxUsuarios.setBounds(124, 77, 167, 29);
		contentPanel.add(comboBoxUsuarios);
		comboBoxVisualizarUsuarios(comboBoxUsuarios);
	}
	
	private void comboBoxVisualizarUsuarios(JComboBox<String> comboBoxUsuarios)
	{
		for(Usuario i: cont.consultaUsuarios().values())
		{
			comboBoxUsuarios.addItem(i.getNombre());
		}
	}
}
