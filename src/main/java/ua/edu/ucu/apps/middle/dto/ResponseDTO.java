package ua.edu.ucu.apps.middle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private String responseStatus;
    private String responseMessage;
}
