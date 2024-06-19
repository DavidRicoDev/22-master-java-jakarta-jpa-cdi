package es.davidrico.jakarta.jpacdi.servicios;

import es.davidrico.jakarta.jpacdi.modelos.entities.Categoria;
import es.davidrico.jakarta.jpacdi.modelos.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();

    Optional<Producto> porId(Long id);

    void guardar(Producto producto);

    void eliminar(Long id);

    List<Categoria> listarCategoria();

    Optional<Categoria> porIdCategoria(Long id);
}
