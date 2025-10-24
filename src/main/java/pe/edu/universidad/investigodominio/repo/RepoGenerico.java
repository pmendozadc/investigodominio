package pe.edu.universidad.investigodominio.repo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import pe.edu.universidad.investigodominio.exception.EstructuraInvalidaException;
import pe.edu.universidad.investigodominio.util.UtilClases;

@Repository
public class RepoGenerico {

	private static final String strPackDominio = "pe.edu.universidad.investigodominio.dominio.";

	private static final String strEstado = "estado";
	private static final String strActivo = "activo";
	private static final String strOp = "op";
	private static final String strRet = "ret";
	private static final String strEntidad = "entidad";
	private static final String strObj = "obj";
	private static final String strC = "c";
	private static final String strR = "r";
	private static final String strU = "u";
	private static final String strD = "d";
	private static final String strQ = "q";
	private static final String strDh = "dh";
	private static final String strA = "a";
	private static final String strI = "i";
	private static final String strId = "id";
	private static final String strTrue = "true";
	private static final String strKey = "key";
	private static final String strVar = "var";
	private static final String strFor = "for";
	private static final String strNKey = "#key";
	private static final String strNVar = "#var";
	private static final String strSql = "sql";
	private static final String strCorcheteIni = "[";
	private static final String strCorcheteFin = "]";
	
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
		entityManager.flush();
		entityManager.refresh(obj);
		return obj;
	}
    
    @Transactional
    public <T, ID extends Serializable> Optional<T> update(String entidadNombre, Map<String, Object> map) {
    	int id = (Integer) map.get("id");
    	Class<T> entityClass = UtilClases.obtenerClase(strPackDominio+entidadNombre);
    	T entity = entityManager.find(entityClass, id);
    	if (entity != null) {
    		UtilClases.copiarData(entity, map);
    		entityManager.merge(entity);
    		entityManager.flush();
    		entityManager.refresh(entity);
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
    
    public <T, ID extends Serializable> Optional<T> consultarNativa(String sql) {
        Query query = entityManager.createNativeQuery(sql);
        return (Optional<T>) Optional.ofNullable(query.getResultList()); // Devuelve lista de Object[] cuando se consulta mas de un campo
    }
    
    @Transactional
    public List<Object> tx(List<Map<String, Object>> lstOp) {
    	List<Object> lstRet = new ArrayList<Object>();
    	Object objRetorno = null;
    	Map<String, Object> mapKeys = new HashMap<String, Object>();
    	Map<String, Object> mapVars = new HashMap<String, Object>();
    	for (Map<String,Object> mapOp : lstOp) {
			if (mapOp.get(strOp)==null) {
				throw new EstructuraInvalidaException("La peticion debe indicar el campo op para la operacion");
			}
			String op = mapOp.get(strOp).toString();
			if (op.equals(strQ)) {
				if (mapOp.get(strSql)==null) {
					throw new EstructuraInvalidaException("La peticion debe indicar el campo sql para la consulta");
				}
				String sql = mapOp.get(strSql).toString();
				List lst = (List) consultarNativa(sql).get();
				if (mapOp.get(strRet) != null && mapOp.get(strRet).toString().equals(strTrue)) {
					lstRet.add(lst);
				}
				if (mapOp.get(strVar) != null && lst != null && !lst.isEmpty()) {
					mapVars.put(mapOp.get(strVar).toString(), lst);
				}
			} else { // No es query
				if (mapOp.get(strEntidad)==null) {
					throw new EstructuraInvalidaException("La peticion debe indicar el campo entidad para la entidad/tabla");
				}
				String entidadNombre = mapOp.get(strEntidad).toString();
				if (op.equals(strC)) {
					if (mapOp.get(strObj)==null) {
						throw new EstructuraInvalidaException("La peticion debe indicar el campo obj para el objeto a operar");
					}
					if (mapOp.get(strFor)==null) {// Operacion simple, no itera
						objRetorno=insertarObjeto(entidadNombre, mapOp, mapKeys, mapVars, lstRet, null, null);
						Object objId = UtilClases.obtenerDato(objRetorno, strId);
						if (mapOp.get(strKey) != null) {
							mapKeys.put(mapOp.get(strKey).toString(), objId);
						}
					} else {// Operacion iterativa
						String var = mapOp.get(strFor).toString();
						if (mapVars.get(var) == null) {
							throw new RuntimeException("El var "+var+" no fue encontrado");
						}
						boolean tieneKey = mapOp.get(strKey)!=null;
						List<Integer> lstKey = null;
						if (tieneKey) {//los key se almacenan como var, por ser varios
							lstKey = new ArrayList<Integer>();
							mapVars.put(mapOp.get(strKey).toString(), lstKey);
						}
						Map<String, Object> mapObjVars = generarMapObjVars(mapOp);
						List lst = (List) mapVars.get(var);
						for (int i = 0; i < lst.size(); i++) {
							Object objIterado = lst.get(i);// obj podria ser un dato o un arreglo
							objRetorno=insertarObjeto(entidadNombre, mapOp, mapKeys, mapVars, lstRet, objIterado, mapObjVars);
							Object objId = UtilClases.obtenerDato(objRetorno, strId);
							if (tieneKey) {
								lstKey.add((Integer) objId);
							}
						}
					}
				} else if (op.equals(strU)) {
					if (mapOp.get(strObj)==null) {
						throw new EstructuraInvalidaException("La peticion debe indicar el campo obj para el objeto a operar");
					}
					if (mapOp.get(strFor)==null) {// Operacion simple, no itera
						objRetorno=actualizarObjeto(entidadNombre, mapOp, mapKeys, mapVars, lstRet, null, null);
					} else {// Operacion iterativa
						String var = mapOp.get(strFor).toString();
						if (mapVars.get(var) == null) {
							throw new RuntimeException("El var "+var+" no fue encontrado");
						}
						Map<String, Object> mapObjVars = generarMapObjVars(mapOp);
						List lst = (List) mapVars.get(var);
						for (int i = 0; i < lst.size(); i++) {
							Object objIterado = lst.get(i);// obj podria ser un dato o un arreglo
							objRetorno=actualizarObjeto(entidadNombre, mapOp, mapKeys, mapVars, lstRet, objIterado, mapObjVars);
						}
					}
				} else if (op.equals(strD)) {
					if (mapOp.get(strId)==null) {
						throw new EstructuraInvalidaException("La peticion debe indicar el campo id para el codigo del objeto a operar");
					}
					objRetorno=eliminarObjeto(entidadNombre, mapOp, mapKeys, mapVars, lstRet);
				} else if (op.equals(strDh)) {
					if (mapOp.get(strId)==null) {
						throw new EstructuraInvalidaException("La peticion debe indicar el campo id para el codigo del objeto a operar");
					}
					objRetorno=eliminarFisicoObjeto(entidadNombre, mapOp, mapKeys, mapVars, lstRet);
				} else if (op.equals(strA)) {
					if (mapOp.get(strId)==null) {
						throw new EstructuraInvalidaException("La peticion debe indicar el campo id para el codigo del objeto a operar");
					}
					objRetorno=activarObjeto(entidadNombre, mapOp, mapKeys, mapVars, lstRet);
				} else if (op.equals(strI)) {
					if (mapOp.get(strId)==null) {
						throw new EstructuraInvalidaException("La peticion debe indicar el campo id para el codigo del objeto a operar");
					}
					objRetorno=inactivarObjeto(entidadNombre, mapOp, mapKeys, mapVars, lstRet);
				} else {
					throw new RuntimeException("No se encontro la operacion "+op+ " como una operacion valida");
				}
			}
		}
		return lstRet;
	}

	private Object inactivarObjeto(String entidadNombre, Map<String, Object> mapOp, Map<String, Object> mapKeys,
			Map<String, Object> mapVars, List<Object> lstRet) {
		int id = 0;
		try {
			id = Integer.parseInt(mapOp.get(strId).toString());
		} catch (Exception e) {
			throw new RuntimeException("No se encontro id para la operacion "+mapOp.get(strOp).toString()+ " sobre la entidad " + entidadNombre, e);
		}
		Object objRetorno = inactivar(entidadNombre, id);
		if (mapOp.get(strRet) != null && mapOp.get(strRet).toString().equals(strTrue)) {
			lstRet.add(objRetorno);
		}
		return objRetorno;
	}

	private Object activarObjeto(String entidadNombre, Map<String, Object> mapOp, Map<String, Object> mapKeys,
			Map<String, Object> mapVars, List<Object> lstRet) {
		int id = 0;
		try {
			id = Integer.parseInt(mapOp.get(strId).toString());
		} catch (Exception e) {
			throw new RuntimeException("No se encontro id para la operacion "+mapOp.get(strOp).toString()+ " sobre la entidad " + entidadNombre, e);
		}
		Object objRetorno = activar(entidadNombre, id);
		if (mapOp.get(strRet) != null && mapOp.get(strRet).toString().equals(strTrue)) {
			lstRet.add(objRetorno);
		}
		return objRetorno;
	}

	private Object eliminarFisicoObjeto(String entidadNombre, Map<String, Object> mapOp, Map<String, Object> mapKeys,
			Map<String, Object> mapVars, List<Object> lstRet) {
		int id = 0;
		try {
			id = Integer.parseInt(mapOp.get(strId).toString());
		} catch (Exception e) {
			throw new RuntimeException("No se encontro id para la operacion "+mapOp.get(strOp).toString()+ " sobre la entidad " + entidadNombre, e);
		}
		Object objRetorno = deleteHard(entidadNombre, id);
		if (mapOp.get(strRet) != null && mapOp.get(strRet).toString().equals(strTrue)) {
			lstRet.add(objRetorno);
		}
		return objRetorno;
	}

	private Object eliminarObjeto(String entidadNombre, Map<String, Object> mapOp, Map<String, Object> mapKeys,
			Map<String, Object> mapVars, List<Object> lstRet) {
		int id = 0;
		try {
			id = Integer.parseInt(mapOp.get(strId).toString());
		} catch (Exception e) {
			throw new RuntimeException("No se encontro id para la operacion "+mapOp.get(strOp).toString()+ " sobre la entidad " + entidadNombre, e);
		}
		Object objRetorno = delete(entidadNombre, id);
		if (mapOp.get(strRet) != null && mapOp.get(strRet).toString().equals(strTrue)) {
			lstRet.add(objRetorno);
		}
		return objRetorno;
	}

	private Object actualizarObjeto(String entidadNombre, Map<String, Object> mapOp, Map<String, Object> mapKeys,
			Map<String, Object> mapVars, List<Object> lstRet, Object objIterado, Map<String, Object> mapObjVars) {
		Map<String,Object> mapObjeto = (Map<String,Object>) mapOp.get(strObj);
		llenarKeysEnObjeto(mapObjeto, mapKeys);
		if (objIterado != null) {
			llenarVarsEnObjeto(mapObjeto, objIterado, mapObjVars);
		}
		Object objRetorno = update(entidadNombre, mapObjeto);
		if (mapOp.get(strRet) != null && mapOp.get(strRet).toString().equals(strTrue)) {
			lstRet.add(objRetorno);
		}
		return objRetorno;
	}

	private Object insertarObjeto(String entidadNombre, Map<String, Object> mapOp, Map<String, Object> mapKeys,
			Map<String, Object> mapVars, List<Object> lstRet, Object objIterado, Map<String, Object> mapObjVars) {
		Map<String,Object> mapObjeto = (Map<String,Object>) mapOp.get(strObj);
		llenarKeysEnObjeto(mapObjeto, mapKeys);
		if (objIterado != null) {
			llenarVarsEnObjeto(mapObjeto, objIterado, mapObjVars);
		}
		Object objRetorno = insert(entidadNombre, mapObjeto);
		if (mapOp.get(strRet) != null && mapOp.get(strRet).toString().equals(strTrue)) {
			lstRet.add(objRetorno);
		}
		return objRetorno;
	}

	private void llenarKeysEnObjeto(Map<String, Object> mapObjeto, Map<String, Object> mapKeys) {
		for (String k : mapObjeto.keySet()) {
			if (mapObjeto.get(k)!=null && mapObjeto.get(k).toString().startsWith(strNKey)) {
				String key = mapObjeto.get(k).toString().substring(4);
				if (mapKeys.get(key) != null) {
					mapObjeto.replace(k, mapKeys.get(key));
				} else {
					throw new RuntimeException("El key "+key+" no fue encontrado");
				}
			}
		}
	}
	
	private void llenarVarsEnObjeto(Map<String, Object> mapObjeto, Object objIterado, Map<String, Object> mapObjVars) {
		for (String k : mapObjVars.keySet()) {// Se restablecen valores de vars del mapa
			mapObjeto.replace(k, mapObjVars.get(k));
		}
		for (String k : mapObjeto.keySet()) {
			if (mapObjeto.get(k)!=null && mapObjeto.get(k).toString().startsWith(strNVar)) {
				String cadenaValor = mapObjeto.get(k).toString();
				Object valor = null;
				if (cadenaValor.contains(strCorcheteIni)) {// tiene indice, eg #var[2], se tratara como un array
					if (!objIterado.getClass().isArray()) {
						throw new RuntimeException("Se esperaba un arreglo en un valor indexado en el objeto " + mapObjeto);
					}
					Object[] array = (Object[]) objIterado; 
					try {
						String strIndice = cadenaValor.substring(cadenaValor.indexOf(strCorcheteIni)+1, cadenaValor.indexOf(strCorcheteFin));
						int indice = Integer.parseInt(strIndice);
						if (indice >= array.length) {
							throw new RuntimeException("Un indice esta fuera de rango en el objeto " + mapObjeto);
						}
						valor = array[indice];
					} catch (Exception e) {
						throw new RuntimeException("Ocurrio un error al acceder al indice de un valor en el objeto " + mapObjeto);
					}
				} else {// no tiene indice, se tratara como un valor 
					valor = objIterado;
				}
				mapObjeto.replace(k, valor);
			}
		}
	}
	
	private Map<String, Object> generarMapObjVars(Map<String, Object> mapOp) {
		Map<String, Object> mapObjVars = new HashMap<String, Object>();
		Map<String, Object> mapObj = (Map<String, Object>) mapOp.get(strObj);
		for (String k : mapObj.keySet()) {
			if (mapObj.get(k)!=null && mapObj.get(k).toString().startsWith(strNVar)) {
				mapObjVars.put(k, mapObj.get(k));
			}
		}
		return mapObjVars;
	}

}