package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This class provides storing of TaskList object into disk.
 */
public class Storage {
    private final File saveFile;

    /**
     * Created a Storage with a save file either loaded or created.
     *
     * @param filePathString the file path of the desired save file in String form
     */
    public Storage(String filePathString) {
        this.saveFile = validateAndCreateFile(filePathString);
    }

    private File validateAndCreateFile(String filePathString) {
        File saveFile = new File(filePathString);
        File parentDir = saveFile.getParentFile();

        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }
        if (!saveFile.exists()) {
            try {
                saveFile.createNewFile();
            } catch (Exception e) {
                // Fallthrough
            }
        }
        return saveFile;
    }

    /**
     * Attempts to return the {@link TaskList} from save file, otherwise returns a new
     * {@link TaskList}
     */
    public TaskList loadTaskList() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFile));
            return (TaskList) ois.readObject();
        } catch (Exception e) {
            return new TaskList();
        }
    }

    /**
     * Attempts to save the given {@link TaskList} to save file
     *
     * @param taskList a {@link TaskList} object with all {@link Task}
     */
    public void saveTaskList(TaskList taskList) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFile));
            oos.writeObject(taskList);
        } catch (Exception e) {
            // Fallthrough
        }
    }

}
