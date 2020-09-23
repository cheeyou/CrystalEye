package storage;

import java.util.Objects;

import model.CustomerManager;
import model.id.IdManager;

/**
 * Wraps all the data needed to be used for saving and loading
 * Vital for handling undo and redo
 */
public class CentralManager {

    private CustomerManager customerManager;
    private IdManager idManager;

    public CentralManager() {
        this.customerManager = new CustomerManager();
        this.idManager = new IdManager();
    }

    public CentralManager(CustomerManager customerManager, IdManager idManager) {
        this.customerManager = customerManager;
        this.idManager = idManager;
    }

    public CustomerManager getCustomerManager() {
        return customerManager;
    }

    public IdManager getIdManager() {
        return idManager;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CentralManager // instanceof handles nulls
                && getCustomerManager().equals(((CentralManager) other).getCustomerManager())
                && getIdManager().equals(((CentralManager) other).getIdManager()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerManager(), getIdManager());
    }
}
