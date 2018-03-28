package be.diher81.switchfully.domain.customer;

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

    public Customer addNewCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    private void addInitialCustomersToRepository() {
        customers.add(new Customer("Dirk", "Hermans", "dirk.hemans@fakemail.be", "0497838383"
                , new Address("Javastreet", "8", "3600", "Genk")
        ));
        customers.add(new Customer("Harry", "Potter", "harry.potter@fakemail.be", "0497838384"
                , new Address("Privet Drive", "9", "3601", "Little Whinging")
        ));
        customers.add(new Customer("Jean-Michel", "Saive", "jm.saive@fakemail.be", "0497838385"
                , new Address("pingpongstreet", "11", "3602", "Auderghem")
        ));
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    // Only used to create initial order repo
    public Customer getRandomCustomer() {
        int index = 0;
        int i = (int) (Math.random() * getCustomers().size())   ;
        for (Customer customer : getCustomers()) {
            if (index == i) {
                return customer;
            }
            index++;
        }
        return null;
    }
}
