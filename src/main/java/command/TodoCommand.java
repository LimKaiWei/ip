package command;

import utility.Ui;
import utility.Storage;
import utility.TaskList;
import task.TodoTask;
import exception.ElliotException;

/**
 * Creates and adds {@link TodoTask} to the {@link TaskList}.
 */
public class TodoCommand extends Command {
    private final String taskDescription;

    /**
     * Creates a {@link TodoCommand} object without any information on
     * the details of the {@link Task}.
     */
    public TodoCommand() {
        this.taskDescription = "";
    }

    private TodoCommand(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    /**
     * Parses the input string accordingly into each respective attributes.
     * Requires task description.
     *
     * @param unparsedArguments complete string of unparsed argument.
     * @return a new {@link TodoCommand} with the correctly parsed argument.
     * @throws ElliotException If command arguments are invalid or incomplete.
     */
    @Override
    public Command parseArguments(String unparsedArguments) throws ElliotException {
        if (unparsedArguments == "") {
            Ui.say("give your todo task a description\n");
            throw new ElliotException();
        }
        return new TodoCommand(unparsedArguments.strip());
    }

    /**
     * Adds {@link TodoTask} to the {@link TaskList} and prints a success message.
     *
     * @param taskList the {@link TaskList} to which the {@link TodoTask} will be added
     * to.
     * @param storage  not used in this command.
     * @return modified {@link TaskList} with the added {@link TodoTask}.
     */
    @Override
    public TaskList runCommand(TaskList taskList, Storage storage) {
        taskList = taskList.addTask(new TodoTask(taskDescription));
        Ui.say("Got it. I've added this task:\n"
                + taskList.get(taskList.size() - 1) + "\n"
                + "Now you have " + taskList.size() + " tasks in the list.\n");
        return taskList;
    }

}
