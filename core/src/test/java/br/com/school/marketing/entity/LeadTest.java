package br.com.school.marketing.entity;

import br.com.school.marketing.enums.LeadStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeadTest {
    @Test
    @DisplayName("Should be able to build a lead")
    void shouldBuildLeadWithSuccess(){
        final var name = "Unit Test Name";
        final var email = "Unit Test Email";
        final var dateCreated = LocalDate.now();
        final var status = LeadStatus.INTERESTED;

        final var leadBuilder = Lead.builder();
        leadBuilder.name(name);
        leadBuilder.email(email);
        leadBuilder.dateCreated(dateCreated);
        leadBuilder.status(status);

        final var lead = leadBuilder.build();
        assertEquals(name, lead.getName());
        assertEquals(email, lead.getEmail());
        assertEquals(dateCreated, lead.getDateCreated());
        assertEquals(status, lead.getStatus());
    }
}
