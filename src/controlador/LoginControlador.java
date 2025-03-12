package controlador;

import modelo.ImplementacionBD;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.VentanaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class LoginControlador {
	UsuarioDAO dao = new ImplementacionBD();
	
	public void visualizarPantalla() {
		VentanaLogin ven = new VentanaLogin(this);
		ven.setVisible(true);	
	}
	public boolean comprobarUsuario(Usuario usuario){
		return dao.comprobarUsuario(usuario);	
	}
	public Map<String, Usuario> consultaUsuarios() {
		return dao.consultaUsuarios();
	}
	public boolean insertarUsuario(Usuario usuario) {
		return dao.insertarUsuario(usuario);
	}
	public boolean actualizarUsuario(String nombreActual, Usuario usuarioNuevo) {
		return dao.actualizarUsuario(nombreActual,usuarioNuevo);
	}
	public boolean borrarUsuario(String nombre)
	{
		return dao.borrarUsuario(nombre);
	}


}