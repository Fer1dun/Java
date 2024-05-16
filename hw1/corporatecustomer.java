public class corporatecustomer extends customer {
    private String company_name;

    protected void printCompanyInfo() {
        // Print the company name for corporate customers
        System.out.println("Company Name: " + company_name);
    }
    
    public corporatecustomer(String name, String surname, String address, String phone, int ID, int customerID,String company_name,String customer_type){
        super(name,surname,address,phone,ID,customerID,customer_type);
        this.company_name=company_name;
    }

    public String getCompanyName() {
        return company_name;
    }

    public void setCompanyName(String company_name) {
        this.company_name = company_name;
    }

    
}
