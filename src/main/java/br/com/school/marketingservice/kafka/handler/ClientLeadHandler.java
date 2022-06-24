package br.com.school.marketingservice.kafka.handler;

import br.com.school.marketingservice.domain.entity.Lead;
import br.com.school.marketingservice.kafka.consumer.ClientLeadDTO;
import br.com.school.marketingservice.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientLeadHandler {
    @Autowired
    private LeadService leadService;
    public void handleClientLeadMessage(ClientLeadDTO clientLead){
        leadService.convertLead(clientLead.getMarketingLeadId());
    }
}
