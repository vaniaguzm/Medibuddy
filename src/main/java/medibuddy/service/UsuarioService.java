package medibuddy.service;

import medibuddy.model.Usuario;
import medibuddy.repository.UsuarioRepository;
import java.util.List;

public class UsuarioService {

    private final UsuarioRepository repository = new UsuarioRepository();

    public void crearUsuario(Usuario usuario) {
        repository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    public Usuario buscarUsuarioPorId(int id) {
        return repository.findById(id);
    }

    public void actualizarUsuario(Usuario usuario) {
        repository.update(usuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        repository.delete(usuario);
    }
}
