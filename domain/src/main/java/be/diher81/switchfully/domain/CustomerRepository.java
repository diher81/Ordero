package be.diher81.switchfully.domain;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class CustomerRepository {

    private List<Customer> customers;

    @Inject
    public CustomerRepository() {
        this.customers = new ArrayList<>();
        this.addInitialCustomersToRepository();
    }

    private void addInitialCustomersToRepository() {
        customers.add(new Customer("Dirk", "Hermans", "dirk.hemans@cm.be", "0497838383"
                , new Address("Javastraat", "8", "3600", "Genk")
        ));
        customers.add(new Customer("Harry", "Potter", "harry.potter@cm.be", "0497838384"
                , new Address("Privet Drive", "9", "3601", "Little Whinging")
        ));
        customers.add(new Customer("Jean-Michel", "Saive", "jm.saive@cm.be", "0497838385"
                , new Address("pigpongstraat", "11", "3602", "Auderghem")
        ));
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
