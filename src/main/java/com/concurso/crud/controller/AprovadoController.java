package com.concurso.crud.controller;

import com.concurso.crud.model.Aprovado;
import com.concurso.crud.service.AprovadoService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/aprovados")
@CrossOrigin("*")
public class AprovadoController {

    private final AprovadoService service;

    public AprovadoController(AprovadoService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> salvar(
        @RequestParam String nome,
        @RequestParam String email,
        @RequestParam String telefone,
        @RequestParam String concursosAprovados,
        @RequestParam MultipartFile imagem
    ) throws Exception {

        Aprovado aprovado = new Aprovado();
        aprovado.setNome(nome);
        aprovado.setEmail(email);
        aprovado.setTelefone(telefone);
        aprovado.setConcursosAprovados(concursosAprovados);

        return ResponseEntity.ok(service.salvar(aprovado, imagem));
    }
}
