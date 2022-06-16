package br.com.school.marketingservice.domain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "leads")
public class Lead {

    @Id
    private String id;

    @Field
    private String name;

    @Field
    private String email;
}
