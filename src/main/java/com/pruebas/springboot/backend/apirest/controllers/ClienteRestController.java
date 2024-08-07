package com.pruebas.springboot.backend.apirest.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.pruebas.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.http.HttpStatus;
import com.pruebas.springboot.backend.apirest.models.services.IClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class ClienteRestController {

    private static final Logger logger = LoggerFactory.getLogger(ClienteRestController.class);
    
	@Autowired
	private IClienteService clienteService;

	@GetMapping("/clientes")
	public List<Cliente> index(){
		
		return clienteService.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable Long id) {
		return clienteService.findById(id);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente clienteActual = clienteService.findById(id);
		
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setEmail(cliente.getEmail());
		
		return clienteService.save(clienteActual);
		
	}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.delete(id);
	}
    
    

    @GetMapping("/buscar")
    public List<Cliente> buscarClientes(@RequestParam(required = false) String nombre,
                                        @RequestParam(required = false) String apellido,
                                        @RequestParam(required = false) String email) {
        logger.info("Buscar clientes con nombre: {}, apellido: {}, email: {}", nombre, apellido, email);
//        if (nombre != null) {
//            return clienteService.findByNombre(nombre);
//        } else if (apellido != null) {
//            return clienteService.findByApellido(apellido);
//        } else if (email != null) {
//            return clienteService.findByEmail(email);
//        } else {
            return clienteService.findByNombreOrApellidoOrEmail(nombre, apellido, email);
        }
//    }
}
