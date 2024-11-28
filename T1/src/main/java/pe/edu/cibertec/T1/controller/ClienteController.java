package pe.edu.cibertec.T1.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.T1.model.Cliente;
import pe.edu.cibertec.T1.service.IClienteService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/cliente")
public class ClienteController {
    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public ResponseEntity<?> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return new ResponseEntity<>(clientes, clientes.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> obtenerCliente(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(clienteService.obtenerCliente(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> registrarCliente(@RequestBody Cliente cliente) {
        Cliente newCliente = clienteService.registrarCliente(cliente);
        return new ResponseEntity<Cliente>(newCliente, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> modificarCliente(@RequestBody Cliente cliente) {
        Cliente newCliente = clienteService.modificarCliente(cliente);
        return new ResponseEntity<Cliente>(newCliente, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(clienteService.eliminarCliente(id), HttpStatus.OK);
    }
}
