package pe.edu.cibertec.T1.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pe.edu.cibertec.T1.controller.ClienteController;
import pe.edu.cibertec.T1.model.Cliente;
import pe.edu.cibertec.T1.model.TipoCliente;
import pe.edu.cibertec.T1.service.impl.ClienteServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@WebMvcTest(ClienteControllerTest.class)
class ClienteControllerTest {

    @InjectMocks
    private ClienteController clienteController;

    @Mock
    private ClienteServiceImpl clienteServiceImpl;

    @BeforeEach
    void setup() {
        clienteController = new ClienteController(clienteServiceImpl);
    }

    @Test
    void listarClientes() {
        List<Cliente> clienteList = generarListaClientes();

        when(clienteServiceImpl.listarClientes()).thenReturn(clienteList);
        ResponseEntity<?> responseEntity = clienteController.listarClientes();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        List<Cliente> clientesResponse = (List<Cliente>) responseEntity.getBody();
        assertEquals(3, clientesResponse.size());
    }

    @Test
    void obtenerCliente() {
        Cliente cliente = generarCliente();

        when(clienteServiceImpl.obtenerCliente(anyInt())).thenReturn(cliente);
        ResponseEntity<?> responseEntity = clienteController.obtenerCliente(1);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Cliente clienteResponse = (Cliente) responseEntity.getBody();
        assertEquals(1, clienteResponse.getId());
    }

    @Test
    void registrarCliente() {
        Cliente cliente = generarCliente();

        when(clienteServiceImpl.registrarCliente(any(Cliente.class))).thenReturn(cliente);
        ResponseEntity<?> responseEntity = clienteController.registrarCliente(cliente);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Cliente clienteResponse = (Cliente) responseEntity.getBody();
        assertEquals(1, clienteResponse.getId());
    }

    @Test
    void modificarCliente() {
        Cliente cliente = generarCliente();

        when(clienteServiceImpl.modificarCliente(any(Cliente.class))).thenReturn(cliente);
        ResponseEntity<?> responseEntity = clienteController.modificarCliente(cliente);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Cliente clienteResponse = (Cliente) responseEntity.getBody();
        assertEquals(1, clienteResponse.getId());
    }

    @Test
    void eliminarCliente() {
        when(clienteServiceImpl.eliminarCliente(anyInt())).thenReturn("El Cliente fue eliminado");
        ResponseEntity<?> responseEntity = clienteController.eliminarCliente(1);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("El Cliente fue eliminado", responseEntity.getBody());

        verify(clienteServiceImpl, times(1)).eliminarCliente(anyInt());
    }

    // Métodos auxiliares para generar datos de prueba
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