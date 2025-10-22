package seedu.address.logic.commands;

import seedu.address.model.Model;
import seedu.address.model.person.MentorHasStudentsPredicate;
import seedu.address.model.person.StudentHasMentorsPredicate;

import static java.util.Objects.requireNonNull;

/**
 * Lists all mentors and students that have not been matched to a student and mentor respectively.
 */
public class ListUnmatchPersonsCommand extends Command {
    public static final String COMMAND_WORD = "listunmatched";

    public static final String MESSAGE_SUCCESS = "Listed all mentors and students who have not been matched";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(new MentorHasStudentsPredicate(model.getFilteredPersonList()));
        model.updateFilteredPersonList(new StudentHasMentorsPredicate());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
