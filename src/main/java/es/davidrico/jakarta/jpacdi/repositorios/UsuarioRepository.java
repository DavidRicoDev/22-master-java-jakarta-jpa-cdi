package es.davidrico.jakarta.jpacdi.repositorios;

import es.davidrico.jakarta.jpacdi.modelos.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario> {
    Usuario porUsername(String username) throws Exception;
}
