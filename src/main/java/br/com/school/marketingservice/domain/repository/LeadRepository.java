package br.com.school.marketingservice.domain.repository;

import br.com.school.marketingservice.domain.entity.Lead;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeadRepository extends MongoRepository<Lead, String> {
}
