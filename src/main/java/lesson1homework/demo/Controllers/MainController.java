package lesson1homework.demo.Controllers;


import lesson1homework.demo.Models.User;
import lesson1homework.demo.Services.EmailService;
import lesson1homework.demo.dbServices.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor/*замінили автовайред*/
public class MainController {

    private UserService userService;
//    private Object User;


    @GetMapping("/")
    public void home(){
        System.out.println("you are at home");
    }


    @GetMapping("/save")
    public void save(  User user
    ){
        userService.save(user);
        System.out.println(user);
    }

    @GetMapping("/user/{xxx}")
    public User getUser(@PathVariable int xxx){
        User usr =userService.findById(xxx).get();
        return usr;
    }

    @GetMapping("/users")
    public List<User> allUsers(){
        List<User> all=userService.findAll();
        return all;
    }

    @GetMapping ("/remove/{yyy}")
    public void remove(@PathVariable int yyy){
        User usr = userService.findById(yyy).get();
        userService.delete(usr);
        System.out.println("User :"+yyy +" succesfully deleted");

    }

    EmailService emailService;

    @GetMapping("/send")
    public String send(@RequestParam String email){
        emailService.SendEmail(email);
        return "email sent";
    }
}





