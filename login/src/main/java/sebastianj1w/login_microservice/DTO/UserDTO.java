package sebastianj1w.login_microservice.DTO;

public class UserDTO {
    private String id;
    private String passwordMD5;

    public UserDTO() {}

    public String getPwd() {
        return passwordMD5;
    }

    public String getPasswordMD5() {
        return passwordMD5;
    }

    public void setPasswordMD5(String passwordMD5) {
        this.passwordMD5 = passwordMD5;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
