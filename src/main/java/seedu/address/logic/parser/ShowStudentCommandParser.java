package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ShowStudentCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ShowStudentCommand object.
 */
public class ShowStudentCommandParser implements Parser<ShowStudentCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ShowStudentCommand
     * and returns a ShowStudentCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ShowStudentCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new ShowStudentCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ShowStudentCommand.MESSAGE_USAGE), pe);
        }
    }
}
