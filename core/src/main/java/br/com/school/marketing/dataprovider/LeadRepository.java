package br.com.school.marketing.dataprovider;

import br.com.school.marketing.entity.Lead;

public interface LeadRepository {
    Lead save(Lead lead);
}
