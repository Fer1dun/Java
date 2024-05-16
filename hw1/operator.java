public class operator extends person{
    private int wage;
    private customer[] customers;

    public void print_customers() {
        int cur_cus_num=1;
        //prints customer's information
        if (customers != null && customers.length > 0) {
            for (customer currentCustomer : customers ) {
                if( currentCustomer!=null){
                    System.out.println("Customer #"+ (cur_cus_num++) + " " + currentCustomer.get_type());
                System.out.println("Name: " + currentCustomer.getName() +
                        "\nSurname: " + currentCustomer.getSurname() +
                        "\nAddress: " + currentCustomer.getAddress() +
                        "\nPhone: " + currentCustomer.getPhone() +
                        "\nID: " + currentCustomer.getID() +
                        "\nOperator ID:" +currentCustomer.getOperatorID());
                     currentCustomer.printCompanyInfo();
                        currentCustomer.print_orders();
                        System.out.println("----------------------------");
            }
            }
        } else {
            System.out.println("No customers for Operator " + getID() + "\n");
        }
    }
    

    
        public void print_operator() {
            System.out.println("***  Operator Scree ***");
            System.out.println("Name: " + getName());
            System.out.println("Surname: " + getSurname());
            System.out.println("Address: " + getAddress());
            System.out.println("Phone: " + getPhone());
            System.out.println("ID: " + getID());
            System.out.println("Wage: " + wage);
            System.out.println("---------------------------------");
            print_customers();
        }
    
    
    public void define_customers( customer[] customers){
        this.customers=new customer[customers.length];
        int count=0;
        //adds customer to operator
        for(customer currentCustomer:customers ){
         if(currentCustomer !=null && currentCustomer.getOperatorID()==getID()){
             this.customers[count++]=currentCustomer;
         }
        }

    }

    public operator(String name, String surname, String address, String phone, int ID, int wage){
        super(name, surname, address, phone, ID);
        this.wage=wage;
        this.customers=new customer[100];
        
    }
    public operator(){}
    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(customer[] customers) {
        this.customers = customers;
    }


}