package com.devlucasmart.notificacao.listener;

import com.devlucasmart.notificacao.constante.MensagemConstante;
import com.devlucasmart.notificacao.domain.Proposta;
import com.devlucasmart.notificacao.service.NotificacaoSnsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.devlucasmart.notificacao.constante.MensagemConstante.APROVADA;
import static com.devlucasmart.notificacao.constante.MensagemConstante.PROPOSTA_ANALISADA;
import static com.devlucasmart.notificacao.constante.MensagemConstante.REPROVADA;

@Component
public class PropostaConcluidaListener {

    @Autowired
    private NotificacaoSnsService notificacaoSnsService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.concluida}")
    public void propostaConcluida(Proposta proposta) {
        var mensagem = String.format(PROPOSTA_ANALISADA, proposta.getUsuario().getNome(),
                proposta.getAprovada() ? APROVADA : REPROVADA, proposta.getObservacao());

        notificacaoSnsService.notificar(proposta.getUsuario().getTelefone(), mensagem);
    }
}
