package Main;

import java.util.ArrayList;

/**
 * A class to manage the list of all customers
 */
public class CustomerManager {
    private ArrayList<Customer> customerList;

    public CustomerManager() {
        this.customerList = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomerList() {
        return this.customerList;
    }

    public Boolean isExistingCustomer(Customer newCustomer) {
        for (Customer customer: customerList) {
            if (customer.isSameCustomer(newCustomer)) {
                return true;
            }
        }
        return false;
    }
    public void addCustomer(Customer customerToAdd) {
        if (!isExistingCustomer(customerToAdd)) {
            this.customerList.add(customerToAdd);
        }
    }

    public void printCustomerList() {
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }
}
