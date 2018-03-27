package be.diher81.switchfully.api;

import be.diher81.switchfully.domain.customer.OrderInstantiationException;
import be.diher81.switchfully.domain.item.ItemInstantiationException;
import be.diher81.switchfully.service.CustomerService;
import be.diher81.switchfully.service.ItemService;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.slf4j.Logger;

@org.springframework.web.bind.annotation.ControllerAdvice(basePackages = "be.diher81.switchfully")
public class ControllerAdvice {

    private static final Logger CUSTOMER_LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private static final Logger ITEM_LOGGER = LoggerFactory.getLogger(ItemService.class);

    @ExceptionHandler(OrderInstantiationException.class)
    public ResponseEntity<String> convertCustomerInstantiationException(final OrderInstantiationException exception){
        CUSTOMER_LOGGER.error("ERROR: " + exception.getMessage(), exception);
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(ItemInstantiationException.class)
    public ResponseEntity<String> convertItemInstantiationException(final ItemInstantiationException exception){
        ITEM_LOGGER.error("ERROR: " + exception.getMessage(), exception);
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST);
    }
}
