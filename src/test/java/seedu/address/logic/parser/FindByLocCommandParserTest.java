package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindByLocCommand;
import seedu.address.model.person.AddressContainsKeywordsPredicate;

public class FindByLocCommandParserTest {

    private FindByLocCommandParser parser = new FindByLocCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindByLocCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindByLocCommand() {
        // no leading and trailing whitespaces
        FindByLocCommand expectedFindByLocCommand =
                new FindByLocCommand(new AddressContainsKeywordsPredicate(Arrays.asList("Geylang", "Serangoon")));
        assertParseSuccess(parser, "Geylang Bob", expectedFindByLocCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n Geylang \n \t Serangoon  \t", expectedFindByLocCommand);
    }

}
