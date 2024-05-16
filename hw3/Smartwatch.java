/**
 * Represents a smartwatch device.
 */
public class Smartwatch implements Device {
    private String category;
    private String name;
    private double price;
    private int quantity;

    /**
     * Constructs a smartwatch with the specified category, name, price, and quantity.
     * Time complexity is o(1)
     * @param category The category of the smartwatch.
     * @param name The name of the smartwatch.
     * @param price The price of the smartwatch.
     * @param quantity The quantity of the smartwatch.
     */
    public Smartwatch(String category, String name, double price, int quantity) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Implementing interface methods

    /**
     * Retrieves the category of the smartwatch.
     * Time complexity is o(1)
     * @return The category of the smartwatch.
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Retrieves the name of the smartwatch.
     * Time complexity is o(1)
     * @return The name of the smartwatch.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Retrieves the price of the smartwatch.
     * Time complexity is o(1)
     * @return The price of the smartwatch.
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Retrieves the quantity of the smartwatch.
     * Time complexity is o(1)
     * @return The quantity of the smartwatch.
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the smartwatch.
     * Time complexity is o(1)
     * @param quantity The new quantity of the smartwatch.
     */
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets the name of the smartwatch.
     * Time complexity is o(1)
     * @param name The new name of the smartwatch.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the price of the smartwatch.
     * Time complexity is o(1)
     * @param price The new price of the smartwatch.
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the category of the smartwatch.
     * Time complexity is o(1)
     * @param category The new category of the smartwatch.
     */
    @Override
    public void setCatagory(String category) {
        this.category = category;
    }
}
