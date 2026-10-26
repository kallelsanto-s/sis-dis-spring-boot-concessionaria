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

import br.com.unicuritiba.concessionaria.models.Peca;
import br.com.unicuritiba.concessionaria.repositories.PecaRepository;

@RestController
@RequestMapping("/pecas")
public class PecaController {

    @Autowired
    private PecaRepository pecaRepository;

    @GetMapping
    public List<Peca> listar() {
        return pecaRepository.findAll();
    }

    @PostMapping
    public Peca inserir(@RequestBody Peca peca) {
        return pecaRepository.save(peca);
    }

    @GetMapping("/{id}")
    public Peca buscarPorId(@PathVariable long id) {
        Optional<Peca> peca = pecaRepository.findById(id);
        return peca.orElse(null);
    }

    @PutMapping("/{id}")
    public Peca atualizar(@PathVariable long id, @RequestBody Peca pecaAtualizada) {
        if (pecaRepository.existsById(id)) {
            pecaAtualizada.setId(id);
            return pecaRepository.save(pecaAtualizada);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id) {
        pecaRepository.deleteById(id);
    }
}