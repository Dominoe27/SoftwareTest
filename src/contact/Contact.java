package contact;


  //The Contact class is individual contact entry.
 
public class Contact {
   
    private final String contactId;
    
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    
     //Constructor creates a contact with all required fields.
     
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) 
            throw new IllegalArgumentException("Invalid contact ID");
        if (firstName == null || firstName.length() > 10) 
            throw new IllegalArgumentException("Invalid first name");
        if (lastName == null || lastName.length() > 10) 
            throw new IllegalArgumentException("Invalid last name");
        if (phone == null || phone.length() != 10) 
            throw new IllegalArgumentException("Invalid phone number");
        if (address == null || address.length() > 30) 
            throw new IllegalArgumentException("Invalid address");

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getter for contact ID
    public String getContactId() {
        return contactId;
    }

    // Getter and setter for first name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) 
            throw new IllegalArgumentException("Invalid first name");
        this.firstName = firstName;
    }

    // Getter and setter for last name
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) 
            throw new IllegalArgumentException("Invalid last name");
        this.lastName = lastName;
    }

    // Getter and setter for phone number
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) 
            throw new IllegalArgumentException("Invalid phone number");
        this.phone = phone;
    }

    // Getter and setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) 
            throw new IllegalArgumentException("Invalid address");
        this.address = address;
    }
}
