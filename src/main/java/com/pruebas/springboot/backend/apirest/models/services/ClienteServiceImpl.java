package com.pruebas.springboot.backend.apirest.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pruebas.springboot.backend.apirest.models.dao.IClienteDao;
import com.pruebas.springboot.backend.apirest.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findByNombre(String nombre) {
        return clienteDao.findByNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findByApellido(String apellido) {
        return clienteDao.findByApellido(apellido);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findByEmail(String email) {
        return clienteDao.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findByNombreOrApellidoOrEmail(String nombre, String apellido, String email) {
        return clienteDao.findByNombreOrApellidoOrEmail(nombre, apellido, email);
    }
}
