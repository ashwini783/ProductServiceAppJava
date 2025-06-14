package productservices.productservice.advices;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import productservices.productservice.dtos.ErrorResponseDto;

@ControllerAdvice
@RestController
public class ExceptionAdvices {
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDto handleException(RuntimeException e) {
        ErrorResponseDto dto=new ErrorResponseDto();
        dto.setMessage(e.getMessage());
        dto.setStatus("ERROR");
        return dto;
    }
}


//if we create error method here it will be useful across all controllers instead of creating it in controller