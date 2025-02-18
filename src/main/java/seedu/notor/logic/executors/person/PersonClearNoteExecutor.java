package seedu.notor.logic.executors.person;

import static seedu.notor.commons.util.CollectionUtil.requireAllNonNull;

import seedu.notor.commons.core.index.Index;
import seedu.notor.logic.commands.CommandResult;
import seedu.notor.logic.executors.exceptions.ExecuteException;
import seedu.notor.model.common.Note;
import seedu.notor.model.person.Person;
import seedu.notor.ui.WarningWindow;

/**
 * Executor for a PersonNoteCommand.
 */
public class PersonClearNoteExecutor extends PersonExecutor {
    public static final String MESSAGE_CLEAR_NOTE_SUCCESS = "Cleared note of Person: %1$s";
    public static final String MESSAGE_CLEAR_NOTE_CANCEL = "Deleting of Person: %1$s has been cancelled.";
    public static final String CONFIRMATION_MESSAGE = "Do you want to proceed with clearing note of Person: %1$s?";


    /**
     * Constructor for a PersonNoteExecutor instance.
     *
     * @param index Index of the person to clear note.
     *
     */
    public PersonClearNoteExecutor(Index index) {
        super(index);
        requireAllNonNull(index);
    }

    @Override
    public CommandResult execute() throws ExecuteException {
        checkPersonList();
        Person storedPerson = super.getPerson();
        WarningWindow warningWindow = new WarningWindow(String.format(CONFIRMATION_MESSAGE,
                storedPerson.getName()));
        warningWindow.show();
        if (warningWindow.canContinue()) {
            Person editedPerson = new Person(
                    storedPerson.getName(), storedPerson.getPhone(), storedPerson.getEmail(),
                    Note.EMPTY_NOTE, storedPerson.getTags());
            model.setPerson(editedPerson, editedPerson);
            return new CommandResult(generateSuccessMessage(editedPerson), false, false, false);
        }
        return new CommandResult(String.format(MESSAGE_CLEAR_NOTE_CANCEL, storedPerson));
    }

    /**
     * Generates a command execution success message based on whether
     * the note is added.
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(Person personToEdit) {
        return String.format(MESSAGE_CLEAR_NOTE_SUCCESS, personToEdit);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonClearNoteExecutor)) {
            return false;
        }

        PersonClearNoteExecutor e = (PersonClearNoteExecutor) other;

        // state check
        return super.equals(other);
    }
}
