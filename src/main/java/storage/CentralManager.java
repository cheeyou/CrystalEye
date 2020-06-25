package storage;

import Main.CustomerManager;

/**
 * Wraps all the data needed to be used for saving and loading
 * Vital for handling undo and redo
 */
public class CentralManager {

    private CustomerManager customerManager;

    public CentralManager() {
        this.customerManager = new CustomerManager();
    }

    public CentralManager(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    public CustomerManager getCustomerManager() {
        return this.customerManager;
    }
}
