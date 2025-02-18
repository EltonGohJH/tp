package seedu.notor.logic.commands.person;

import java.util.Arrays;
import java.util.List;

import seedu.notor.logic.commands.CommandResult;
import seedu.notor.logic.executors.exceptions.ExecuteException;
import seedu.notor.logic.executors.person.PersonListExecutor;

/**
 * Lists all persons in Notor to the user.
 */
public class PersonListCommand extends PersonCommand {
    public static final String COMMAND_WORD = "list";
    public static final List<String> COMMAND_WORDS = Arrays.asList("list", "l");

    private static final String COMMAND_DESCRIPTION =
            ": Lists all person\n";

    public static final String MESSAGE_USAGE = PersonCommand.COMMAND_WORD + " /" + COMMAND_WORD + " "
            + COMMAND_DESCRIPTION
            + "Example: "
            + PersonCommand.COMMAND_WORD + " /" + COMMAND_WORD;

    private final PersonListExecutor executor;

    /**
     * Constructor for a PersonListCommand.
     */
    public PersonListCommand() {
        super(null);
        this.executor = new PersonListExecutor();
    }

    @Override
    public CommandResult execute() throws ExecuteException {
        return executor.execute();
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        return (other instanceof PersonListCommand); // instanceof handles nulls
    }
}
