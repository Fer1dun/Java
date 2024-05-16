/**
 * Represents a laptop device.
 */
public class Laptop implements Device {
    private String category;
    private String name;
    private double price;
    private int quantity;

    /**
     * Constructs a laptop with the specified category, name, price, and quantity.
     * Time complexity is o(1)
     * @param category The category of the laptop.
     * @param name The name of the laptop.
     * @param price The price of the laptop.
     * @param quantity The quantity of the laptop.
     */
    public Laptop(String category, String name, double price, int quantity) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

      /**
     * Retrieves the category of the laptop.
     * Time complexity is o(1)
     * @return The category of the laptop.
     */
    @Override
    public String getCategory() {
        return category;
    }
     /**
     * Retrieves the name of the laptop.
     * Time complexity is o(1)
     * @return The name of the laptop.
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * Retrieves the price of the laptop.
     * Time complexity is o(1)
     * @return The price of the laptop.
     */
    @Override
    public double getPrice() {
        return price;
    }
     /**
     * Retrieves the quantity of the laptop.
     * Time complexity is o(1)
     * @return The quantity of the laptop.
     */
    @Override
    public int getQuantity() {
        return quantity;
    }
    /**
     * Sets the quantity of the laptop.
     * Time complexity is o(1)
     * @param quantity The new quantity of the laptop.
     */
    @Override
    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }
    /**
     * Sets the name of the laptop.
     * Time complexity is o(1)
     * @param name The new name of the laptop.
     */
    @Override
    public void setName(String name) {
        this.name=name;
    }
    /**
     * Sets the price of the laptop.
     * Time complexity is o(1)
     * @param price The new price of the laptop.
     */
    @Override
    public void setPrice(double price) {
        this.price=price;
    }
     /**
     * Sets the category of the laptop.
     * Time complexity is o(1)
     * @param category The new category of the laptop.
     */
    @Override
    public void setCatagory(String category) {
        this.category=category;
    }
    
}