package br.com.aweb.crud_aluno.repository;

import br.com.aweb.crud_aluno.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    // Métodos extras se precisar, ex: findByNome
}
