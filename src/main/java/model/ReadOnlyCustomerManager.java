package model;

import javafx.collections.ObservableList;
import model.customer.Customer;

public interface ReadOnlyCustomerManager {
    /**
     * Returns an unmodifiable view of the customers list.
     * This list will not contain any duplicate customers.
     */
    ObservableList<Customer> getCustomerList();
}
