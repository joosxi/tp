package seedu.watson.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.watson.commons.core.Messages;
import seedu.watson.model.Model;
import seedu.watson.model.student.FindCommandPredicate;

/**
 * Finds and lists all persons in watson book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindNameCommand extends Command {

    public static final String COMMAND_WORD = "findName";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
                                               + "the specified keywords (case-insensitive) and displays them"
                                               + " as a list with index numbers.\n"
                                               + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
                                               + "Example: " + COMMAND_WORD + " alice bob charlie";

    private final FindCommandPredicate predicate;

    public FindNameCommand(FindCommandPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(predicate);
        return new CommandResult(
            String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
               || (other instanceof FindNameCommand // instanceof handles nulls
                   && predicate.equals(((FindNameCommand) other).predicate)); // state check
    }
}
