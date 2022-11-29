package ua.edu.ucu.apps.middle.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public class Response extends ResponseDTO {
    @Builder.Default
    private String responseStatus = String.valueOf(ResponseStatus.OK);
    @Builder.Default
    private String responseMessage = "OK";
    private String companyName;
    private String twitterUrl;
    private String facebookUrl;
    private String companyLogo;
    private String companyIcon;
    private String numberOfEmployees;
    private String companyAddress;
}
