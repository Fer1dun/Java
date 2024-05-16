import java.io.File;
import java.util.Scanner;
import java.util.ArrayList

public class Filereader{
    public static void main(String[] args) {
        operator[] all_operator=new operator[100];
        customer[] all_customer = new customer[100];
        order[] all_order = new order[100];
        int total_order=0;
        int total_customer=0;
        int total_operator=0; 
        try {
            //read from file
            File file = new File("content.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                if(parts.length==0){
                    continue;
                }
                if (isValidLine(parts)) {
                    switch (parts[0]) {
                        case "order":
                            if (parts.length == 6) { //Checks if there are 6 elements
                                    String product_name = parts[1];
                                    int count;
                                    int total_price;
                                    int status;
                                    int customer_id;
                                    //checks max integer and valid input
                                    try {
                                        count = Integer.parseInt(parts[2]);
                                        total_price = Integer.parseInt(parts[3]);
                                        status = Integer.parseInt(parts[4]);
                                        customer_id = Integer.parseInt(parts[5]);
                                    } catch (Exception e) {
                                        System.out.println("Invalid numeric format in order: " + line);
                                        continue; 
                                    }//It checks the integer values, creates a class if appropriate, and assigns it to the class array.
                                    if( count>0 && total_price >0 && customer_id >=0  && status<4 && status>=0){
                                    order orders = new order(product_name, count, total_price, status, customer_id);
                                    all_order[total_order++] = orders;
                                    }
                            } else {
                                System.out.println("Invalid order record: " + line);
                            }
                            break;
                        case "retail_customer":
                            if (parts.length == 7) {   //Checks if there are 7 elements                       
                                   String name = parts[1];
                                    String surname = parts[2];
                                    String address = parts[3];
                                    String phone = parts[4];
                                    int ID;
                                    int operator_ID;
                                    //checks max integer and valid input
                                    try {
                                        ID = Integer.parseInt(parts[5]);
                                        operator_ID = Integer.parseInt(parts[6]);
                                    } catch (Exception e) {
                                        System.out.println("Invalid numeric format in retail_customer: " + line);
                                        continue; 
                                    }
                                    if( ID>0 && operator_ID > 0){//It checks the integer values, creates a class if appropriate, and assigns it to the class array.
                                        if(check_id(ID, all_operator, all_customer, total_customer, total_operator)==true){
                                        retailcustomer retailcustomers = new retailcustomer(name, surname, address, phone, ID, operator_ID,parts[0]);
                                        all_customer[total_customer++] = retailcustomers;
                                        }
                                    }
                    
                            } else {
                                System.out.println("Invalid retail_customer record: " + line);
                            }
                            break;
                        case "corporate_customer":
                            if (parts.length == 8) {                            
                                    String name = parts[1];
                                    String surname = parts[2];
                                    String address = parts[3];
                                    String phone = parts[4];
                                    String company_name = parts[7];
                                    int ID;
                                    int operator_ID;
                                    //checks max integer and valid input
                                    try {
                                        ID = Integer.parseInt(parts[5]);
                                        operator_ID = Integer.parseInt(parts[6]);
                                    } catch (Exception e) {
                                        System.out.println("Invalid numeric format in corporate_customer: " + line);
                                        continue; 
                                    }
                                    //It checks the integer values, creates a class if appropriate, and assigns it to the class array.
                                    if( ID>0 && operator_ID > 0){
                                        if(check_id(ID, all_operator, all_customer, total_customer, total_operator)==true){
                                    corporatecustomer corporate = new corporatecustomer(name, surname, address, phone, ID, operator_ID, company_name,parts[0]);
                                    all_customer[total_customer++] = corporate;
                                        }
                                    }
                               
                            } else {
                                System.out.println("Invalid corporate_customer record: " + line);
                            }
                            break;
                        case "operator":
                            if (parts.length == 7) {
                                    String name = parts[1];
                                    String surname = parts[2];
                                    String address = parts[3];
                                    String phone = parts[4];
                                    int ID;
                                    int wage;
                                    //checks max integer and valid input
                                    try {
                                        ID = Integer.parseInt(parts[5]);
                                        wage = Integer.parseInt(parts[6]);
                                    } catch (Exception e) {
                                        System.out.println("Invalid numeric format in operator: " + line);
                                        continue; 
                                    }
                                    //It checks the integer values, creates a class if appropriate, and assigns it to the class array.
                                    if(ID>0 && wage >0){
                                        if(check_id(ID, all_operator, all_customer, total_customer, total_operator)==true){
                                    operator operators = new operator(name, surname, address, phone, ID, wage);
                                    all_operator[total_operator++] = operators;
                                        }
                                    }
                              
                            } else {
                                System.out.println("Invalid operator record: " + line);
                            }
                            break;
                        default:
                            System.out.println("Invalid data type: " + parts[0]);
                    }
                } else {
                    System.out.println("Invalid line: " + line);
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("File not found.");
            return;
        }
        //It takes every order and every customer, and if the ID are not synchronized, it throws it to the function.
        for (order currentOrder : all_order) {
            for (customer currentCustomer : all_customer) {
                if ( currentCustomer!=null && currentOrder!=null && currentCustomer.getID() == currentOrder.getCustomerID()) {
                    currentCustomer.defineOrders(all_order);
                    break;
                }
            }
        }

        //It takes every operator and every customer, and if the ids are not synchronized, it throws it to the function.
        for (customer currentCustomer : all_customer) {
            for (operator currentOperator : all_operator) {
                if (currentOperator!=null && currentCustomer!=null && currentOperator.getID() == currentCustomer.getOperatorID()) {
                    currentOperator.define_customers(all_customer);
                    break;
                }
            }
        }
            
        Scanner scanner = new Scanner(System.in);
        int ID = -1; 

        try {
            System.out.println("Please enter your ID...");
            ID = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer ID.");
            scanner.nextLine(); 
        }

        boolean found = false;
        //prints appropriate operators or customers according to the entered ID
        if (ID != -1) { // Check if a valid integer ID was entered
            for (int i = 0; i < total_operator; i++) {
                if (all_operator[i].getID() == ID) {
                    all_operator[i].print_operator();
                    found = true;
                    break;
                }
            }
            if (!found) {
                for (int i = 0; i < total_customer; i++) {
                    if (all_customer[i].getID() == ID) {
                        all_customer[i].print_customer();
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("No operator/customer was found with ID " + ID + ". Please try again.");
            }
        }

            scanner.close(); 

}           
            //checks parts is emty
            private static boolean isValidLine(String[] parts) {
                for (String part : parts) {
                    if (part.isEmpty()) {
                        return false; // Check if all strings have at least 1 character
                    }
                }
                return true;
            }
            //checks same ID
            private static boolean check_id(int id,operator[] operators,customer[] customers,int total_customer,int total_operator){
                for(int i=0;i<total_customer;i++){
                    if(customers[i].getID()==id){
                        return false;
                    }
                }
                for(int i=0;i<total_operator;i++){
                    if(operators[i].getID()==id){
                        return false;
                    }
                }
                return true;
            }
}