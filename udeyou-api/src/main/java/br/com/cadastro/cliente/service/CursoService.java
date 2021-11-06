package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.Cursowishlist;
import br.com.cadastro.cliente.domain.Professor;
import br.com.cadastro.cliente.domain.Curso;
import br.com.cadastro.cliente.domain.StatusResponse;
import br.com.cadastro.cliente.repository.ProfessorRepository;
import br.com.cadastro.cliente.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    ProfessorRepository clienteRepository;

    // todos os cursos
    public List<Curso> getCursos(){
        return cursoRepository.findAll();
    }

    // curso por id
    public Curso findCursoById(Long id){
        return cursoRepository.findById(id).get();
    }

    // encontrar os cursos por professor
    public List<Curso> getCursosByProfessorId(Long id){
        return cursoRepository.findCursoByProfessor(id);
    }

    // cadastrar curso
    public StatusResponse insertCurso(Curso novoCurso){
        Professor professor = clienteRepository.getById(novoCurso.getProfessor().getId());
        List<Curso> cursos = cursoRepository.findAll();

        for (Curso curso : cursos){
            if (curso.equals(novoCurso)){
                return new StatusResponse("Serviço já existe", "erro");
            }
        }

        novoCurso.setProfessor(professor);

        cursoRepository.save(novoCurso);
        return new StatusResponse("Serviço cadastrado com sucesso", "sucesso");
    }

    // excluir curso
    public StatusResponse dropCurso(long idServico){
        List<Curso> cursos = cursoRepository.findAll();

        if (cursoRepository.findById(idServico) == null){
            return new StatusResponse("Serviço não existe", "erro");
        }

        cursoRepository.deleteById(idServico);
        return new StatusResponse("Serviço deletado com sucesso", "sucesso");
    }

    // atualizar curso
    public StatusResponse updateCurso(Curso novoCurso) {
        Curso curso = cursoRepository.findById(novoCurso.getId()).get();

        if (novoCurso.getTitulo() == "" || novoCurso.getDescricao() == "" || novoCurso.getValor() == null){
            return new StatusResponse("Dados invalidos", "erro");
        }

        curso.setTitulo(novoCurso.getTitulo());
        curso.setDescricao(novoCurso.getDescricao());
        curso.setValor(novoCurso.getValor());

        cursoRepository.save(curso);
        return new StatusResponse("Serviço alterado com sucesso", "sucesso");
    }

    // fazer pesquisa por cursos
    public List<Curso> pesquisar(String titulo) {
        return cursoRepository.findCursoByTitulo(titulo);
    }

    public StatusResponse addCursoWish(Cursowishlist cw) {
        cw.getWishlist().getCursos().add(cw.getCurso());
        cw.getCurso().getWishlists().add(cw.getWishlist());

        cursoRepository.save(cw.getCurso());
        return new StatusResponse("Curso adicionado à Wishlist", "sucesso");
    }

    public List<Curso> getCursosWishAll(List<Long> idsCursos) {
        List<Curso> cursos = new ArrayList<>();

        for (Long id : idsCursos) {
            Curso curso = cursoRepository.findCursoById(id);
            cursos.add(curso);
        }
        return cursos;
    }
}
