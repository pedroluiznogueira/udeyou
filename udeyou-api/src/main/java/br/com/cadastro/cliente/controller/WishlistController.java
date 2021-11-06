package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.StatusResponse;
import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.domain.Wishlist;
import br.com.cadastro.cliente.repository.WishlistRepository;
import br.com.cadastro.cliente.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wishlist")
@CrossOrigin("*")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("create")
    public ResponseEntity<StatusResponse> createWishlist(@RequestBody Wishlist wishlist) {
        StatusResponse statusResponse = wishlistService.createWishlist(wishlist);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }

    @GetMapping("get")
    public ResponseEntity<List<Wishlist>> getWishlists() {
        List<Wishlist> wishList = wishlistService.getWishlists();
        return new ResponseEntity<>(wishList, HttpStatus.OK);
    }

    @PostMapping("get/usuario")
    public ResponseEntity<Wishlist> getWishlistByUsuario(@RequestBody Usuario usuario) {
        Wishlist wishList = wishlistService.getWishlistByUsuario(usuario.getId());
        return new ResponseEntity<>(wishList, HttpStatus.OK);
    }
}
