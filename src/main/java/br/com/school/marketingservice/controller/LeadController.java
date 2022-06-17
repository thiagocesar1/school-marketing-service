package br.com.school.marketingservice.controller;

import br.com.school.marketingservice.domain.entity.Lead;
import br.com.school.marketingservice.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lead")
public class LeadController {
    @Autowired
    private LeadService leadService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Lead lead){
        leadService.save(lead);
    }
}
