package pe.edu.cibertec.T1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.T1.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Integer> {
}
