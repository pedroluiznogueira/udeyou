package br.com.cadastro.cliente.repository;
import br.com.cadastro.cliente.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    @Query("select c from Curso c where c.titulo like %?1%")
    List<Curso> findCursoByTitulo(String titulo);

    @Query(value = "select * from Curso where professor_id = ?1", nativeQuery = true)
    List<Curso> findCursoByProfessor(Long id);

    @Query(value = "select curso_id from curso_wishlist where wishlist_id = ?1", nativeQuery = true)
    List<Long> findCursosIdByWishlistId(Long id);

    @Query(value = "select * from Curso where id = ?1", nativeQuery = true)
    Curso findCursoById(Long id);

//    select * from curso where id = 2 or id = 3;
}
