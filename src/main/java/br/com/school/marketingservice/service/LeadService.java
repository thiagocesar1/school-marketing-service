package br.com.school.marketingservice.service;

import br.com.school.marketingservice.domain.entity.Lead;

public interface LeadService {
    void save(Lead lead);
    Lead getLead(String id);
    void cancelLead(String id);
     void convertLead(String id);
}
