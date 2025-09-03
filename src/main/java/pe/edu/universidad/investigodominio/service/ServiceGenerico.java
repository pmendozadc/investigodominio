package pe.edu.universidad.investigodominio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pe.edu.universidad.investigodominio.dominio.Proyecto;
import pe.edu.universidad.investigodominio.repo.RepoGenerico;

@Service
public class ServiceGenerico {

	private static final String strPackDominio = "pe.edu.universidad.investigodominio.dominio.";
	
	@Autowired
	private RepoGenerico repoGenerico;
	
	public Optional read(String entidadNombre, int id) {
		Class aclass = null;
		try {
			aclass = Class.forName(strPackDominio+entidadNombre);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		Optional opt = repoGenerico.findById(aclass, id);
		return opt;
	}
}
