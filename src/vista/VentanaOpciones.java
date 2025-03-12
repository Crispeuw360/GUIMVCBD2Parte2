package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;

public class VentanaOpciones extends JFrame implements ActionListener {

	private JPanel contentPanel;
	private JButton btnInsertar;
	private JButton btnVisualizar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private LoginControlador cont;

	
	public VentanaOpciones(LoginControlador cont) {
		this.cont= cont;
		setTitle("VentanaOpciones");
		setBounds(100, 100, 450, 300);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		getContentPane().setLayout(null);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(23, 37, 168, 54);
		getContentPane().add(btnInsertar);
		btnInsertar.addActionListener(this);
		
		btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setBounds(220, 37, 168, 54);
		getContentPane().add(btnVisualizar);
		btnVisualizar.addActionListener(this);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(23, 139, 168, 54);
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(this);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(220, 139, 168, 54);
		getContentPane().add(btnEliminar);
		contentPanel.setLayout(null);
		btnEliminar.addActionListener(this);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnInsertar)
		{
			VentanaInsertar vI = new VentanaInsertar(this,cont);
			vI.setVisible(true);
		}
		else if(e.getSource()==btnVisualizar)
		{
			VentanaVisualizar vV = new VentanaVisualizar(this,cont);
			vV.setVisible(true);
		}
		else if(e.getSource()==btnModificar)
		{
			VentanaModificar vM = new VentanaModificar(this,cont);
			vM.setVisible(true);
		}else if(e.getSource()==btnEliminar)
		{
			VentanaEliminar vE = new VentanaEliminar(this,cont);
			vE.setVisible(true);
		}
	}

}
