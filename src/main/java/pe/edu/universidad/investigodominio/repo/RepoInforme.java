package pe.edu.universidad.investigodominio.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.universidad.investigodominio.dominio.Informe;

public interface RepoInforme extends JpaRepository<Informe, Integer> {

}
