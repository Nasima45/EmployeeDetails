package aktar.Employee.Management.exception;

import aktar.Employee.Management.dto.ErrorResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler({EmployeeNotFoundException.class})

    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
        logger.warn("Employee you are trying to find is not present in our db");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(404,e.getMessage()));
    }
}
