package pe.edu.cibertec.T1.service;

import pe.edu.cibertec.T1.model.Cliente;

import java.util.List;

public interface IClienteService {
    public List<Cliente> listarClientes();

    public Cliente obtenerCliente(Integer id);

    public Cliente registrarCliente(Cliente cliente);

    public Cliente modificarCliente(Cliente cliente);

    public String eliminarCliente(Integer id);
}
