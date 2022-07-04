package br.com.school.marketingservice.service.impl;

import br.com.school.marketingservice.controller.LeadController;
import br.com.school.marketingservice.domain.entity.Lead;
import br.com.school.marketingservice.domain.enums.LeadStatus;
import br.com.school.marketingservice.domain.enums.MailType;
import br.com.school.marketingservice.domain.repository.LeadRepository;
import br.com.school.marketingservice.kafka.DTOs.LeadMailDTO;
import br.com.school.marketingservice.kafka.producer.MailProducer;
import br.com.school.marketingservice.service.LeadService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class LeadServiceImpl implements LeadService {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private MailProducer mailProducer;

    @Autowired
    private ObjectMapper objectMapper;

    private final Logger logger = LoggerFactory.getLogger(LeadController.class);


    @Override
    @Transactional
    public void save(Lead lead) {
        Optional<Lead> leadExists = leadRepository.findByEmail(lead.getEmail());
        if(leadExists.isEmpty()){
           logger.info("Saving new lead");
           lead.setStatus(LeadStatus.INTERESTED);
           leadRepository.save(lead);
        }

        sendLeadMail(lead);
    }

    @Override
    public Lead getLead(String id) {
        return leadRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lead not found!"));
    }

    @Override
    public void cancelLead(String id) {
        Lead lead = leadRepository.findById(id).get();
        lead.cancel();
        leadRepository.save(lead);
    }

    @Override
    public void convertLead(String id) {
        Lead lead = leadRepository.findById(id).get();
        lead.convert();
        leadRepository.save(lead);
    }

    private void sendLeadMail(Lead lead){
       LeadMailDTO mail = LeadMailDTO.builder()
                .mailType(MailType.LEAD_CREATED_MAIL)
                .mailTo(lead.getEmail())
                .registerLink("localhost:xxxx/register")
                .userName(lead.getName())
                .build();

        logger.info("Sending lead mail to kafka.");
        mailProducer.sendMail(mail);
    }
}
