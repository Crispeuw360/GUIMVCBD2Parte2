package modelo;

import java.util.Map;

public interface UsuarioDAO {
	public boolean comprobarUsuario(Usuario usuario);
	public boolean insertarUsuario(Usuario usuario);
	public boolean actualizarUsuario(String nombreActual, Usuario usuarioNuevo);
	public boolean borrarUsuario(String nomrbe);
	public Map<String, Usuario> consultaUsuarios();
	
}
