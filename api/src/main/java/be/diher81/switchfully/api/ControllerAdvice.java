package be.diher81.switchfully.api;

import be.diher81.switchfully.domain.customer.CustomerInstantiationException;
import be.diher81.switchfully.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice(basePackages = "be.diher81.switchfully")
public class ControllerAdvice {

    final static Logger logger = Logger.getLogger(CustomerService.class);


    @ExceptionHandler(CustomerInstantiationException.class)
    public ResponseEntity<String> convertCustomerInstantiationException(final CustomerInstantiationException exception){
        logger.error("Something went wrong", exception);
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.I_AM_A_TEAPOT);
    }
}
