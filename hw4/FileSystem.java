import java.sql.Timestamp;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
/**
 * Represents the entire file system, managing directories and files within it.
 * This class provides methods for navigating the file system, creating, deleting,
 * and moving files or directories, as well as listing contents and sorting them.
 */
public class FileSystem {
    private Directory root;
    private Directory currentDirectory;
    /**
     * Constructs the file system and initializes it with a root and a default "home" directory.
     */
    public FileSystem() {
        this.root = new Directory("root", new Timestamp(System.currentTimeMillis()), null);
        this.currentDirectory =new Directory("home", new Timestamp(System.currentTimeMillis()), root); // Start at the root directory
        root.addElement(currentDirectory);
    }
     /**
     * Changes the current directory to a new directory specified by the user.
     * @param scanner A scanner to read user input for the directory path.
     */
    public void changeDirectory(Scanner scanner) {
        System.out.println("Current directory: " + getCurrentPath(currentDirectory));   
        System.out.print("Enter new directory path: ");
        String path = scanner.nextLine();
        Directory target = navigateTo(path);
        if (target != null) {
            currentDirectory = target;
            System.out.println("Directory changed to: " + getCurrentPath(currentDirectory));
        } else {
            System.out.println("Invalid path.");
        }
    }
    /**
     * Navigates to a directory within the file system based on a path.
     * @param path A string representing the path to navigate.
     * @return The directory if found, or null if not.
     */
    public Directory navigateTo(String path) {
        String[] directories = path.split("/");
        Directory currentDirectory = root;  
    
        int startIndex = 0;
        if (directories.length > 0 && directories[0].equals("root")) {
            startIndex = 1;  
        }
    
        for (int i = startIndex; i < directories.length; i++) {
            String directory = directories[i];
            if (!directory.isEmpty()) {
                LinkedList<FileSystemElement> children = currentDirectory.getChildren();
                boolean found = false;
                for (FileSystemElement element : children) {
                    if (element.getName().equals(directory) && element instanceof Directory) {
                        currentDirectory = (Directory) element;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Directory not found: " + directory);
                    return null;
                }
            }
        }
    
        return currentDirectory;
    }
    /**
     * Retrieves the full path from the current directory back to the root.
     * @param item The filesystem element to determine the path for.
     * @return A string representing the full path.
     */
    public String getCurrentPath(FileSystemElement item) {
        StringBuilder path = new StringBuilder();
        FileSystemElement element = item;
        while (element.getName() != "root") {
            path.insert(0, element.getName() + "/");
            element = element.getParent();
        }
        return path.toString();
    }
     /**
     * Lists the contents of the current directory.
     */
    public void listContents() {
        System.out.println("Current directory: " + getCurrentPath(currentDirectory));
        currentDirectory.print("");
    }
     /**
     * Creates a new file or directory within the current directory.
     * @param scanner A scanner to read user input for the file or directory creation.
     */
    public void createFileOrDirectory(Scanner scanner) {
        System.out.println("Current directory: " + getCurrentPath(currentDirectory));
        System.out.print("Create file or directory (f/d): ");
        String type = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        if (type.equalsIgnoreCase("f")) {
            File newFile = new File(name, new Timestamp(System.currentTimeMillis()), currentDirectory);
            currentDirectory.addElement(newFile);
            System.out.println("File created: " + name);
        } else if (type.equalsIgnoreCase("d")) {
            Directory newDir = new Directory(name, new Timestamp(System.currentTimeMillis()), currentDirectory);
            currentDirectory.addElement(newDir);
            System.out.println("Directory created: " + name);
        } else {
            System.out.println("Invalid type.");
        }
    }
    /**
     * Deletes a file or directory from the current directory.
     * @param scanner A scanner to read user input for the name of the file or directory to delete.
     */
    public void deleteFileOrDirectory(Scanner scanner) {
        System.out.println("Current directory: " + getCurrentPath(currentDirectory));
        System.out.print("Enter name of file/directory to delete: ");
        String name = scanner.nextLine();
        boolean removed = currentDirectory.removeElementByName(name);
        if (removed) {
            System.out.println(name + " deleted.");
        } else {
            System.out.println("File/Directory not found.");
        }
    }
    /**
     * Moves a file or directory to a new directory.
     * @param scanner A scanner to read user input for the name of the file or directory to move and the new path.
     */
    public void moveFileOrDirectory(Scanner scanner) {
        System.out.println("Current directory: " + getCurrentPath(currentDirectory));
        System.out.print("Enter the name of file/directory to move: ");
        String name = scanner.nextLine();
        System.out.print("Enter new directory path: ");
        String newPath = scanner.nextLine();
    

        FileSystemElement itemToMove = null;
        for (FileSystemElement element : currentDirectory.getChildren()) {
            if (element.getName().equals(name)) {
                itemToMove = element;
                break;
            }
        }
        if (itemToMove == null) {
            System.out.println("No such file or directory found in the current directory.");
            return;
        }
    
        Directory newDirectory = navigateTo(newPath);
        if (newDirectory == null) {
            System.out.println("Invalid new directory path.");
            return;
        }
    
        if (newDirectory == currentDirectory) {
            System.out.println("The new directory path is the same as the current directory.");
            return;
        }
        if (moveElementToDirectory(itemToMove, newDirectory)) {
            System.out.println("Successfully moved '" + name + "' to '" + newPath + "'.");
        } else {
            System.out.println("Failed to move '" + name + "'.");
        }
    }
     /**
     * Moves an element to a new directory and updates its parent reference.
     * @param element The element to move.
     * @param newDirectory The directory to move the element to.
     * @return true if the operation was successful, false otherwise.
     */
    public boolean moveElementToDirectory(FileSystemElement element, Directory newDirectory) {
        // Check if the element has a parent and the parent is a Directory
        if (element.getParent() != null && element.getParent() instanceof Directory) {
            Directory parentDirectory = (Directory) element.getParent();
            parentDirectory.removeElementByName(element.getName());
        }
    
        // Add the element to the new directory and update its parent reference
        element.setParent(newDirectory);
        newDirectory.addElement(element);
        return true;
    }
    /**
     * Searches for files or directories matching a given query in the current directory and all subdirectories.
     * @param scanner A scanner to read user input for the search query.
     */
    public void searchFileOrDirectory(Scanner scanner) {
        System.out.println("Current directory: " + getCurrentPath(currentDirectory));
        System.out.print("Enter search query: ");
        String query = scanner.nextLine();
        ArrayList<FileSystemElement> items=new ArrayList<>();
        searchRecursively(currentDirectory,query,items);
        if(items.isEmpty()){
            System.out.println("No files or directories found matching: " + query);
        }
        else {
            System.out.println("Found files/directories:");
            for (FileSystemElement item : items) {
                System.out.println("Found Path: " + getCurrentPath(item));
            }
        }
    }
     /**
     * Recursively searches for files or directories matching the given query starting from a specified directory.
     * @param dir The starting directory for the search.
     * @param query The search query.
     * @param items The list to store found items.
     */
    public void searchRecursively(Directory dir,String query,ArrayList<FileSystemElement> items){
        for(FileSystemElement element:dir.getChildren()){
            if(element.getName().equalsIgnoreCase(query)){
                items.add(element);
            }
            if(element instanceof Directory){
                searchRecursively((Directory)element, query, items);
            }

        }
    }
     /**
     * Prints a structured tree view of the current directory and its subdirectories.
     */
    public void printDirectoryTree() {
        System.out.println("Path to current directory from root:");
        
        // Build the path from the current directory back to the root
        LinkedList<String> pathStack = new LinkedList<>();
        Directory dir = currentDirectory;
        while (dir != null) {
            pathStack.push(dir.getName() + (dir == currentDirectory ? "/" : "/"));
            dir = (Directory) dir.getParent();  
                }

    
        // Print the path from the root to the current directory
        String indent = "";
        while (!pathStack.isEmpty()) {
            System.out.println(indent + "*" + pathStack.pop());
            indent += "    ";  
        }

        printFilesInCurrentDirectory(currentDirectory, indent);
    }
    /**
     * Lists the files in the current directory, formatted to show nesting and hierarchy.
     * @param dir The directory to print files from.
     * @param indent Indentation to apply to each line, indicating depth in the directory hierarchy.
     */
    public void printFilesInCurrentDirectory(Directory dir, String indent) {
        for (FileSystemElement element : dir.getChildren()) {
            if (!(element instanceof Directory)) {
                System.out.println(indent + "└── " + element.getName());
            }
        }
    }
    /**
     * Sorts the contents of the current directory by their creation dates.
     */
    public void sortContentsByDate() {
        System.out.println("Current directory: " + getCurrentPath(currentDirectory));
        currentDirectory.sortChildrenByDate();
        LinkedList<FileSystemElement> sortedChildren = currentDirectory.getChildren();
    for (FileSystemElement element : sortedChildren) {
        if (element instanceof Directory) {
            System.out.println("Directory: " + element.getName() + " - Created: " + element.getDateCreated());
        } else {
            System.out.println("File: " + element.getName() + " - Created: " + element.getDateCreated());
        }
    }
    }
}
