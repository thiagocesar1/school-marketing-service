package br.com.school.marketingservice.controller;

import br.com.school.marketingservice.domain.entity.Lead;
import br.com.school.marketingservice.domain.repository.LeadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lead")
public class LeadController {
    private Logger logger = LoggerFactory.getLogger(LeadController.class);

    @Autowired
    private LeadRepository leadRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lead createLead(){
        Lead lead = Lead.builder()
                .name("Test")
                .email("Test")
                .build();

        leadRepository.insert(lead);

        return lead;
    }
}
