/**
 * The Headphones class represents a specific type of electronic device: headphones.
 * It implements the Device interface to provide functionality for managing headphone objects.
 */
public class Headphones implements Device {
    private String category;
    private String name;
    private double price;
    private int quantity;

    
    /**
     * Constructs a new Headphones object with the specified category, name, price, and quantity.
     * @param category The category of the headphones.
     * @param name The name of the headphones.
     * @param price The price of the headphones.
     * @param quantity The quantity of the headphones.
     */
    public Headphones(String category, String name, double price, int quantity) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Retrieves the category of the headphones.
     * @return The category of the headphones.
     * Time complexity is o(1)
     */
    @Override
    public String getCategory() {
        return category;
    }
    /**
     * Retrieves the name of the headphones.
     * @return The name of the headphones.
     * Time complexity is o(1)
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * Retrieves the price of the headphones.
     * Time complexity is o(1)
     * @return The price of the headphones.
     */
    @Override
    public double getPrice() {
        return price;
    }
    /**
     * Retrieves the quantity of the headphones.
     * Time complexity is o(1)
     * @return The quantity of the headphones.
     */
    @Override
    public int getQuantity() {
        return quantity;
    }
     /**
     * Sets the quantity of the headphones.
     * Time complexity is o(1)
     * @param quantity The new quantity of the headphones.
     */
    @Override
    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }
     /**
     * Sets the name of the headphones.
     * Time complexity is o(1)
     * @param name The new name of the headphones.
     */
    @Override
    public void setName(String name) {
        this.name=name;
    }
    /**
     * Sets the price of the headphones.
     * Time complexity is o(1)
     * @param price The new price of the headphones.
     */
    @Override
    public void setPrice(double price) {
        this.price=price;
    }
    /**
     * Sets the category of the headphones.
     * Time complexity is o(1)
     * @param category The new category of the headphones.
     */
    @Override
    public void setCatagory(String category) {
        this.category=category;
    }
}
