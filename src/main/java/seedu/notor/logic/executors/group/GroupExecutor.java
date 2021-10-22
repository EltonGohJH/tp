package seedu.notor.logic.executors.group;

import java.util.List;

import seedu.notor.commons.core.Messages;
import seedu.notor.commons.core.index.Index;
import seedu.notor.logic.executors.Executor;
import seedu.notor.logic.executors.exceptions.ExecuteException;
import seedu.notor.model.group.SubGroup;
import seedu.notor.model.group.SuperGroup;

public abstract class GroupExecutor extends Executor {
    protected final Index index;

    public GroupExecutor(Index index) {
        this.index = index;
    }

    protected SuperGroup getGroup() throws ExecuteException {
        List<SuperGroup> lastShownList = model.getFilteredGroupList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new ExecuteException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        return lastShownList.get(index.getZeroBased());
    }

    protected SubGroup getSubGroup() throws ExecuteException {
        List<SubGroup> lastShownList = model.getFilteredSubGroupList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new ExecuteException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        return lastShownList.get(index.getZeroBased());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof GroupExecutor)) {
            return false;
        }

        GroupExecutor e = (GroupExecutor) other;

        if (index == null) {
            return e.index == null;
        }

        // state check
        return index.equals(e.index);
    }
}
