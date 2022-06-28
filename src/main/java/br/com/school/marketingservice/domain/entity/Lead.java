package br.com.school.marketingservice.domain.entity;

import br.com.school.marketingservice.domain.enums.LeadStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "lead")
public class Lead {

    @Id
    private String id;

    @Field
    @NotBlank(message = "Name is empty")
    private String name;

    @Field
    @NotBlank(message = "Email is empty.")
    @Email(message = "Invalid email.")
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
