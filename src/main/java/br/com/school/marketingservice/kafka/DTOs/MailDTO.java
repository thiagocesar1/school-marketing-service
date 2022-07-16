package br.com.school.marketingservice.kafka.DTOs;

import br.com.school.marketingservice.domain.enums.MailType;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class MailDTO {
    private String mailTo;
    private Map<String, String> attributes;
    private MailType mailType;
}
