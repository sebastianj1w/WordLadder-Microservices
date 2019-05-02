package sebastianj1w.login_microservice.entity;


import sebastianj1w.login_microservice.Util.MD5;

public class User {
    private String id;
    private String passwordMD5;

    public User(String id, String pwd) {
        this.id = id;
        MD5 encode = new MD5();
        this.passwordMD5 = encode.md5(pwd);
    }

    public int checkPwd(String pwd) {
        MD5 encode = new MD5();
        String encodedPwd = encode.md5(pwd);
        if (encodedPwd.equals(passwordMD5))
            return 1;
        else
            return 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
