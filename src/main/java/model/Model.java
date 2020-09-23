package model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import model.customer.Customer;
import model.id.IdManager;
import storage.CentralManager;

/**
 * The API of the Model component.
 */
public interface Model {
    /**
     * (@code Predicate) that always evaluates to true
     */
    Predicate<Customer> PREDICATE_SHOW_ALL_CUSTOMERS = unused -> true;

    /**
     * {@code Predicate} that always evaluate to false
     */
    Predicate<Customer> PREDICATE_SHOW_EMPTY_CUSTOMER = unused -> false;

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Resets the {@link CentralManager} to a empty state. All data will be removed.
     */
    void resetCentralManager();

    /**
     * Returns the customer manager at the given state
     * @return customer manager at the given state
     */
    CustomerManager getCustomerManager();

    /**
     * Replaces customer manager data with the data in (@code customerManager)
     */
    void setCustomerManager(CustomerManager customerManager);

    /**
     * Returns true if a customer with the same identity as {@code customer} exists in
     * the address book.
     */
    boolean hasCustomer(Customer customer);

    /**
     * Deletes the given customer. The customer must exist in the address book.
     */
    void deleteCustomer(Customer target);

    /**
     * Adds the given customer. {@code customer} must not already exist in the address
     * book.
     */
    void addCustomer(Customer customer);

    /**
     * Replaces the given customer {@code target} with {@code editedCustomer}.
     * {@code target} must exist in the address book. The customer identity of
     * {@code editedCustomer} must not be the same as another existing customer in the
     * address book.
     */
    void setCustomer(Customer target, Customer editedCustomer);

    /**
     * Returns a customer with the given id tag
     * @param customerId the id tag of the customer
     * @return Customer with the given id tag
     */
    Customer getCustomer(int customerId);

    int getNextCustomerId();

    IdManager getIdManager();

    boolean isFreshStart();

    /**
     * Returns an unmodifiable view of the filtered customer list.
     */
    ObservableList<Customer> getFilteredCustomerList();

    /**
     * Updates the filter of the filtered customer list to filter by the given
     * {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredCustomerList(Predicate<Customer> predicate);

    /**
     * Refreshes the display of customer list.
     */
    void refreshFilteredCustomerList();

    /**
     * Adds command to the command list
     */
    void addCommand(String command);

    /**
     * Returns the unmodifiable view of the command list
     */
    ObservableList<String> getFilteredCommandList();

}
