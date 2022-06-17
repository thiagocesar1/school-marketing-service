package br.com.school.marketingservice.domain.repository;

import br.com.school.marketingservice.domain.entity.Lead;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LeadRepository extends MongoRepository<Lead, String> {
    Optional<Lead> findByEmail(String email);
}
