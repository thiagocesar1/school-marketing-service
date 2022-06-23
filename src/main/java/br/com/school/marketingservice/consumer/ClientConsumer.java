package br.com.school.marketingservice.consumer;

import br.com.school.marketingservice.domain.entity.Lead;
import br.com.school.marketingservice.domain.enums.LeadStatus;
import br.com.school.marketingservice.domain.repository.LeadRepository;
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
    private static final String topic = "clients";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LeadRepository leadRepository;

    @KafkaListener(topics = "clients")
    public void send(String client) throws JsonProcessingException {
        ClientDTO clientDTO = objectMapper.readValue(client, ClientDTO.class);
        Optional<Lead> leadExists = leadRepository.findById(clientDTO.getMarketingLeadId());
        logger.info("Lendo topico, Lead Existe -> "+leadExists.isPresent());
        leadExists.ifPresent(lead -> lead.setStatus(LeadStatus.CONVERTED));
    }
}
