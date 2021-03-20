package gov.iti.jets.team5.models.dto;

public class UserAuthDto {
    private String email;
    private String password;
    private int id;

    public UserAuthDto(String email, String password, int id) {
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public UserAuthDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
