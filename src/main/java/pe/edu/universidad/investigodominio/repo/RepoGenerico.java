package pe.edu.universidad.investigodominio.repo;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.edu.universidad.investigodominio.util.UtilClases;

@Repository
public class RepoGenerico {

	private static final String strPackDominio = "pe.edu.universidad.investigodominio.dominio.";
	
    @PersistenceContext
    private EntityManager entityManager;

    public <T, ID extends Serializable> Optional<T> selectById(String entidadNombre, int id) {
    	Class<T> entityClass = UtilClases.obtenerClase(strPackDominio+entidadNombre);
        T entity = entityManager.find(entityClass, id);
        return Optional.ofNullable(entity);
    }
    
    public Object insert(String entidadNombre, Map<String, Object> map) {
    	Object obj = UtilClases.obtenerObjeto(strPackDominio+entidadNombre, map);
		entityManager.persist(obj);
		return obj;
	}
    
	public Object updateById(Object obj, int id) {
		
		return obj;
	}
}