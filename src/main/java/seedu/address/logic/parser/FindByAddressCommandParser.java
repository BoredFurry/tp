package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.FindByAddressCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.AddressContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindByAddressCommand object
 */
public class FindByAddressCommandParser implements Parser<FindByAddressCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindByAddressCommand
     * and returns a FindByAddressCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindByAddressCommand parse(String string) throws ParseException {
        String stripped = string.strip();
        if (stripped.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindByAddressCommand.MESSAGE_USAGE));
        }
        return new FindByAddressCommand(
                new AddressContainsKeywordsPredicate(stripped));
    }

}
