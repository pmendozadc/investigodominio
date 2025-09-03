package pe.edu.universidad.investigodominio.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.universidad.investigodominio.dominio.Proyecto;

public interface RepoProyecto extends JpaRepository<Proyecto, Integer> {

}
