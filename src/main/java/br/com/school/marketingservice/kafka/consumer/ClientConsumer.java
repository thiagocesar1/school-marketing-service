package br.com.school.marketingservice.kafka.consumer;

import br.com.school.marketingservice.domain.entity.Lead;
import br.com.school.marketingservice.domain.repository.LeadRepository;
import br.com.school.marketingservice.kafka.handler.ClientLeadHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientConsumer {
    private static final Logger logger = LoggerFactory.getLogger(ClientConsumer.class);
    private static final String topic = "client_added";

    @Autowired
    private ClientLeadHandler clientLeadHandler;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = topic)
    public void send(String clientLead) throws JsonProcessingException {
        try {
            ClientLeadDTO clientLeadDTO = objectMapper.readValue(clientLead, ClientLeadDTO.class);
            logger.info("Mensagem do client {} recebida.", clientLeadDTO.getMarketingLeadId());
            clientLeadHandler.handleClientLeadMessage(clientLeadDTO);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
