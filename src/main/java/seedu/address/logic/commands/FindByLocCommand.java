package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.AddressContainsKeywordsPredicate;

/**
 * Represents a command to find all persons whose address contains any of the specified keywords.
 * The search is case-insensitive and the results are displayed as a list with index numbers.
 * This command extends {@link Command} and executes the logic of filtering persons by address using
 * the provided {@link AddressContainsKeywordsPredicate}.
 *
 * <p>Example usage:</p>
 * <pre>
 * findbyloc Geylang Serangoon Lorong
 * </pre>
 *
 * @see Command
 * @see AddressContainsKeywordsPredicate
 */
public class FindByLocCommand extends Command {
    public static final String COMMAND_WORD = "findbyloc";

    /**
     * The message that provides the usage details for this command.
     * <p>Displays the correct format for invoking the command.</p>
     */
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose address contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " Geylang Serangoon Lorong";

    private final AddressContainsKeywordsPredicate predicate;

    /**
     * Constructs a {@code FindByLocCommand} with the given {@code predicate}.
     *
     * @param predicate The predicate used to filter the persons by address.
     */
    public FindByLocCommand(AddressContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    /**
     * Executes the find by location command by filtering the persons list based on the provided predicate.
     * The filtered list is then displayed to the user along with a count of the number of persons found.
     *
     * <p>This method interacts with the {@code model} to update the filtered list of persons.</p>
     *
     * @param model The model that contains the address book data.
     * @return A {@code CommandResult} containing the result message, including the number of persons found.
     * @throws CommandException If an error occurs during command execution.
     */
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredPersonList().size()));
    }

    /**
     * Returns true if the given object is equal to this {@code FindByLocCommand}.
     *
     * <p>Two {@code FindByLocCommand} objects are considered equal if they have the same predicate.</p>
     *
     * @param other The object to compare with.
     * @return true if the object is the same {@code FindByLocCommand}, or has the same predicate; false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FindByLocCommand)) {
            return false;
        }

        FindByLocCommand otherFindByLocCommand = (FindByLocCommand) other;
        return predicate.equals(otherFindByLocCommand.predicate);
    }

    /**
     * Returns a string representation of the {@code FindByLocCommand}.
     *
     * @return A string containing the class name and predicate.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", predicate)
                .toString();
    }

}
