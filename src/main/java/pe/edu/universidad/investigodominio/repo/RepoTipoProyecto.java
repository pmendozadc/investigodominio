package pe.edu.universidad.investigodominio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.universidad.investigodominio.dominio.TipoProyecto;

public interface RepoTipoProyecto extends JpaRepository<TipoProyecto, Integer> {

}
