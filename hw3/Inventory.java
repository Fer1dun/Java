import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Date;

/**
 * Represents an inventory management system for electronic devices.
 */
public class Inventory {
    private LinkedList<ArrayList<Device>> inventoryList;

     /**
     * Constructs an empty inventory.
     */
    public Inventory() {
        inventoryList = new LinkedList<>();
    }
     /**
     * Calculates the total value of the inventory.
     * Time Complexity: O(n*m), where n is the number of categories and m is the average number of devices per category.
     * @implNote This method iterates over each device in the inventory to calculate the total value. 
     *           The time complexity depends on the number of categories and devices per category.
     */
    public void CalculateTotalPrice(){
        double totalPrice=0.0;
        for (ArrayList<Device> list : inventoryList) {
            for (Device device : list) {
                totalPrice+=device.getPrice()*device.getQuantity();
            }
        }
        System.out.println("Total inventory value:$"+totalPrice);

    }
     /**
     * Exports the inventory report to the console.
     * Time Complexity: O(n*m), where n is the number of categories and m is the average number of devices per category.
     * @implNote This method iterates over each device in the inventory to generate the report.
     *           The time complexity depends on the number of categories and devices per category.
     */
    public void exportInventoryReport() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String currentDate = dateFormat.format(new Date());

        System.out.println("Electronics Shop Inventory Report");
        System.out.println("Generated on: " + currentDate);
        System.out.println("---------------------------------------");
        System.out.println("| No. | Category | Name | Price | Quantity |");
        System.out.println("---------------------------------------");

