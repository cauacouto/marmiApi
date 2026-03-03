package com.coutodev.marmiMvp.Controller;

import com.coutodev.marmiMvp.DTO.ParceiroRequest;
import com.coutodev.marmiMvp.DTO.ParceiroResponse;
import com.coutodev.marmiMvp.DTO.RefeicaoResponseDto;
import com.coutodev.marmiMvp.domain.Parceiros.ParceiroService;
import com.coutodev.marmiMvp.domain.Refeicoes.RefeicaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/parceiro")
public class ParceiroController {

    private final ParceiroService parceiroService;
    private final RefeicaoService refeicaoService;

    public ParceiroController(ParceiroService parceiroService, RefeicaoService refeicaoService) {
        this.parceiroService = parceiroService;
        this.refeicaoService = refeicaoService;
    }
    @PostMapping
    public ResponseEntity<ParceiroResponse> criarParceiro(@RequestBody ParceiroRequest request){
        ParceiroResponse response = parceiroService.CriarParceiro(request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }



    @GetMapping("/{id}/refeicao")
    public ResponseEntity<List<RefeicaoResponseDto>> listarRefeicoesPorParceiro(@PathVariable UUID id){
        return ResponseEntity.ok(refeicaoService.listarRefeicoesPorParceiro(id));

    }
}
