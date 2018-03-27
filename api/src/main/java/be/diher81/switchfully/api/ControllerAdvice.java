package be.diher81.switchfully.api;

import be.diher81.switchfully.domain.customer.CustomerInstantiationException;
import be.diher81.switchfully.domain.item.ItemInstantiationException;
import be.diher81.switchfully.service.CustomerService;
import be.diher81.switchfully.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

@org.springframework.web.bind.annotation.ControllerAdvice(basePackages = "be.diher81.switchfully")
public class ControllerAdvice {

    private final static Logger CUSTOMER_LOGGER = Logger.getLogger(CustomerService.class.getName());
    private final static Logger ITEM_LOGGER = Logger.getLogger(ItemService.class.getName());

    @ExceptionHandler(CustomerInstantiationException.class)
    public ResponseEntity<String> convertCustomerInstantiationException(final CustomerInstantiationException exception){
        CUSTOMER_LOGGER.log(Level.SEVERE, "ERROR: " + exception.getMessage());
        CUSTOMER_LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(ItemInstantiationException.class)
    public ResponseEntity<String> convertItemInstantiationException(final ItemInstantiationException exception){
        ITEM_LOGGER.log(Level.SEVERE,"ERROR: " + exception.getMessage(), exception);
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST);
    }
}
