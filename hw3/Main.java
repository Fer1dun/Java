import java.util.Scanner;
/**
 * This class represents the main program for the Electronics Inventory Management System.
 * It provides a menu-driven interface for managing electronic devices in an inventory.
 */

public class Main {
    /**
     * Main method to run the program.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        /** 
         * display menu options
        */
        while (true) {
            System.out.println("Welcome to the Electronics Inventory Management System!");
            System.out.println("Please select an option:");
            System.out.println("1. Add a new device");
            System.out.println("2. Remove a device");
            System.out.println("3. Update device details");
            System.out.println("4. List all devices");
            System.out.println("5. Find the cheapest device");
            System.out.println("6. Sort devices by price");
            System.out.println("7. Calculate total inventory value");
            System.out.println("8. Restock a device");
            System.out.println("9. Export inventory report");
            System.out.println("0. Exit");

            // Prompt user for input
            System.out.print("Your choice: ");
            String choice = scanner.nextLine(); // Changed to read a String

            // Check if the input is a valid integer
            if (!choice.matches("\\d+")) {
                System.out.println("Invalid input. Please enter a number between 0 and 9.");
                continue; // Restart the loop
            }

            int option = Integer.parseInt(choice);

            switch (option) {
                case 1:
                System.out.print("Enter category name: ");
                String category = scanner.nextLine();
                System.out.print("Enter device name: ");
                String name = scanner.nextLine();
                System.out.print("Enter price: ");
                double price;
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                } else {
                    System.out.println("Invalid input. Please enter a valid price.");
                    break;
                }
                System.out.print("Enter quantity: ");
                int quantity;
                if (scanner.hasNextInt()) {
                    quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                } else {
                    System.out.println("Invalid input. Please enter a valid quantity.");
                    break;
                }
                if (category.equals("Smart Phone")) {
                    Device newPhone = new Smartphone(category, name, price, quantity);
                    inventory.addDevice(newPhone);
                }
                else if(category.equals("TV")){
                    Device newTV=new TV (category,name,price,quantity);
                    inventory.addDevice(newTV);
                }
                else if(category.equals("Laptop")){
                    Device newLaptop = new Laptop(category, name, price, quantity);
                    inventory.addDevice(newLaptop);
                }
                else if(category.equals("Headphones")){
                    Device newHeadphones = new Headphones(category, name, price, quantity);
                    inventory.addDevice(newHeadphones);
                }
                else if(category.equals("Smart Watch")){
                    Device newSmartwatch = new Smartwatch(category, name, price, quantity);
                    inventory.addDevice(newSmartwatch);
                }

                    break;
                case 2:
                    System.out.print("Enter device name: ");
                    String device_name = scanner.nextLine();
                    inventory.removeDevice(device_name);
                    break;
                case 3:
                         // Update device details
                        System.out.println("Enter the name of the device to update: ");
                        String updateDeviceName = scanner.nextLine();
                        System.out.print("Enter new price (leave blank to keep current price): ");
                        double priceInput = Double.parseDouble(scanner.nextLine().replace("$", ""));
                        System.out.println("Enter new quantity (leave blank to keep current quantity): ");
                        int quantityInput = Integer.parseInt(scanner.nextLine());
                        inventory.updateDevice(updateDeviceName, priceInput,quantityInput);
                    break;
                case 4:
                inventory.displayDevices();
                    break;
                case 5:
                    inventory.findCheapestDevice();
                    break;
                case 6:
                    // Sort devices by price
                    inventory.sortDevicesByPrice();
                    break;
                case 7:
                    // Calculate total inventory value
                    inventory.CalculateTotalPrice();
                    break;
                case 8:
                    // Restock a device
                    System.out.print("Enter the name of the device to restock: ");
                    String restock_device = scanner.nextLine();
                    System.out.print("Do you want to add or remove stock? (Add/Remove):");
                    String restock = scanner.nextLine();
                    System.out.print("Enter the quantity to"+restock+":");
                    int restock_quantity=Integer.parseInt(scanner.nextLine());
                    if(restock.equalsIgnoreCase("Add")){
                        inventory.restockDevice(restock_device,restock_quantity,true);
                    }
                    else {
                        inventory.restockDevice(restock_device,restock_quantity,false);
                    }
                    break;
                case 9:
                    // Export inventory report
                    inventory.exportInventoryReport();
                    break;
                case 0:
                    // Exit
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 9.");
            }
        }
    }
}
