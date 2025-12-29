package com.concurso.crud.repository;

import com.concurso.crud.model.Aprovado;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AprovadoRepository extends JpaRepository<Aprovado, Long> {
}