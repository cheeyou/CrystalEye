package model;

import static java.util.Objects.requireNonNull;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Keeps track of the past commands executed by the user.
 */
public class CommandHistory {

    private final ObservableList<String> commandList = FXCollections.observableArrayList();
    private final ObservableList<String> commandListUnmodifiable =
            FXCollections.unmodifiableObservableList(commandList);

    public CommandHistory() {
    }

    /**
     * Adds a command into the command list.
     *
     * @param command inputted command by user.
     */
    public void addCommand(String command) {
        requireNonNull(command);
        commandList.add(command);
    }

    /**
     * Returns an unmodifiable command list.
     */
    public ObservableList<String> getCommandList() {
        return commandListUnmodifiable;
    }
}
