package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> lista = usuarioService.getUsuarios();
        return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
    }

    @PostMapping("/find/token")
    public ResponseEntity<Usuario> getUsuarioByToken(@RequestBody Usuario usuarioToken) {
        Usuario usuario = usuarioService.getUsuarioByToken(usuarioToken.getToken());
        System.out.println(usuario);
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> autenticar(@RequestBody Usuario usuario){
        Usuario user = usuarioService.autenticar(usuario);
        return new ResponseEntity<Usuario>(user, HttpStatus.ACCEPTED);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> registrate(@RequestBody Usuario usuario){
        Usuario user = usuarioService.registrar(usuario);
        return  new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
    }

}
