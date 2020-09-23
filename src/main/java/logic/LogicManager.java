package logic;

import java.nio.file.Path;
import java.text.ParseException;
import java.util.logging.Logger;

import commons.core.LogsCenter;
import javafx.collections.ObservableList;
import logic.commands.Command;
import logic.commands.CommandResult;
import model.Model;
import model.customer.Customer;
import storage.Storage;

/**
 * The main LogicManager of the app.
 */
public class LogicManager implements Logic {
    public static final String FILE_OPS_ERROR_MESSAGE = "Could not save data to file: ";
    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model model;
    private final Storage storage;
    private final CommandParser commandParser;

    public LogicManager(Model model, Storage storage) {
        this.model = model;
        this.storage = storage;
        commandParser = new CommandParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {

        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult;
        Command command = commandParser
    }

    @Override
    public GuiSettings getGuiSettings() {
        return model.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        model.setGuiSettings(guiSettings);
    }

    @Override
    public Path getAddressBookFilePath() {
        return model.getAddressBookFilePath();
    }

    @Override
    public Customer getCustomer(int customerId) {
        return model.getCustomer(customerId);
    }

    @Override
    public boolean isFreshStart() {
        return model.isFreshStart();
    }

    @Override
    public ObservableList<Customer> getFilteredCustomerList() {
        return model.getFilteredCustomerList();
    }

    @Override
    public ObservableList<String> getCommandList() {
        return model.getFilteredCommandList();
    }
}
