package ua.edu.ucu.apps.middle.dto;


public class ResponseError extends ResponseDTO {
    public ResponseError(String errorMessage) {
        super(String.valueOf(ResponseStatus.ERROR), errorMessage);
    }
}
