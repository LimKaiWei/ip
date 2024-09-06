package task;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Task implements Serializable {
    protected final boolean isDone;
    protected final String taskDescription;

    public Task(String taskDescription) {
        this.isDone = false;
        this.taskDescription = taskDescription;
    }

    protected Task(boolean isDone, String taskDescription) {
        this.isDone = isDone;
        this.taskDescription = taskDescription;
    }

    public boolean findMatch(Pattern searchTerm) {
        return searchTerm.matcher(taskDescription).find();
    }

    public Task markAsDone() {
        return isDone
            ? this
            : new Task(true, this.taskDescription);
    }

    public Task markAsUndone() {
        return isDone
            ? new Task(this.taskDescription)
            : this;
    }

    @Override
    public String toString() {
        return isDone
            ? "[X] " + taskDescription
            : "[ ] " + taskDescription;
    }
}
