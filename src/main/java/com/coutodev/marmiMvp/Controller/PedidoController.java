package com.coutodev.marmiMvp.Controller;

import com.coutodev.marmiMvp.DTO.CriarPedidoDTO;
import com.coutodev.marmiMvp.DTO.PedidoResponseDto;
import com.coutodev.marmiMvp.Mapper.PedidoMapper;
import com.coutodev.marmiMvp.domain.Pedido.Pedido;
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
    private final PedidoMapper pedidoMapper;

    public PedidoController(PedidoService pedidoService, PedidoMapper pedidoMapper) {
        this.pedidoService = pedidoService;
        this.pedidoMapper = pedidoMapper;
    }
    @PostMapping
    public ResponseEntity<PedidoResponseDto> criarPedido(@RequestBody CriarPedidoDTO dto){
        Pedido pedido = pedidoService.criarPedido(dto);
        PedidoResponseDto response = pedidoMapper.toResponseDto(pedido);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
