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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaModificar extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldUsuario;
	private JTextField textFieldContraseña;
	private JComboBox comboBoxUsuarios;
	private JButton btnModificar;
	private LoginControlador cont;

	
	public VentanaModificar(JFrame parent, LoginControlador cont) {
		this.cont = cont;
		setTitle("Ventana Modificar");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Selecciona el usuario a modifcar");
			lblNewLabel.setBounds(111, 11, 195, 33);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(lblNewLabel);
		}
		{
			comboBoxUsuarios = new JComboBox();
			comboBoxUsuarios.setBounds(104, 55, 202, 33);
			contentPanel.add(comboBoxUsuarios);
			comboBoxActualizar(comboBoxUsuarios);
		}
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(102, 144, 226, 20);
		contentPanel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setBounds(102, 186, 226, 20);
		contentPanel.add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setBounds(10, 146, 82, 17);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1.setBounds(10, 188, 82, 17);
		contentPanel.add(lblNewLabel_1_1);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(160, 227, 108, 23);
		contentPanel.add(btnModificar);
		btnModificar.addActionListener(this); 
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==btnModificar)
		{
			modificarUsuario();
		}
	}
	
	private void comboBoxActualizar(JComboBox<String> comboBoxUsuarios)
	{
		for(Usuario i: cont.consultaUsuarios().values())
		{
			comboBoxUsuarios.addItem(i.getNombre());
		}
	}
	
	private void modificarUsuario()
	{
		String nuevoNombre,nuevaContraseña,nombreActual;
		
		nombreActual = (String) comboBoxUsuarios.getSelectedItem();
		nuevoNombre = textFieldUsuario.getText().trim();
		nuevaContraseña = textFieldContraseña.getText().trim();
		
		if(nuevoNombre != null&& !nuevoNombre.isEmpty()&&!nuevaContraseña.isEmpty())
		{
			 Usuario usuarioNuevo = new Usuario(nuevoNombre, nuevaContraseña);
			 
			 if(cont.actualizarUsuario(nombreActual, usuarioNuevo))
			 {
				 JOptionPane.showMessageDialog(this, "Usuario modificado correctamente.");
				 comboBoxUsuarios.removeAllItems(); // Refrescar ComboBox
				 comboBoxActualizar(comboBoxUsuarios);
			 }else
			 {
				 JOptionPane.showMessageDialog(this, "Error al modificar usuario","Error",JOptionPane.ERROR_MESSAGE);
			 }
		}else
		{
			 JOptionPane.showMessageDialog(this, "Debe completar todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}
}
