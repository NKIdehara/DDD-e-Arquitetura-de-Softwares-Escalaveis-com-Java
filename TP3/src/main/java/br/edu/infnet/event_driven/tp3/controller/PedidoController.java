package br.edu.infnet.event_driven.tp3.controller;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.event_driven.tp3.model.Pedido;
import br.edu.infnet.event_driven.tp3.service.PedidoQueryService;
import br.edu.infnet.event_driven.tp3.service.PedidoService;



@RestController
@RequestMapping("/api")
public class PedidoController {
    private final PedidoService pedidoService;
    private final PedidoQueryService pedidoQueryService;

    public PedidoController(PedidoService pedidoService, PedidoQueryService pedidoQueryService) {
        this.pedidoService = pedidoService;
        this.pedidoQueryService = pedidoQueryService;
    }

    @GetMapping("/evento/{id}")
    public List<Object> listarEventos(@PathVariable String id) {
        return pedidoQueryService.listarEventos(id.toString());
    }

    @GetMapping("/pedido/{id}")
    public Pedido getById(@PathVariable String id) {
        return pedidoQueryService.getById(UUID.fromString(id)).orElse(null);
    }

    @PostMapping("/pedido")
    public CompletableFuture<UUID> criarPedido(@RequestBody Pedido pedido) {
        return pedidoService.criarPedido(pedido);
    }
}
