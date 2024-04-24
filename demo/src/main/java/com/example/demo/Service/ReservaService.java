package com.example.demo.Service;

import com.example.demo.Entity.Reserva;
import com.example.demo.IRepository.IReservaRepository;
import com.example.demo.IService.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService implements IReservaService {

    @Autowired
    private IReservaRepository reservaRepository;

    @Override
    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id);
    }

    @Override
    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public void update(Reserva reserva, Long id) {
        Optional<Reserva> optionalReserva = reservaRepository.findById(id);
        if (optionalReserva.isPresent()) {
            Reserva reservaUpdate = optionalReserva.get();
            reservaUpdate.setFechaEntrada(reserva.getFechaEntrada());
            reservaUpdate.setFechaSalida(reserva.getFechaSalida());
            reservaUpdate.setCliente(reserva.getCliente());
            reservaRepository.save(reservaUpdate);
        } else {
            
        }
    }

    @Override
    public void delete(Long id) {
        reservaRepository.deleteById(id);
    }
}
