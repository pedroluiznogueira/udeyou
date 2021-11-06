package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioByToken(String token) {
        return usuarioRepository.findByToken(token).orElseThrow(IllegalArgumentException::new);
    }

    public Usuario autenticar(Usuario usuario){
        Usuario user = usuarioRepository.findByEmail(usuario.getEmail()).orElseThrow(IllegalArgumentException::new);

        if(usuario.getSenha().equals(user.getSenha())) {
            return user;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public Usuario registrar(Usuario user){
        user.setToken(tokenService.gerarToken(user));
        return usuarioRepository.save(user);
    }

}
