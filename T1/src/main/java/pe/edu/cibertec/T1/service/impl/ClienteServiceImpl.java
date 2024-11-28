package pe.edu.cibertec.T1.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.T1.model.Cliente;
import pe.edu.cibertec.T1.repo.IClienteRepo;
import pe.edu.cibertec.T1.service.IClienteService;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    private IClienteRepo clienteRepo;

    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

    public Cliente obtenerCliente(Integer id) {
        return clienteRepo.findById(id).get();
    }

    public Cliente registrarCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    public Cliente modificarCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    public String eliminarCliente(Integer id) {
        clienteRepo.deleteById(id);
        return "Cliente eliminado";
    }

}
