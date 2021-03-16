package gov.iti.jets.team5.models.dto;

public class UserAuthDto {
    private String userName;
    private String password;

    public UserAuthDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserAuthDto() {
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
}
