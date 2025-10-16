package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.FindByCentreCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.CentreContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindByCentreCommand object
 */
public class FindByCentreCommandParser implements Parser<FindByCentreCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the
     * FindByCentreCommand and returns a FindByCentreCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindByCentreCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            FindByCentreCommand.MESSAGE_USAGE));
        }

        String[] centreKeywords = trimmedArgs.split("\\s+");

        return new FindByCentreCommand(
                new CentreContainsKeywordsPredicate(Arrays.asList(centreKeywords)));
    }
}
