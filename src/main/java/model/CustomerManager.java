package model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import model.customer.Customer;
import model.customer.UniqueCustomerList;
import model.customer.exceptions.CustomerNotFoundException;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSamePerson comparison)
 */
public class CustomerManager implements ReadOnlyCustomerManager {

    private final UniqueCustomerList customers;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        customers = new UniqueCustomerList();
    }

    public CustomerManager() {
    }

    /**
     * Creates an AddressBook using the Customers in the (@code toBeCopied)
     */
    public CustomerManager(ReadOnlyCustomerManager toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the customer list with {@code customers}.
     * {@code customers} must not contain duplicate customers.
     */
    public void setCustomers(List<Customer> customers) {
        this.customers.setCustomers(customers);
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyCustomerManager newData) {
        requireNonNull(newData);

        setCustomers(newData.getCustomerList());
    }

    //// customer-level operations

    /**
     * Retrieve customer using its unique customer id.
     *
     * @param customerId customer unique id.
     * @return Customer with the specified unique id.
     */
    public Customer getCustomer(int customerId) {
        return getCustomerList()
                .stream()
                .filter(customer -> customer.getId() == customerId)
                .findFirst()
                .orElseThrow(CustomerNotFoundException:: new);
    }

    /**
     * Returns true if a customer with the same identity as (@code customer) exists in the address book.
     */
    public boolean hasCustomer(Customer customer) {
        requireNonNull(customer);
        return customers.contains(customer);
    }

    public boolean hasCustoemr(int customerId) {
        return getCustomerList()
                .stream()
                .anyMatch(customer -> customer.getId() == customerId);
    }

    /**
     * Adds a customer to the address book.
     * The customer must not already exist in the address book.
     */
    public void addCustomer(Customer c) {
        customers.add(c);
    }

    /**
     * Replaces the given customer {@code target} in the list with {@code editedCustomer}.
     * {@code target} must exist in the address book.
     * The customer identity of {@code editedCustomer} must not be the same as another existing customer in the address book.
     */
    public void setCustomer(Customer target, Customer editedCustomer) {
        requireNonNull(editedCustomer);

        customers.setCustomer(target, editedCustomer);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removeCustomer(Customer key) {
        customers.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return customers.asUnmodifiableObservableList().size() + "customers";
        // TODO: refine later
    }

    @Override
    public ObservableList<Customer> getCustomerList() {
        return customers.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CustomerManager // instanceof handles nulls
                && customers.equals(((CustomerManager) other).customers));
    }

    @Override
    public int hashCode() {
        return customers.hashCode();
    }
}
