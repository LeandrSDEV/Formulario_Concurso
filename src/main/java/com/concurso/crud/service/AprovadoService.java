package com.concurso.crud.service;

import com.concurso.crud.model.Aprovado;
import com.concurso.crud.repository.AprovadoRepository;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AprovadoService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final AprovadoRepository repository;

    public AprovadoService(AprovadoRepository repository) {
        this.repository = repository;
    }

    public Aprovado salvar(Aprovado aprovado, MultipartFile imagem) throws Exception {
        if (!imagem.isEmpty()) {
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            Path path = Path.of(uploadDir, imagem.getOriginalFilename());
            Files.write(path, imagem.getBytes());

            aprovado.setImagemPath(path.toString());
        }
        return repository.save(aprovado);
    }
}
