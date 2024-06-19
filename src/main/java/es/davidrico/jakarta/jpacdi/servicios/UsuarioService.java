package es.davidrico.jakarta.jpacdi.servicios;

import es.davidrico.jakarta.jpacdi.modelos.entities.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password);
}
