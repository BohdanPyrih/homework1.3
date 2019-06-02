package lesson1homework.demo.dbServices;

import lesson1homework.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


    @Service
    public interface UserService extends JpaRepository<User,Integer> {
    }

