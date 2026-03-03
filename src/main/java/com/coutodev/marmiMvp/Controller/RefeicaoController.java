package com.coutodev.marmiMvp.Controller;

import com.coutodev.marmiMvp.DTO.CriarRefeicaoDto;
import com.coutodev.marmiMvp.DTO.RefeicaoResponseDto;
import com.coutodev.marmiMvp.domain.Refeicoes.RefeicaoService;
import com.coutodev.marmiMvp.enums.TipoCozinha;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/refeicao")
public class RefeicaoController {

    private final RefeicaoService refeicaoService;


    public RefeicaoController(RefeicaoService refeicaoService) {
        this.refeicaoService = refeicaoService;

    }

    @PostMapping
    public ResponseEntity<RefeicaoResponseDto> criarRefeicao(@RequestBody CriarRefeicaoDto dto, @RequestParam UUID id) {
        RefeicaoResponseDto response = refeicaoService.criarRefeicao(dto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping
    public ResponseEntity<List<RefeicaoResponseDto>> listar(@RequestParam(required = false) TipoCozinha tipoCozinha){
        return ResponseEntity.ok(refeicaoService.listar(tipoCozinha));
    }
}

