package br.com.unicuritiba.concessionaria.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicuritiba.concessionaria.models.Modelo;
import br.com.unicuritiba.concessionaria.repositories.ModeloRepository;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    @Autowired
    private ModeloRepository modeloRepository;

    @GetMapping
    public List<Modelo> listar() {
        return modeloRepository.findAll();
    }

    @PostMapping
    public Modelo inserir(@RequestBody Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    @GetMapping("/{id}")
    public Modelo buscarPorId(@PathVariable long id) {
        Optional<Modelo> modelo = modeloRepository.findById(id);
        return modelo.orElse(null);
    }

    @PutMapping("/{id}")
    public Modelo atualizar(@PathVariable long id, @RequestBody Modelo modeloAtualizado) {
        if (modeloRepository.existsById(id)) {
            modeloAtualizado.setId(id);
            return modeloRepository.save(modeloAtualizado);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id) {
        modeloRepository.deleteById(id);
    }
}