package pe.edu.universidad.investigodominio.repo;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import pe.edu.universidad.investigodominio.util.UtilClases;

@Repository
public class RepoGenerico {

	private static final String strPackDominio = "pe.edu.universidad.investigodominio.dominio.";

	private static final String strEstado = "estado";
	private static final String strActivo = "activo";
	
    @PersistenceContext
    private EntityManager entityManager;

    public <T, ID extends Serializable> Optional<T> selectById(String entidadNombre, int id) {
    	Class<T> entityClass = UtilClases.obtenerClase(strPackDominio+entidadNombre);
        T entity = entityManager.find(entityClass, id);
        return Optional.ofNullable(entity);
    }

    @Transactional
    public Object insert(String entidadNombre, Map<String, Object> map) {
    	Object obj = UtilClases.obtenerObjeto(strPackDominio+entidadNombre, map);
		entityManager.persist(obj);
		return obj;
	}
    
    @Transactional
    public <T, ID extends Serializable> Optional<T> update(String entidadNombre, Map<String, Object> map) {
    	int id = (Integer) map.get("id");
    	Class<T> entityClass = UtilClases.obtenerClase(strPackDominio+entidadNombre);
    	T entity = entityManager.find(entityClass, id);
    	if (entity != null) {
    		UtilClases.copiarData(entity, map);
    		entityManager.persist(entity); //Josshua: FIXME: Sugiero un cambio, .persist() solo se debe usar para guardar una nueva entidad, para realizar actualizaciones se recomienda usar .merge()
    	}
		return Optional.ofNullable(entity);
	}
    
    @Transactional
    public <T, ID extends Serializable> Optional<T> delete(String entidadNombre, int id) {
    	Class<T> entityClass = UtilClases.obtenerClase(strPackDominio+entidadNombre);
    	T entity = entityManager.find(entityClass, id);
    	if (entity != null) {
    		UtilClases.establecerDato(entity, strEstado, false);
    		entityManager.persist(entity);
    	}
		return Optional.ofNullable(entity);
	}
    
    @Transactional
    public <T, ID extends Serializable> Optional<T> deleteHard(String entidadNombre, int id) {
    	Class<T> entityClass = UtilClases.obtenerClase(strPackDominio+entidadNombre);
    	T entity = entityManager.find(entityClass, id);
    	if (entity != null) {
    		entityManager.remove(entity);
    	}
		return Optional.ofNullable(entity);
	}
    
    @Transactional
    public <T, ID extends Serializable> Optional<T> activar(String entidadNombre, int id) {
    	Class<T> entityClass = UtilClases.obtenerClase(strPackDominio+entidadNombre);
    	T entity = entityManager.find(entityClass, id);
    	if (entity != null) {
    		UtilClases.establecerDato(entity, strActivo, true);
    		entityManager.persist(entity);
    	}
		return Optional.ofNullable(entity);
	}
    
    @Transactional
    public <T, ID extends Serializable> Optional<T> inactivar(String entidadNombre, int id) {
    	Class<T> entityClass = UtilClases.obtenerClase(strPackDominio+entidadNombre);
    	T entity = entityManager.find(entityClass, id);
    	if (entity != null) {
    		UtilClases.establecerDato(entity, strActivo, false);
    		entityManager.persist(entity);
    	}
		return Optional.ofNullable(entity);
	}
}