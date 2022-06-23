package br.com.school.marketingservice.domain.entity;

import br.com.school.marketingservice.domain.enums.LeadStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "lead")
public class Lead {

    @Id
    private String id;

    @Field
    private String name;

    @Field
    private String email;

    @Field
    private LeadStatus status;
}
