package pe.edu.universidad.investigodominio.repo;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepoGenerico {

    @PersistenceContext
    private EntityManager entityManager;

    public <T, ID extends Serializable> Optional<T> findById(Class<T> entityClass, ID id) {
        T entity = entityManager.find(entityClass, id);
        return Optional.ofNullable(entity);
    }
}