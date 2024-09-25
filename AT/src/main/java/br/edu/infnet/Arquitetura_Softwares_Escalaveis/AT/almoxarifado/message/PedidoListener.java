package br.edu.infnet.Arquitetura_Softwares_Escalaveis.AT.almoxarifado.message;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.infnet.Arquitetura_Softwares_Escalaveis.AT.almoxarifado.model.PedidoPayload;
import br.edu.infnet.Arquitetura_Softwares_Escalaveis.AT.almoxarifado.model.Status;

@Component
public class PedidoListener {
    private final ObjectMapper objectMapper = null;

    @RabbitListener(queues = MessageConfig.QUEUE)
    public Boolean receive(@Payload String json) throws InterruptedException {
        PedidoPayload pedidoPayload = null;
        try {
            if (json.isEmpty()) {
                return false;
            };
            pedidoPayload = objectMapper.readValue(json, PedidoPayload.class);
            pedidoPayload.status = Status.EM_SEPARACAO;
        } catch (IOException e) {
            return false;
        }
        System.out.println("Pedido: " + pedidoPayload);
        return true;
    }
}