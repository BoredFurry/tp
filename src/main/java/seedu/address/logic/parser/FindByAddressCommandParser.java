package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

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
    public FindByAddressCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindByAddressCommand.MESSAGE_USAGE));
        }

        String[] addressKeywords = trimmedArgs.split("\\s+");

        return new FindByAddressCommand(
                new AddressContainsKeywordsPredicate(Arrays.asList(addressKeywords)));
    }

}
