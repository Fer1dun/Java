import java.util.Scanner;
/**
 * The Main class serves as the entry point for the file system management application.
 * It provides a text-based menu system that allows the user to perform various operations
 * such as changing directories, listing contents, creating or deleting files and directories,
 * moving items, searching, and sorting contents based on creation date.
 */
public class Main {
     /**
     * The main method starts the application, initializes the FileSystem, and handles user
     * interactions through a menu-driven interface. It continues to prompt the user to
     * choose an action until they decide to exit.
     *
     * @param args Command-line arguments, not used in this application.
     */
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== File System Management Menu =====");
            System.out.println("1. Change directory");
            System.out.println("2. List directory contents");
            System.out.println("3. Create file/directory");
            System.out.println("4. Delete file/directory");
            System.out.println("5. Move file/directory");
            System.out.println("6. Search file/directory");
            System.out.println("7. Print directory tree");
            System.out.println("8. Sort contents by date created");
            System.out.println("9. Exit");
            System.out.print("Please select an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    fs.changeDirectory(scanner);
                    break;
                case 2:
                    fs.listContents();
                    break;
                case 3:
                    fs.createFileOrDirectory(scanner);
                    break;
                case 4:
                    fs.deleteFileOrDirectory(scanner);
                    break;
                case 5:
                    fs.moveFileOrDirectory(scanner);
                    break;
                case 6:
                    fs.searchFileOrDirectory(scanner);
                    break;
                case 7:
                    fs.printDirectoryTree();
                    break;
                case 8:
                    fs.sortContentsByDate();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (choice != 9);
        scanner.close();
    }
}
