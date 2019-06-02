package lesson1homework.demo.Services;

import lesson1homework.demo.Models.User;
import lesson1homework.demo.dbServices.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
@AllArgsConstructor
@PropertySource("classpath:application.properties")
public class EmailService {

    private Environment environment;

    private JavaMailSender javaMailSender;

    private UserService userService;

//    List<User> all= userService.findAll();
//    String newAll =all.toString();

    public void SendEmail(String email){
        MimeMessage mimeMessage =javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;

        helper = new MimeMessageHelper(mimeMessage);

        try {
            mimeMessage.setFrom(environment.getProperty("spring.mail.username"));
            helper.setTo(email);
//            helper.setText();

        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }

}
