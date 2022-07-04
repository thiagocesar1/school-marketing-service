package br.com.school.marketingservice.kafka.DTOs;

import br.com.school.marketingservice.domain.enums.MailType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LeadMailDTO {
    private String mailTo;
    private String userName;
    private String registerLink;
    private MailType mailType;
}
