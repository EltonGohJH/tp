package seedu.notor.logic.commands.person;

import static java.util.Objects.requireNonNull;
import static seedu.notor.logic.parser.CliSyntax.PREFIX_GROUPNAME;
import static seedu.notor.logic.parser.CliSyntax.PREFIX_NAME;

import seedu.notor.logic.commands.Command;
import seedu.notor.logic.commands.CommandResult;
import seedu.notor.logic.commands.exceptions.CommandException;
import seedu.notor.model.Model;
import seedu.notor.model.person.Person;

/**
 * Deprecated for now.
 * TODO: move this functionality into PersonRemoveGroupCommand since we do not have remove subgroup command anymore
 */
@Deprecated
public class PersonRemoveSubGroupCommand implements Command {

    public static final String COMMAND_WORD = "person_rm_subgroup";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Removes a person from a subgroup"
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_GROUPNAME + "GROUP NAME"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_GROUPNAME + "Orbital";

    public static final String MESSAGE_SUCCESS = "Removed person from %s";
    public static final String MESSAGE_NOT_IN_SUBGROUP = "This person is not in the subgroup";

    protected String personName;

    protected String groupName;

    protected String subGroupName;

    /**
     * Creates an PersonRemoveSubGroupCommand to add the specified {@code Person}
     */
    public PersonRemoveSubGroupCommand(String personName, String groupName, String subGroupName) {
        this.personName = personName;
        this.groupName = groupName;
        this.subGroupName = subGroupName;
    }


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        Person personToEdit = model.findPerson(personName);
        // SubGroup subGroup = model.findGroup(groupName).findSubGroup(subGroupName);
        // subGroup.removePerson(personToEdit);
        // personToEdit.removeSuperGroup(subGroup);
        model.setPerson(personToEdit, personToEdit);
        return new CommandResult(String.format(MESSAGE_SUCCESS, groupName + "_" + subGroupName));
    }
}
