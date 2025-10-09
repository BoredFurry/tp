package seedu.address.logic.commands;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.AddressContainsKeywordsPredicate;

import static java.util.Objects.requireNonNull;

public class FindByLocCommand extends Command {
    public static final String COMMAND_WORD = "findbyloc";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose address contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " Geylang Serangoon Lorong";

    private final AddressContainsKeywordsPredicate predicate;

    public FindByLocCommand(AddressContainsKeywordsPredicate predicate) {
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
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FindByNameCommand)) {
            return false;
        }

        FindByLocCommand otherFindByLocCommand = (FindByLocCommand) other;
        return predicate.equals(otherFindByLocCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", predicate)
                .toString();
    }

}
