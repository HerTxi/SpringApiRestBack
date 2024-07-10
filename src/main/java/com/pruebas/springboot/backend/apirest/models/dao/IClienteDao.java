package com.pruebas.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.pruebas.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long> {
    
    List<Cliente> findByNombre(String nombre);
    
    List<Cliente> findByApellido(String apellido);
    
    List<Cliente> findByEmail(String email);

    @Query("SELECT c FROM Cliente c WHERE (:nombre IS NULL OR c.nombre = :nombre) AND (:apellido IS NULL OR c.apellido = :apellido) AND (:email IS NULL OR c.email = :email)")
    List<Cliente> findByNombreOrApellidoOrEmail(String nombre, String apellido, String email);
}
