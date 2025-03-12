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

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEliminar extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private LoginControlador cont;
	JComboBox comboBoxUsuarios;
	JButton btnEliminar;
	
	
	public VentanaEliminar(JFrame parent, LoginControlador cont) {
		this.cont=cont;
		setTitle("VentanaEliminar");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		comboBoxUsuarios = new JComboBox();
		comboBoxUsuarios.setBounds(111, 93, 195, 33);
		contentPanel.add(comboBoxUsuarios);
		comboBoxActualizar(comboBoxUsuarios);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(106, 166, 212, 46);
		contentPanel.add(btnEliminar);
		btnEliminar.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("Elije el usuario a borrar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(94, 11, 230, 33);
		contentPanel.add(lblNewLabel);
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==btnEliminar)
		{
			borrarUsuario();
		}
	}
	
	private void comboBoxActualizar(JComboBox<String> comboBoxUsuarios)
	{
		for(Usuario i: cont.consultaUsuarios().values())
		{
			comboBoxUsuarios.addItem(i.getNombre());
		}
	}
	
	private void borrarUsuario()
	{
		String nombreUsuario;
		
		nombreUsuario = (String) comboBoxUsuarios.getSelectedItem();
		
		if(cont.borrarUsuario(nombreUsuario))
		{
			JOptionPane.showMessageDialog(this, "Usuario Eliminado");
			 comboBoxUsuarios.removeAllItems(); // Refrescar ComboBox
			 comboBoxActualizar(comboBoxUsuarios);
		}else
		{
			JOptionPane.showMessageDialog(this, "Error al eliminar Usuario","Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
