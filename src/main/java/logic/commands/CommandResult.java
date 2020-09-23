package logic.commands;

import static java.util.Objects.requireNonNull;
/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;
    private String tabType;
    private int id;

    /** Help information should be shown to the user. */
    private final boolean showHelp;

    /** The application should exit. */
    private final boolean exit;

    /** ViewWindow should be shown to the user*/
    private final boolean viewDriver;
    private final boolean viewCustomer;

    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.exit = exit;
        this.tabType = DE
    }

}
