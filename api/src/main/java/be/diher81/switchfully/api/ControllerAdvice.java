package be.diher81.switchfully.api;

import be.diher81.switchfully.domain.customer.CustomerInstantiationException;
import be.diher81.switchfully.domain.item.ItemInstantiationException;
import be.diher81.switchfully.domain.order.OrderInstantiationException;
import be.diher81.switchfully.service.CustomerService;
import be.diher81.switchfully.service.ItemService;
import be.diher81.switchfully.service.OrderService;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.slf4j.Logger;

@org.springframework.web.bind.annotation.ControllerAdvice(basePackages = "be.diher81.switchfully")
public class ControllerAdvice {

    private static final Logger CUSTOMER_LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private static final Logger ITEM_LOGGER = LoggerFactory.getLogger(ItemService.class);
    private static final Logger ORDER_LOGGER = LoggerFactory.getLogger(OrderService.class);

    @ExceptionHandler(CustomerInstantiationException.class)
    public ResponseEntity<ExceptionOutput> convertCustomerInstantiationException(final CustomerInstantiationException exception){
        CUSTOMER_LOGGER.error("ERROR: " + exception.getMessage(), exception);
        return new ResponseEntity<>(
                new ExceptionOutput(exception.getLocalizedMessage()),
                HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(ItemInstantiationException.class)
    public ResponseEntity<ExceptionOutput> convertItemInstantiationException(final ItemInstantiationException exception){
        ITEM_LOGGER.error("ERROR: " + exception.getMessage(), exception);
        return new ResponseEntity<>(
                new ExceptionOutput(exception.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderInstantiationException.class)
    public ResponseEntity<ExceptionOutput> convertOrderInstantiationException(final OrderInstantiationException exception){
        ORDER_LOGGER.error("ERROR: " + exception.getMessage(), exception);
        return new ResponseEntity<>(
                new ExceptionOutput(exception.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
}
