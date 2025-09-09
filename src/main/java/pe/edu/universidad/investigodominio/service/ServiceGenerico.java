package pe.edu.universidad.investigodominio.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pe.edu.universidad.investigodominio.dominio.Proyecto;
import pe.edu.universidad.investigodominio.repo.RepoGenerico;
import pe.edu.universidad.investigodominio.util.UtilClases;

@Service
public class ServiceGenerico {

	@Autowired
	private RepoGenerico repoGenerico;
	
	public Optional read(String entidadNombre, int id) {
		Optional opt = repoGenerico.selectById(entidadNombre, id);
		return opt;
	}
	
	public Object insert(String entidadNombre, Map<String, Object> map) {
		Object obj = repoGenerico.insert(entidadNombre, map);
		return obj;
	}
	
	
}
