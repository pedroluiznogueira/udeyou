package com.confirmarcadastro.microservico.service;

import com.confirmarcadastro.microservico.domain.Confirmacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(url= "http://localhost:8080/" , name = "confirmar")
public interface ConfirmarCadastroService {

    @PostMapping("confirmar")
    Confirmacao confirmarCadastro(@RequestBody Confirmacao confirmacao);
}
