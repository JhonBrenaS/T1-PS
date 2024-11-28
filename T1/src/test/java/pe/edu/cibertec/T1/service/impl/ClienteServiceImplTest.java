package pe.edu.cibertec.T1.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import pe.edu.cibertec.T1.model.Cliente;
import pe.edu.cibertec.T1.model.TipoCliente;
import pe.edu.cibertec.T1.repo.IClienteRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceImplTest {

    @InjectMocks
    private ClienteServiceImpl clienteServiceImpl;

    @Mock
    private IClienteRepo clienteRepository;

    @BeforeEach
    void setUp() {
        clienteServiceImpl = new ClienteServiceImpl(clienteRepository);
    }

    @Test
    void listarClientes() {
        List<Cliente> clientes = generarListaClientes();

        when(clienteRepository.findAll()).thenReturn(clientes);
        List<Cliente> clientesResponse = clienteServiceImpl.listarClientes();
        assertEquals(3, clientesResponse.size());
    }

    @Test
    void obtenerCliente() {
        Cliente cliente = generarCliente();

        when(clienteRepository.findById(anyInt())).thenReturn(Optional.of(cliente));
        Cliente clienteResponse = clienteServiceImpl.obtenerCliente(1);
        assertEquals(1, clienteResponse.getId());
        assertEquals("Jhon", clienteResponse.getNombre());
    }

    @Test
    void registrarCliente() {
        Cliente cliente = generarCliente();

        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        Cliente clienteResponse = clienteServiceImpl.registrarCliente(cliente);
        assertEquals(1, clienteResponse.getId());
        assertEquals("Jhon", clienteResponse.getNombre());
    }

    @Test
    void modificarCliente() {
        Cliente cliente = generarCliente();

        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        Cliente clienteResponse = clienteServiceImpl.modificarCliente(cliente);
        assertEquals(1, clienteResponse.getId());
        assertEquals("Jhon", clienteResponse.getNombre());
    }

    @Test
    void eliminarCliente() {
        doNothing().when(clienteRepository).deleteById(anyInt());
        String response = clienteServiceImpl.eliminarCliente(1);
        assertEquals("Cliente eliminado", response);
        verify(clienteRepository, times(1)).deleteById(1);
    }


    private List<Cliente> generarListaClientes() {
        TipoCliente tipoCliente = new TipoCliente();
        tipoCliente.setId(1);
        tipoCliente.setNombre("Regular");

        Cliente cliente1 = new Cliente(1, "Jhon", "Brena", "Sifuentes", "Av Mexico", "920333023", tipoCliente);
        Cliente cliente2 = new Cliente(2, "Jose", "Duran", "Perez", "Av España", "911234923", tipoCliente);
        Cliente cliente3 = new Cliente(3, "Adrian", "Machaca", "Cueva", "Av Brasil", "923458769", tipoCliente);

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        return clientes;
    }

    private Cliente generarCliente() {
        TipoCliente tipoCliente = new TipoCliente();
        tipoCliente.setId(1);
        tipoCliente.setNombre("Regular");

         return new Cliente(1, "Jhon", "Brena", "Sifuentes", "Av Mexico", "920333023", tipoCliente);
    }
}