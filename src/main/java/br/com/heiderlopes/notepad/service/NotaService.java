package br.com.heiderlopes.notepad.service;

import br.com.heiderlopes.notepad.model.Nota;
import br.com.heiderlopes.notepad.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    @Autowired
    NotaRepository notaRepository;

    public void salvar(Nota nota) {
        Nota aux = notaRepository.findByTitulo(nota.getTitulo());
        if(aux != null) {
            nota.setId(aux.getId());
        }
        notaRepository.save(nota);
    }

    public List<Nota> buscarTodas() {
        List<Nota> notas = notaRepository.findAll();
        return notaRepository.findAll();
    }

    public Nota buscar(String titulo) {
        return notaRepository.findByTitulo(titulo);
    }
}
