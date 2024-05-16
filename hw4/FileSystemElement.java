import java.sql.Timestamp;
/**
 * Represents a generic element within a filesystem, providing a common structure
 * for files and directories. This abstract class defines the basic properties and methods
 * that are common to all types of filesystem elements.
 */
public abstract class FileSystemElement {
    protected String name;
    protected Timestamp dateCreated;
    protected FileSystemElement parent;
    
    /**
     * Constructs a new FileSystemElement with specified name, creation date, and parent.
     *
     * @param name The name of the filesystem element
     * @param dateCreated The date and time at which the element was created
     * @param parent The parent of this element in the filesystem hierarchy
     */
    public FileSystemElement(String name, Timestamp dateCreated, FileSystemElement parent) {
        this.name = name;
        this.dateCreated = dateCreated;
        this.parent = parent;
    }
     /**
     * Returns the name of the filesystem element.
     *
     * @return The name of the element.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the creation date and time of the filesystem element.
     *
     * @return The date and time the element was created.
     */
    public Timestamp getDateCreated() {
        return dateCreated;
    }
     /**
     * Returns the parent of the filesystem element in the hierarchy.
     *
     * @return The parent element, or null if this is a root element.
     */
    public FileSystemElement getParent() {
        return parent;
    }
    /**
     * Sets the parent of the filesystem element.
     *
     * @param parent The new parent element for this filesystem element.
     */
    public void setParent(FileSystemElement parent) {
        this.parent = parent;
    }

    public abstract void print(String prefix);  // For printing the structure in a tree format
}
