package pe.edu.universidad.investigodominio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.universidad.investigodominio.dominio.DocumentoProyecto;

public interface RepoDocumentoProyecto extends JpaRepository<DocumentoProyecto, Integer> {

}
