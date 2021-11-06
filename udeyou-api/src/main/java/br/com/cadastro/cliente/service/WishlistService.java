package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.StatusResponse;
import br.com.cadastro.cliente.domain.Wishlist;
import br.com.cadastro.cliente.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public StatusResponse createWishlist(Wishlist wishlist) {
        wishlistRepository.save(wishlist);
        return new StatusResponse("Wishlist criada com sucesso", "sucesso");
    }

    public List<Wishlist> getWishlists() {
        return wishlistRepository.findAll();
    }

    public Wishlist getWishlistByUsuario(Long id) {
        return wishlistRepository.findByUsuarioId(id);
    }
}
