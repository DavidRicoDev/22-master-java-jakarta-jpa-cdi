package es.davidrico.jakarta.jpacdi.servicios;

import jakarta.inject.Inject;
import es.davidrico.jakarta.jpacdi.configuracion.Service;
import es.davidrico.jakarta.jpacdi.interceptores.TransactionalJpa;
import es.davidrico.jakarta.jpacdi.modelos.entities.Usuario;
import es.davidrico.jakarta.jpacdi.repositorios.RepositoryJpa;
import es.davidrico.jakarta.jpacdi.repositorios.UsuarioRepository;

import java.util.Optional;

@Service
@TransactionalJpa
public class UsuarioServiceImpl implements UsuarioService{
    private UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioServiceImpl(@RepositoryJpa UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username)).filter(u -> u.getPassword().equals(password));
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
