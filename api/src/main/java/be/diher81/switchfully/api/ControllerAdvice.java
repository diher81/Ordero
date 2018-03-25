package be.diher81.switchfully.api;

import be.diher81.switchfully.domain.customer.CustomerInstantiationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice(basePackages = "be.diher81.switchfully")
public class ControllerAdvice {

    @ExceptionHandler(CustomerInstantiationException.class)
    public ResponseEntity<String> convertCustomerInstantiationException(final CustomerInstantiationException exception){
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.I_AM_A_TEAPOT);
    }
}
