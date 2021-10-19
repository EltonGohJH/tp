package seedu.notor.logic.parser.person;

import seedu.notor.logic.commands.person.PersonDeleteCommand;
import seedu.notor.logic.parser.exceptions.ParseException;

public class PersonDeleteCommandParser extends PersonCommandParser {
    public PersonDeleteCommandParser(String unparsedIndex) throws ParseException {
        super(unparsedIndex, null);
    }

    /**
     * Parses the given {@code Index} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public PersonDeleteCommand parse() throws ParseException {
        return new PersonDeleteCommand(index);
    }
}
