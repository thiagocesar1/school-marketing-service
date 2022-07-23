package br.com.school.marketing.useCases.impl;

import br.com.school.marketing.dataprovider.LeadRepository;
import br.com.school.marketing.entity.Lead;
import br.com.school.marketing.enums.LeadStatus;
import br.com.school.marketing.useCases.LeadCreateUseCase;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class LeadCreateUseCaseImpl implements LeadCreateUseCase {
    private LeadRepository leadRepository;
    @Override
    public Lead createLead(Lead lead) {
        lead.setStatus(LeadStatus.INTERESTED);
        leadRepository.save(lead);
        return lead;
    }
}
