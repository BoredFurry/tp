package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.FindByLocCommand;
import seedu.address.logic.commands.FindByNameCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.AddressContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new {@code FindByLocCommand} object
 */
public class FindByLocCommandParser implements Parser<FindByLocCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the {@code FindByLocCommand}
     * and returns a {@code FindByLocCommand} object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindByLocCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindByNameCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new FindByLocCommand(new AddressContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }

}
