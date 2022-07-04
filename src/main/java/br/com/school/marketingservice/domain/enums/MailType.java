package br.com.school.marketingservice.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MailType {
    LEAD_CREATED_MAIL(1);

    private final Integer code;
}
