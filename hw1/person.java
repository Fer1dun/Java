public class person {
    private String name;
    private String surname;
    private String address;
    private String phone;
    private int ID;
    
    public person(String name, String surname, String address, String phone, int ID) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.ID = ID;
    }
    public person(){
        
    }
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
