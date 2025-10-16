package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindByAddressCommand;
import seedu.address.model.person.AddressContainsKeywordsPredicate;

public class FindByAddressCommandParserTest {

    private FindByAddressCommandParser parser = new FindByAddressCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String
                .format(MESSAGE_INVALID_COMMAND_FORMAT, FindByAddressCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindByAddressCommand() {
        // no leading and trailing whitespaces
        FindByAddressCommand expectedFindByAddressCommand =
                new FindByAddressCommand(new AddressContainsKeywordsPredicate(Arrays.asList("Geylang", "Serangoon")));
        assertParseSuccess(parser, "Geylang Serangoon", expectedFindByAddressCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n Geylang \n \t Serangoon  \t", expectedFindByAddressCommand);
    }

}
