package com.coutodev.marmiMvp.domain.Pedido;

import com.coutodev.marmiMvp.DTO.CriarPedidoDTO;
import com.coutodev.marmiMvp.DTO.ItemPedidoDto;
import com.coutodev.marmiMvp.DTO.PedidoResponseDto;
import com.coutodev.marmiMvp.Exception.RegraNegocioException;
import com.coutodev.marmiMvp.Mapper.PedidoMapper;
import com.coutodev.marmiMvp.domain.ItemPedio.ItemPedido;
import com.coutodev.marmiMvp.domain.Refeicoes.Refeicao;
import com.coutodev.marmiMvp.domain.Refeicoes.RefeicaoRepository;
import com.coutodev.marmiMvp.domain.Usuarios.Usuario;
import com.coutodev.marmiMvp.domain.Usuarios.UsuarioRepository;
import com.coutodev.marmiMvp.enums.StatusPedido;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final UsuarioRepository usuarioRepository;
    private final RefeicaoRepository refeicaoRepository;
    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;

    public PedidoService(UsuarioRepository usuarioRepository, RefeicaoRepository refeicaoRepository, PedidoRepository pedidoRepository, PedidoMapper pedidoMapper) {
        this.usuarioRepository = usuarioRepository;
        this.refeicaoRepository = refeicaoRepository;
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
    }

//implementar pagamento e fazer o service de item para listar os itens atraves do id
    public PedidoResponseDto criarPedido(CriarPedidoDTO dto){
        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(()-> new RegraNegocioException("usuario não encontrado"));
        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setStatusPedido(StatusPedido.RECEBIDO);

        List<ItemPedido> itens = new ArrayList<>();

        for (ItemPedidoDto itemDTO : dto.itens()){
            Refeicao refeicao = refeicaoRepository.findById(itemDTO.refeicaoId())
                    .orElseThrow(()-> new RegraNegocioException("refeição não encontrada"));

            ItemPedido item = new ItemPedido();
            item.setRefeicao(refeicao);
            item.setPedido(pedido);
            item.setQuantidade(itemDTO.quantidade());

            BigDecimal preco = refeicao.getPreco();
            item.setPrecoUnitario(preco);

            BigDecimal subtotal = preco.multiply(BigDecimal.valueOf(itemDTO.quantidade()));
            item.setSubTotal(subtotal);

            itens.add(item);
        }
        pedido.setItemPedidos(itens);

        BigDecimal total = itens.stream()
                .map(ItemPedido::getSubTotal)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        pedido.setValorTotal(total);

        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        return pedidoMapper.toResponseDto(pedidoSalvo);

    }

}
