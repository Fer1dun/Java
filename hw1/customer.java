
public class customer extends person {

        private int operator_ID;
        private order[] orders;
        private String customer_type;

        protected void printCompanyInfo() {
            // Default implementation for retail customers 
        }

        public void print_orders() {
            int cur_oreder_count=1;
            //prints order's information
            if (orders != null && orders.length > 0 && empty(orders)==true) {
                for (order currentOrder : orders) {
                    if (currentOrder != null) {
                        System.out.println("Order#"+ (cur_oreder_count++) + "=>" +
                                "Product name:" + currentOrder.getProduct_name() +
                                " Count: " + currentOrder.getCount() +
                                " Total price:" + currentOrder.getTotalPrice() +
                                " Status:" + currentOrder.getStatusString(currentOrder.getStatus()));
                    }
                }
            }
             else {
                System.out.println("No orders for Customer " );
            }
        } 

        public void print_customer() {
            System.out.println("*****Customers Screen******");
            System.out.println("Name: " + getName() +
            "\nSurname:" + getSurname() +
            "\nAddress: " + getAddress() +
            "\nPhone: " + getPhone() +
            "\nID: " + getID()+
            "\nOperator ID:"+getOperatorID());
            printCompanyInfo();  
            print_orders();       
        }
        public void defineOrders(order[] newOrders) {
            this.orders=new order[newOrders.length];
           int count=0;
           //adds order to customer
           for(order currentorder:newOrders ){
            if(currentorder !=null && currentorder.getCustomerID()==getID()){
                this.orders[count++]=currentorder;
            }
           }
        }
    
    
        public customer(String name, String surname, String address, String phone, int ID, int operator_ID,String customer_type) {
            super(name, surname, address, phone, ID);
            this.operator_ID = operator_ID;
            this.orders=new order[100];
            this.customer_type=customer_type;

        }
        public customer(){
            
        }
        public int getOperatorID() {
            return operator_ID;
        }
    
        public void setOperatorID(int operator_ID) {
            this.operator_ID = operator_ID;
        }
    
        public order[] getOrders() {
            return orders;
        }
    
        public void setOrders(order[] orders) {
            this.orders = orders;
        }
        public String get_type(){
            return customer_type;
        }
        public void set_type(String customer_type){
            this.customer_type=customer_type;
        }
        public static boolean empty(order[] orders){
            for(order current_order:orders){
                if(current_order!=null){
                    return true;
                }
                
            }
                return false;
            
        }
    
    
}