package com.devlucasmart.notificacao.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoSnsService {

    @Autowired
    private AmazonSNS amazonSNS;

    public void notificar(String telefone, String mensagem) {
        var publishRequest = new PublishRequest().withMessage(mensagem).withPhoneNumber(telefone);
        amazonSNS.publish(publishRequest);
    }
}
