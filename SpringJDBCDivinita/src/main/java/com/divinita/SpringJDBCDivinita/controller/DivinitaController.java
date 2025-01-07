package com.divinita.SpringJDBCDivinita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.divinita.SpringJDBCDivinita.model.Divinita;
import com.divinita.SpringJDBCDivinita.repo.DivineRepo;

@Controller
@RequestMapping("/divinita")
public class DivinitaController {

    @Autowired
    private DivineRepo repo;

    @GetMapping
    public List<Divinita> getAllDivinita() {
        return repo.findAll();
    }

    @PostMapping
    public Divinita addDivinita(@RequestBody Divinita divinita) {
        repo.save(divinita);
        return divinita;
    }

    @PutMapping("/{id}")
    public Divinita updateDivinita(@PathVariable int id, @RequestBody Divinita divinita) {
        divinita.setId(id);
        repo.save(divinita);
        return divinita;
    }

    @DeleteMapping("/{id}")
    public String deleteDivinita(@PathVariable int id, @RequestBody Divinita divinita) {
        repo.deleteById(divinita);
        return "Divinita con id " + id + " eliminata.";
    }

}