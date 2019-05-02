package sebastianj1w.login_microservice.service;

import org.springframework.context.annotation.Bean;
import sebastianj1w.login_microservice.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users;

    public UserService() {
        users = new ArrayList<>();
        //For test
        User temp;
        for (int i = 0; i < 10; i++) {
            temp = new User(String.valueOf(i)+String.valueOf(i),String.valueOf(i)+"password");
            users.add(temp);
        }
    }

    public int checkPwd(String id, String pwd) {
        User usr = getUserById(id);
        if (usr == null) return 0;
        if (usr.checkPwd(pwd) == 1) return 1;
        else return 0;
    }

    public User getUserById(String id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                return users.get(i);
            }
        }
        return null;
    }

    public int setUser(String id, String encodedPwd) {
        User temp = new User(id, encodedPwd);
        users.add(temp);
        return 1;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
