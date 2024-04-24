package com.example.demo.Service;

import com.example.demo.Entity.Cliente;
import com.example.demo.IRepository.IClienteRepository;
import com.example.demo.IService.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void update(Cliente cliente, Long id) {
        Optional<Cliente> ps=clienteRepository.findById(id);
        if (clienteRepository.existsById(id)) {
            Cliente clienteUpdate=ps.get();
            clienteUpdate.setNombre(cliente.getNombre());
            clienteUpdate.setCorreoElectronico(cliente.getCorreoElectronico());
            clienteRepository.save(cliente);
        } else {
           
        }
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
