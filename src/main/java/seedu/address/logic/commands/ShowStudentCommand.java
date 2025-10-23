package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Mentor;
import seedu.address.model.person.Person;
import seedu.address.model.person.Student;

/**
 * Shows all students mentored by the mentor identified using its displayed index from the address book.
 */
public class ShowStudentCommand extends Command {

    public static final String COMMAND_WORD = "showstudent";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Shows all students mentored by the mentor identified by the index number used "
            + "in the displayed person list.\n"
            + "Parameters: INDEX (must be a positive integer) and must be a Mentor\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_NOT_MENTOR = "The selected person is not a Mentor!";
    public static final String MESSAGE_SHOW_STUDENTS_SUCCESS = "Showing students mentored by %1$s\n"
            + "Go back to list to use the command again on another Mentor!";

    private final Index targetIndex;

    public ShowStudentCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person person = lastShownList.get(targetIndex.getZeroBased());
        if (!(person instanceof Mentor)) { //guard clause
            throw new CommandException(MESSAGE_NOT_MENTOR);
        }
        model.updateFilteredPersonList(p ->
                p instanceof Student s
                        && s.getMentor() != null
                        && s.getMentor().equals(person)
        );

        return new CommandResult(String.format(MESSAGE_SHOW_STUDENTS_SUCCESS, person.getName().fullName));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof ShowStudentCommand)) {
            return false;
        }

        ShowStudentCommand otherCommand = (ShowStudentCommand) other;
        return targetIndex.equals(otherCommand.targetIndex);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetIndex", targetIndex)
                .toString();
    }
}
