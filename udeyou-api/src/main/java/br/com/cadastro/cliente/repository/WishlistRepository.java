package br.com.cadastro.cliente.repository;

import br.com.cadastro.cliente.domain.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    Wishlist findByUsuarioId(Long id);
}
