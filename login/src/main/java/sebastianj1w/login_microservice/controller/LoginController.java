package sebastianj1w.login_microservice.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.*;
import sebastianj1w.login_microservice.DTO.UserDTO;
import sebastianj1w.login_microservice.Util.MD5;
import sebastianj1w.login_microservice.service.UserService;

import javax.servlet.ServletException;
import java.util.Date;

@RestController
public class LoginController {

//    @Autowired
    private UserService userService = new UserService();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody UserDTO userDTO) throws ServletException {
//        MD5 encoder = new MD5();
//        System.out.println(userDTO.getId());
//        System.out.println(userDTO.getPwd());
        if (!(userService.checkPwd(userDTO.getId(), userDTO.getPwd()) == 1)) {
            throw new ServletException("Please fill in username and password");
        }
        // Create Twt token
        String jwtToken = Jwts.builder().setSubject(userDTO.getId()).claim("roles", "member").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        return jwtToken;
    }

    @RequestMapping(value = "/secure")
    public String get_try() {
        return "13";
    }
}