package aktar.Employee.Management.dto;

import lombok.Data;

@Data
public class ErrorResponseDto {
    int status;
    String message;

    public ErrorResponseDto(int i, String message) {
    }
}
