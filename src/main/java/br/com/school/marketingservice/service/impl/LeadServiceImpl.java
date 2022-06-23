package br.com.school.marketingservice.service.impl;

import br.com.school.marketingservice.controller.LeadController;
import br.com.school.marketingservice.domain.entity.Lead;
import br.com.school.marketingservice.domain.enums.LeadStatus;
import br.com.school.marketingservice.domain.repository.LeadRepository;
import br.com.school.marketingservice.service.LeadService;
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
    }

    @Override
    public Lead getLead(String id) {
        return leadRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lead not found!"));
    }
}
