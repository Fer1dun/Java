
/**
 * The Device interface represents a generic electronic device.
 * Implementing classes should provide implementations for the methods defined in this interface.
 */
public interface Device {  
        String getCategory();
        String getName();
        double getPrice();
        int getQuantity();
        void setName(String name);
        void setPrice(double price);
        void setQuantity(int quantity);
        void setCatagory(String catagory);
}
