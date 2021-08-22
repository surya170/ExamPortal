package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exam.entitiy.Role;
import com.exam.entitiy.User;
import com.exam.entitiy.UserRole;
import com.exam.helper.UserFoundException;
//import com.exam.repo.QuizRepository;
import com.exam.services.UserService;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Autowired
//    public QuizRepository quizRepository;

    public static void main(String[] args) {


        SpringApplication.run(ExamserverApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        try {


            System.out.println("starting code");
//
            User user = new User();

            user.setFirstName("surya");
            user.setLastName("narayana");
            user.setUserName("surya777");
            user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
            user.setEmail("surya@gmail.com");
            user.setProfile("default.png");

            Role role1 = new Role();
            role1.setRoleId(44L);
            role1.setRoleName("ADMIN");

            Set<UserRole> userRoleSet = new HashSet<>();
            UserRole userRole = new UserRole();

            userRole.setRole(role1);

            userRole.setUser(user);

            userRoleSet.add(userRole);

            User user1 = this.userService.createUser(user, userRoleSet);
            System.out.println(user1.getUsername());


        } catch (UserFoundException e) {
            e.printStackTrace();


        }


    }


}