        int count = 1;
        double totalInventoryValue = 0.0;
        for (ArrayList<Device> list : inventoryList) {
            for (Device device : list) {
                System.out.printf("| %-3d | %-10s | %-20s | $%.2f | %-8d |%n",
                        count, device.getCategory(), device.getName(), device.getPrice(), device.getQuantity());
                totalInventoryValue += device.getPrice() * device.getQuantity();
                count++;
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("Summary:");
        System.out.println("- Total Number of Devices: " + (count - 1));
        System.out.println("- Total Inventory Value: $" + totalInventoryValue);
        System.out.println("End of Report");
    }
      /**
     * Restocks or reduces the stock of a device.
     * @param name The name of the device.
     * @param quantity The quantity to restock or reduce.
     * @param addStock True if restocking, false if reducing.
     * Time Complexity: O(n*m)
     * @implNote This method searches for the device by name, and the time complexity depends on the number of categories and devices per category.
     */
    public void restockDevice(String name, int quantity, boolean addStock) {
        boolean found = false;
        for (ArrayList<Device> list : inventoryList) {
            for (Device device : list) {
                if (device.getName().equalsIgnoreCase(name)) {
                    found = true;
                    int currentQuantity = device.getQuantity();
                    if (addStock) {
                        currentQuantity += quantity;
                        System.out.println(name + " restocked. New quantity: " + currentQuantity);
                    } else {
                        if (currentQuantity >= quantity) {
                            currentQuantity -= quantity;
                            System.out.println(name + " stock reduced. New quantity: " + currentQuantity);
                        } else {
                            System.out.println("Insufficient stock to remove.");
                        }
                    }
                    device.setQuantity(currentQuantity);
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        if (!found) {
            System.out.println("Device not found in inventory.");
        }
    }
      /**
     * Sorts the devices in the inventory by price and displays them.
     * Time Complexity: O(n*log(n))
     * @implNote This method uses a sorting algorithm with O(n*log(n)) time complexity.
     */
    public void sortDevicesByPrice() {
        // Create a list to hold all devices
        ArrayList<Device> allDevices = new ArrayList<>();

        // Add all devices to the list
        for (ArrayList<Device> list : inventoryList) {
            allDevices.addAll(list);
        }

        // Sort the list based on device price using Comparator
        Collections.sort(allDevices, new Comparator<Device>() {
            @Override
            public int compare(Device device1, Device device2) {
                // Compare based on price
                return Double.compare(device1.getPrice(), device2.getPrice());
            }
        });

        // Display the sorted list
        System.out.println("Devices sorted by price:");
        int count = 1;
        for (Device device : allDevices) {
            System.out.println(count + ". Category: " + device.getCategory() + ", Name: " + device.getName() +
                    ", Price: $" + device.getPrice() + ", Quantity: " + device.getQuantity());
            count++;
        }
    }
    /**
 * Adds a device to the inventory.
 * Time Complexity: O(n)
 * If the category of the device already exists in the inventory, the device is added to that category list.
 * If the category does not exist, a new category list is created and the device is added to it.
 * @param device The device to be added to the inventory
 */
public void addDevice(Device device) {
    ArrayList<Device> categoryList = null;
    boolean deviceExists = false;

    // Check if the category already exists in the inventory
    for (ArrayList<Device> list : inventoryList) {
        if (list.get(0).getCategory().equalsIgnoreCase(device.getCategory())) {
            categoryList = list;
            break;
        }
    }

    // If the category doesn't exist, create a new category list
    if (categoryList == null) {
        categoryList = new ArrayList<>();
        inventoryList.add(categoryList);
    } else {
        // Check if the device with the same name already exists in the category
        for (Device existingDevice : categoryList) {
            if (existingDevice.getName().equalsIgnoreCase(device.getName())) {
                // Device with the same name already exists
                deviceExists = true;
                break;
            }
        }
    }

    if (deviceExists) {
        // Print a message indicating that the device with the same name already exists
        System.out.println("A device with the same name already exists in the category");
    } else {
        // Add the device to the category list
        if (categoryList.add(device)) {
            // Print the details of the added device
            System.out.print("Device added to inventory:");
            System.out.print("Category: " + device.getCategory());
            System.out.print("  Name: " + device.getName());
            System.out.print("  Price: $" + device.getPrice());
            System.out.println("  Quantity: " + device.getQuantity());
        } else {
            // Print a message indicating that the device couldn't be added
            System.out.println("Unable to add device to inventory.");
        }
    }
}


    /**
     * Removes a device from the inventory.
     * @param name The name of the device to remove.
     * Time Complexity: O(n*m)
     * @implNote This method searches for the device by name and removes it if found.
     */
    public void removeDevice(String name) {
        for (ArrayList<Device> list : inventoryList) {
            for (Device device : list) {
                if (device.getName().equalsIgnoreCase(name)) {
                    list.remove(device);
                    return;
                }
            }
        }
        System.out.println("Device not found in inventory.");
    }

     /**
     * Updates the details of a device in the inventory.
     * @param name The name of the device to update.
     * @param price The new price of the device.
     * @param quantity The new quantity of the device.
     * Time Complexity: O(n*m)
     * @implNote This method searches for the device by name and updates its details if found.
     */
    public void updateDevice(String name, double price, int quantity) {
        for (ArrayList<Device> list : inventoryList) {
            for (Device device : list) {
                if (device.getName().equalsIgnoreCase(name)) {
                    device.setPrice(price);
                    device.setQuantity(quantity);
                    System.out.println(name + " details updated: Price - " + price + ", Quantity - " + quantity);
                    return;
                }
            }
        }
        System.out.println("Device not found in inventory.");
    }

    /**
     * Displays a list of all devices in the inventory.
     * Time Complexity: O(n*m)
     * @implNote This method iterates over each device in the inventory to display its details.
     */
    public void displayDevices() {
        System.out.println("Device List:");
        int count = 1;
        for (ArrayList<Device> list : inventoryList) {
            for (Device device : list) {
                System.out.println(count + ". Category: " + device.getCategory() + ", Name: " + device.getName() +
                        ", Price: $" + device.getPrice() + ", Quantity: " + device.getQuantity());
                count++;
            }
        }
    }

     /**
     * Finds the device with the minimum price in the inventory and displays its details.
     * Time Complexity: O(n*m)
     * @implNote This method iterates over each device in the inventory to find the minimum price.
     */
    public void findCheapestDevice() {
        double minPrice = Double.MAX_VALUE;
        Device cheapestDevice = null;
        if(inventoryList.isEmpty()){
            return;
        }
        for (ArrayList<Device> list : inventoryList) {
            for (Device device : list) {
                if (device.getPrice() < minPrice) {
                    minPrice = device.getPrice();
                    cheapestDevice = device;
                }
            }
        }
        if(cheapestDevice==null){
            System.out.println("no cheapest device");
            return;
        }

        System.out.println("The cheapest device is:");
        System.out.println("Category: " + cheapestDevice.getCategory() +
                ", Name: " + cheapestDevice.getName() +
                ", Price: $" + cheapestDevice.getPrice() +
                ", Quantity: " + cheapestDevice.getQuantity());
    }
     /**
     * Returns the list containing inventory items.
     * @return The list of inventory items.
     */
    public LinkedList<ArrayList<Device>> getInventoryList() {
        return inventoryList;
    }
    
}