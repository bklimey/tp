package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GENDER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NATIONALITY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SOCIAL_HANDLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL_GROUP;

import seedu.address.logic.commands.SortCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.comparator.EmailComparator;
import seedu.address.model.comparator.GenderComparator;
import seedu.address.model.comparator.NameComparator;
import seedu.address.model.comparator.NationalityComparator;
import seedu.address.model.comparator.PhoneComparator;
import seedu.address.model.comparator.RemarkComparator;
import seedu.address.model.comparator.SocialHandleComparator;
import seedu.address.model.comparator.TagComparator;
import seedu.address.model.comparator.TutorialGroupComparator;

/**
 * Parses input arguments and creates a new SortCommand object
 */
public class SortCommandParser implements Parser<SortCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the SortCommand
     * and returns a SortCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public SortCommand parse(String args) throws ParseException {
        requireNonNull(args);

        String trimmedArgs = args.trim().toLowerCase();

        if (PREFIX_NAME.getPrefix().equals(trimmedArgs)) {
            return new SortCommand(new NameComparator());
        }
        if (PREFIX_PHONE.getPrefix().equals(trimmedArgs)) {
            return new SortCommand(new PhoneComparator());
        }
        if (PREFIX_EMAIL.getPrefix().equals(trimmedArgs)) {
            return new SortCommand(new EmailComparator());
        }
        if (PREFIX_NATIONALITY.getPrefix().equals(trimmedArgs)) {
            return new SortCommand(new NationalityComparator());
        }
        if (PREFIX_TUTORIAL_GROUP.getPrefix().equals(trimmedArgs)) {
            return new SortCommand(new TutorialGroupComparator());
        }
        if (PREFIX_SOCIAL_HANDLE.getPrefix().equals(trimmedArgs)) {
            return new SortCommand(new SocialHandleComparator());
        }
        if (PREFIX_GENDER.getPrefix().equals(trimmedArgs)) {
            return new SortCommand(new GenderComparator());
        }
        if (PREFIX_REMARK.getPrefix().equals(trimmedArgs)) {
            return new SortCommand(new RemarkComparator());
        }
        if (PREFIX_TAG.getPrefix().equals(trimmedArgs)) {
            return new SortCommand(new TagComparator());
        }

        throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
    }
}