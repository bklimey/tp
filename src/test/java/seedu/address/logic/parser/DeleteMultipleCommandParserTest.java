package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.DeleteMultipleCommand;
import seedu.address.model.person.MultiplePredicates;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.NationalityContainsKeywordsPredicate;
import seedu.address.model.person.Person;
import seedu.address.model.person.PhoneContainsKeywordsPredicate;
import seedu.address.model.person.TutorialGroupContainsKeywordsPredicate;

public class DeleteMultipleCommandParserTest {

    private DeleteMultipleCommandParser parser = new DeleteMultipleCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteMultipleCommand.MESSAGE_USAGE));

        // invalid input followed by valid input e.g. deletem n/ n/Alice should throw error
    }

    @Test
    public void parse_validArgs_returnsDeleteMultipleCommand() {
        MultiplePredicates predicate = new MultiplePredicates(new ArrayList<Predicate<Person>>(List.of(
                new NameContainsKeywordsPredicate(List.of("Alice")),
                new PhoneContainsKeywordsPredicate(List.of("91234456")),
                new NationalityContainsKeywordsPredicate(List.of("MY")),
                new TutorialGroupContainsKeywordsPredicate(List.of("19"))
        )));

        // no leading and trailing whitespaces
        DeleteMultipleCommand expectedDeleteMultipleCommand =
                new DeleteMultipleCommand(predicate);
        assertParseSuccess(parser, " n/Alice p/91234456 nat/MY tg/19", expectedDeleteMultipleCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser,
                " \n n/Alice \n \t p/91234456 \n \t nat/MY \n \t tg/19 \t", expectedDeleteMultipleCommand);
    }

}