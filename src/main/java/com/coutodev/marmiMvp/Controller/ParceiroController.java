package com.coutodev.marmiMvp.Controller;

import com.coutodev.marmiMvp.DTO.ParceiroRequest;
import com.coutodev.marmiMvp.DTO.ParceiroResponse;
import com.coutodev.marmiMvp.domain.Parceiros.ParceiroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parceiro")
public class ParceiroController {

    private final ParceiroService parceiroService;

    public ParceiroController(ParceiroService parceiroService) {
        this.parceiroService = parceiroService;
    }
@PostMapping
    public ResponseEntity<ParceiroResponse> criarParceiro(@RequestBody ParceiroRequest request){
   ParceiroResponse response = parceiroService.CriarParceiro(request);
      return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
}
