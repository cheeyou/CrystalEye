package model;

import static java.util.Objects.requireNonNull;
import static commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import commons.core.LogsCenter;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import model.customer.Customer;
import model.id.IdManager;
import storage.CentralManager;

/**
 * Represents the in-memory model of the storage book data.
 */
public class ModelManager implements Model {

    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final UserPrefs userPrefs;

    private final FilteredList<Customer> filteredCustomers;

    private final FilteredList<String> commandList;

    private final CustomerManager customerManager;
    private final IdManager idManager;

    private final CommandHistory commandHistory;

    /**
     * Initializes a ModelManager with the given storageBook and userPrefs.
     */
    public ModelManager(CentralManager centralManager, ReadOnlyUserPrefs userPrefs) {
        super();
        requireNonNull(userPrefs);

        logger.fine("Initializing with central manager: " + centralManager + " and user prefs " + userPrefs);

        this.userPrefs = new UserPrefs(userPrefs);

        this.customerManager = centralManager.getCustomerManager();
        this.idManager = centralManager.getIdManager();
        this.commandHistory = new CommandHistory();

        this.filteredCustomers = new FilteredList<>(customerManager.getCustomerList());
        this.commandList = new FilteredList<>(commandHistory.getCommandList());
    }

    // =========== UserPrefs ==================================================================================
    @Override
    public ReadOnlyUserPrefs getUserPrefs() {

    }

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {

    }

    @Override
    public GuiSettings getGuiSettings() {

    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {

    }

    @Override
    public Path getAddressBookFilePath() {

    }

    @Override
    public void setAddressBookFilePath(Path addressBookFilePath) {

    }

    // =========== CentralManager ============================================================================

    public void resetCentralManager() {
        this.customerManager.setCustomers(new CustomerManager().getCustomerList());
        this.idManager.resetIdManager();
    }

    // =========== CustomerManager ================================================================================


    // There is no need for requireNonNull() here as this is an abstracted level.
    @Override
    public CustomerManager getCustomerManager() {
        return this.customerManager;
    }

    @Override
    public void setCustomerManager(CustomerManager customerManager) {
        this.customerManager.resetData(customerManager);
    }

    @Override
    public boolean hasCustomer(Customer customer) {
        return customerManager.hasCustomer(customer);
    }

    @Override
    public void deleteCustomer(Customer target) {
        customerManager.removeCustomer(target);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerManager.addCustomer(customer);
    }

    @Override
    public void setCustomer(Customer target, Customer editedCustomer) {
        customerManager.setCustomer(target, editedCustomer);
    }

    @Override
    public Customer getCustomer(int customerId) {
        return customerManager.getCustomer(customerId);
    }

    // =========== IdManager =======================================================================

    @Override
    public int getNextCustomerId() {
        return idManager.getNextCustomerId();
    }

    @Override
    public IdManager getIdManager() {
        return idManager;
    }

    @Override
    public boolean isFreshStart() {
        return idManager.isFreshStart();
    }

    // =========== Filtered Customer List Accessors =============================================================

    @Override
    public ObservableList<Customer> getFilteredCustomerList() {
        return filteredCustomers;
    }

    @Override
    public void updateFilteredCustomerList(Predicate<Customer> predicate) {
        requireNonNull(predicate);
        filteredCustomers.setPredicate(predicate);
    }

    @Override
    public void refreshFilteredCustomerList() {
        updateFilteredCustomerList(PREDICATE_SHOW_EMPTY_CUSTOMER);
        updateFilteredCustomerList(PREDICATE_SHOW_ALL_CUSTOMERS);
    }

    // =========== Command List Accessors =====================================================================

    @Override
    public void addCommand(String command) {
        this.commandHistory.addCommand(command);
    }

    @Override
    public ObservableList<String> getFilteredCommandList() {
        return commandList;
    }
}