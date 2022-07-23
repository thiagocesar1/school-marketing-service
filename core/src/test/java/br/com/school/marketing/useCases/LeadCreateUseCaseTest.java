package br.com.school.marketing.useCases;

import br.com.school.marketing.dataprovider.LeadRepository;
import br.com.school.marketing.entity.Lead;
import br.com.school.marketing.enums.LeadStatus;
import br.com.school.marketing.useCases.impl.LeadCreateUseCaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class LeadCreateUseCaseTest {
    @Mock
    private LeadRepository leadRepository;

    private LeadCreateUseCase useCase;

    @BeforeEach
    public void setUp() {
        this.useCase = new LeadCreateUseCaseImpl();
    }

    @Test
    @DisplayName("Should be able to save a lead.")
    public void createLead(){
        final var name = "Unit Test Name";
        final var email = "Unit Test Email";
        final var dateCreated = LocalDate.now();

        Lead lead = Lead.builder()
                .id(1L)
                .name(name)
                .email(email)
                .dateCreated(dateCreated)
                .build();

        Mockito.when(leadRepository.save(lead)).thenReturn(lead);

        Lead savedLead = useCase.createLead(lead);
        assertThat(savedLead.getId()).isNotNull();
        assertThat(savedLead.getStatus()).isEqualTo(LeadStatus.INTERESTED);
    }
}
