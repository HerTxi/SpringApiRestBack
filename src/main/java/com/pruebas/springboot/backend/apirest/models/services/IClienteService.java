package com.pruebas.springboot.backend.apirest.models.services;

import java.util.List;
import com.pruebas.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
	
	public List<Cliente> findByNombre(String nombre);
	
	public List<Cliente> findByApellido(String apellido);
	
	public List<Cliente> findByEmail(String email);
	
	public List<Cliente> findByNombreOrApellidoOrEmail(String nombre, String apellido, String email);
}

