package com.example.demo.Controller;

import com.example.demo.Entity.Reserva;
import com.example.demo.IService.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    @Autowired
    private IReservaService reservaService;

    @GetMapping()
    public List<Reserva> findAll() {
        return reservaService.findAll();
    }

    @GetMapping("/{id}")
    public Reserva findById(@PathVariable Long id) {
        return reservaService.findById(id)
                .orElseThrow(() -> new RuntimeException("com.example.demo.Entity.Reserva no encontrada con ID: " + id));
    }

    @PostMapping()
    public Reserva create(@RequestBody Reserva reserva) {
        return reservaService.save(reserva);
    }

    @PutMapping("/{id}")
    public Reserva update(@PathVariable Long id, @RequestBody Reserva reserva) {
        reservaService.update(reserva, id);
        return reserva;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reservaService.delete(id);
    }
}
