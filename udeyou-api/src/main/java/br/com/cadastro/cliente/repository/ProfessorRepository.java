package br.com.cadastro.cliente.repository;

import br.com.cadastro.cliente.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    @Query("select n from Professor n where n.nome like %?1%")
    List<Professor> findServicoByTitulo(String nome);
}
