package logic;

import java.nio.file.Path;
import java.text.ParseException;

import javafx.collections.ObservableList;
import logic.commands.CommandResult;
import model.customer.Customer;

/**
 * API of the Logic component
 */
public interface Logic {

    /**
     * Executes the command and returns the result.
     *
     * @param commandText Command as entered by the user. (CHANGE THIS)
     * @return result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Retrieves customer for view Customer window.
     */
    Customer getCustomer(int customerId);

    boolean isFreshStart();

    /**
     * Returns an unmodifiable view of the filtered list of customers.
     *
     * @return unmodifiable view of the filtered list of customers
     */
    ObservableList<Customer> getFilteredCustomerList();

    /**
     * Returns an unmodifiable view of the command list.
     *
     * @return unmodifiable view of the command list.
     */
    ObservableList<String> getCommandList();
}
