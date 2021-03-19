package gov.iti.jets.team5.models.dto;

public class UserDto {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public UserDto(String firstName, String lastName, String email, String phone, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
    public UserDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserDto() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString(){
        return ("FirstName: " + firstName + ", LastName: " + lastName + ", Email: " + email + ", phone: " + phone + ", password" + password);
    }
}
