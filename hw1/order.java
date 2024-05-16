public class order  {
    private String product_name;
    private int count;
    private int total_price;
    private int status;
    private int customerID;

    public order( String product_name, int count, int total_price, int status, int customerID) {
        this.product_name = product_name;
        this.count = count;
        this.total_price = total_price;
        this.status = status;
        this.customerID = customerID;
    }
    public order(){
        
    }
    public void print_order(){
        System.out.print("product name:" + product_name+ 
        " count:" + count 
        + " total price:" + total_price +
        " status:" + getStatusString(status) +" \n" );
    }
    public String getStatusString(int status) {
        switch (status) {
            case 0:
                return "Initialized";
            case 1:
                return "Processing";
            case 2:
                return "Completed";
            case 3:
                return "Cancelled";
            default:
                return "Error";
        }
    }

    public String getProductName() {
        return product_name;
    }

    public void setProductName(String product_name) {
        this.product_name = product_name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPrice() {
        return total_price;
    }

    public void setTotalPrice(int total_price) {
        this.total_price = total_price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public int getTotal_price() {
        return total_price;
    }
    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }
}
