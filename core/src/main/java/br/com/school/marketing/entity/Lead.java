package br.com.school.marketing.entity;

import br.com.school.marketing.enums.LeadStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lead {
    private Long id;
    private String name;
    private String email;
    private LocalDate dateCreated;
    private LeadStatus status;

    public void cancelLead(){
        this.status = LeadStatus.CANCELED;
    }

    public void convertLead(){
        this.status = LeadStatus.CONVERTED;
    }
}
