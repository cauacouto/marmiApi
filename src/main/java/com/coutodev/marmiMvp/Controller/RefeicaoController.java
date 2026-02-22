package com.coutodev.marmiMvp.Controller;

import com.coutodev.marmiMvp.DTO.CriarRefeicaoDto;
import com.coutodev.marmiMvp.DTO.RefeicaoResponseDto;
import com.coutodev.marmiMvp.domain.Refeicoes.RefeicaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/refeicao")
public class RefeicaoController {

private final RefeicaoService refeicaoService;


    public RefeicaoController(RefeicaoService refeicaoService) {
        this.refeicaoService = refeicaoService;

    }
@PostMapping
    public ResponseEntity<RefeicaoResponseDto> criarRefeicao(@RequestBody CriarRefeicaoDto dto){
       RefeicaoResponseDto response = refeicaoService.criarRefeicao(dto);
       return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
