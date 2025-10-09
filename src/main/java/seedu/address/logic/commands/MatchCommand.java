package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Matches a tutor and tutee.
 */
public class MatchCommand extends Command {
    public static final String COMMAND_WORD = "match";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult("Hello from match");
    }
}
