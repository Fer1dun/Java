import java.sql.Timestamp;
/**
 * Represents a file within a filesystem. This class extends {@link FileSystemElement}
 */
public class File extends FileSystemElement {
     /**
     * Constructs a new File instance with a specified name, creation date, and parent element.
     *
     * @param name The name of the file
     * @param dateCreated The date and time when the file was created.
     * @param parent The parent element to which this file belongs.
     */
    public File(String name, Timestamp dateCreated, FileSystemElement parent) {
        super(name, dateCreated, parent);
    }
     /**
     * Prints a formatted representation of the file to the standard output.
     */
    @Override
    public void print(String prefix) {
        System.out.println(prefix + "File: " + name);
    }
}
