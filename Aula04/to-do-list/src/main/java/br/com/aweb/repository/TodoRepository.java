package br.com.aweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aweb.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
    
}
