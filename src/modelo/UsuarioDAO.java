package modelo;

import java.util.Map;

public interface UsuarioDAO {
	public boolean comprobarUsuario(Usuario usuario);
	public Map<String, Usuario> consultaUsuarios();
	
}
