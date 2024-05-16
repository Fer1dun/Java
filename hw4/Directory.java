import java.util.LinkedList;
import java.util.Comparator;
import java.sql.Timestamp;
/**
 * Represents a directory in a filesystem. This class extends {@link FileSystemElement} to include
 * functionalities specific to directories, such as managing child elements.
 */
public class Directory extends FileSystemElement {
    private LinkedList<FileSystemElement> children;
     /**
     * Constructs a new Directory with the  name, date and parent.
     *
     * @param name the name of the directory
     * @param dateCreated the date and time the directory 
     * @param parent the parent element of this directory
     */
    public Directory(String name, Timestamp dateCreated, FileSystemElement parent) {
        super(name, dateCreated, parent);
        this.children = new LinkedList<>();
    }
     /**
     * Adds a file system item to this directory
     *
     * @param element the filesystem element to add
     */
    public void addElement(FileSystemElement element) {
        element.setParent(this);
        children.add(element);
    }
    /**
     * Removes the specified element itself and its contents
     *
     * @param name the name of the element to remove
     * @return {@code true} if at least one element was removed
     */
    public boolean removeElementByName(String name) {
        LinkedList<FileSystemElement> toRemove = new LinkedList<>();  
        boolean found = false;

        for (FileSystemElement element : children) {
            if (element.getName().equals(name)) {
                toRemove.add(element);
                found = true;  
            } else if (element instanceof Directory) {

                found = ((Directory) element).removeElementByName(name) || found;
            }
        }

        // Remove all identified elements in the separate step
        for (FileSystemElement element : toRemove) {
            children.remove(element);
        }

        return found;
    }
     /**
     * Returns a list of all child elements
     *
     * @return a {@link LinkedList} of {@link FileSystemElement} representing the children
     */
    public LinkedList<FileSystemElement> getChildren() {
        return children;
    }
    /**
     * Sorts the child elements of this directory by their creation date.
     */
    public void sortChildrenByDate() {
        children.sort(Comparator.comparing(FileSystemElement::getDateCreated));
    }
    /**
     * Writes this array and its children
     */
    @Override
    public void print(String prefix) {
        System.out.println(prefix + "Directory: " + name);
        children.forEach(child -> child.print(prefix + "    "));
    }
}
