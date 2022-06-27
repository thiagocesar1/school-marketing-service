package br.com.school.marketingservice.domain.entity;

import br.com.school.marketingservice.domain.enums.LeadStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "lead")
public class Lead {

    @Id
    private String id;

    @Field
    @NotEmpty
    private String name;

    @Field
    @NotEmpty
    private String email;

    @Field
    private LeadStatus status;

    public void convert(){
        this.status = LeadStatus.CONVERTED;
    }

    public void cancel(){
        this.status = LeadStatus.CANCELED;
    }
}
