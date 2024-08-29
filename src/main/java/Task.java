import java.io.Serializable;

public class Task implements Serializable{
    private static final long serialVersionUID = 3L;
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
