package productservices.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponseDto {
    public String message;
    public String status;
}
