package com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.config.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

public class MessageListenerComponent implements ApplicationRunner {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private JmsTemplate jmsTemplateTopic;


    @JmsListener(destination = "queue.pessoa")
    public void onReceiverQueue(String str) {
        System.out.println(str);
    }

    @JmsListener(destination = "topic.novo", containerFactory = "jmsFactoryTopic")
    public void onReceiverTopic(String str) {
        System.out.println(str);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        jmsTemplate.convertAndSend("queue.pessoa",
                "{nome: 'bernardo', email: 'bernardo@email.com'}");
        jmsTemplateTopic.convertAndSend("topic.novo", "{nome: 'joao', email: 'joao@email.com'}");
    }
}
