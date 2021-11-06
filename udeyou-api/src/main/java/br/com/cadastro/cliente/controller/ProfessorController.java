package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.Professor;
import br.com.cadastro.cliente.domain.StatusResponse;
import br.com.cadastro.cliente.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/professor")
@CrossOrigin("*")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    // todos professores
    @GetMapping("professores")
    public ResponseEntity<List<Professor>> getProfessores() {
        List<Professor> lista = professorService.getProfessores();
        return new ResponseEntity<List<Professor>>(lista, HttpStatus.OK);
    }

    // professor por id
    @GetMapping("find/{id}")
    public ResponseEntity<Professor> findById(@PathVariable ("id") Long id) {
        Professor professor = professorService.findProfessorById(id);
        return new ResponseEntity<Professor>(professor, HttpStatus.OK);
    }

    // cadastrar professor
    @PostMapping("create")
    public ResponseEntity<StatusResponse> insertProfessor(@RequestBody Professor professor) {
        StatusResponse statusResponse = professorService.insertProfessor(professor);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }


    // excluir professor
    @DeleteMapping("delete/{id}")
    public ResponseEntity<StatusResponse> dropProfessor(@PathVariable ("id") Long idCliente) {
        StatusResponse statusResponse = professorService.dropProfessor(idCliente);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }

    // atualizar professor
    @PutMapping("update")
    public ResponseEntity<StatusResponse> updateProfessor(@RequestBody Professor professor) {
        StatusResponse statusResponse = professorService.updateProfessor(professor);

        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }

    // fazer pesquisa por professores
    @PostMapping("search")
    public ResponseEntity<List<Professor>> pesquisar(@RequestBody Professor professor) {
        List<Professor> professores = professorService.pesquisar(professor.getNome());
        return new ResponseEntity<List<Professor>>(professores, HttpStatus.OK);
    }
}
