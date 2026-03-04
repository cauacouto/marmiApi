package com.coutodev.marmiMvp.Controller;

import com.coutodev.marmiMvp.DTO.CriarPedidoDTO;
import com.coutodev.marmiMvp.DTO.PedidoResponseDto;
import com.coutodev.marmiMvp.domain.Pedido.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;


    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;

    }
    @PostMapping
    public ResponseEntity<PedidoResponseDto> criarPedido(@RequestBody CriarPedidoDTO dto){
    PedidoResponseDto response = pedidoService.criarPedido(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
