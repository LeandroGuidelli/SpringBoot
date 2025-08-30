package br.com.aweb.crud_aluno.controller;

import br.com.aweb.crud_aluno.model.Aluno;
import br.com.aweb.crud_aluno.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alunos", alunoService.listarTodos());
        return "alunos/listar";
    }

    // NOVO ALUNO
    @GetMapping("/cadastrar")
    public String cadastrarForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "alunos/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid Aluno aluno, BindingResult result) {
        if (result.hasErrors()) {
            return "alunos/cadastrar";
        }
        alunoService.salvar(aluno);
        return "redirect:/alunos";
    }

    // EDITAR ALUNO
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Aluno aluno = alunoService.buscarPorId(id);
        model.addAttribute("aluno", aluno);
        return "alunos/editar";
    }

    @PostMapping("/editar/{id}")
    public String editar(@PathVariable Long id, @Valid Aluno aluno, BindingResult result) {
        if (result.hasErrors()) {
            return "alunos/editar";
        }
        aluno.setId(id);
        alunoService.salvar(aluno);
        return "redirect:/alunos";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return "redirect:/alunos";
    }
}
