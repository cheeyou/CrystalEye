package logic.commands;

import static java.util.Objects.requireNonNull;

import model.customer.NameContainsPhrasePredicate;

public class FindCommand extends Command{

    public static final String COMMAND_WORD = "find";

    private final NameContainsPhrasePredicate predicate;

    public FindCommand(NameContainsPhrasePredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindCommand // instanceof handles nulls
                && predicate.equals(((FindCommand) other).predicate)); // state check
    }
}
