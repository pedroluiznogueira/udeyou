package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    private String chave = "String Aleatoria Secret";

    //30 minutos
    private static final long tempoExpiracao = 1800000;

    public String gerarToken(Usuario usuario) {
        return Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setSubject("Teste JWT API")
                .setExpiration(new Date(System.currentTimeMillis() + tempoExpiracao))
                .signWith(SignatureAlgorithm.HS256, chave)
                .compact();
    }

    public Claims decodificadoToken(String token) {
        return Jwts.parser()
                .setSigningKey(chave)
                .parseClaimsJws(token)
                .getBody();
    }

}
