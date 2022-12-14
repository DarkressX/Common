package org.common.common.controller;



import org.common.common.model.ApplicationUser;
import org.common.common.model.Role;
import org.common.common.model.UserActivation;
import org.common.common.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Controller
public class AuthController {

    @Value("${emailpw}")
    private String sender;

    UserServiceImpl service;

    PasswordEncoder pwendcoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();


    @Autowired
    public JavaMailSender jmsender;

    public void sendEmail(String receiver, Long id) throws AddressException, MessagingException, IOException {
        UUID uuid = UUID.randomUUID();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, 5);
        Date expdate = cal.getTime();

        service.saveActivationUser(new UserActivation(uuid, expdate, id));
        String confLink = "localhost:8080/register/confirm/"+uuid;

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(receiver);

        msg.setSubject("Confirmation - Registration");
        msg.setText("Hello User, \nPlease verify your e-mail by clicking this link:\n" + confLink);

        jmsender.send(msg);
    }

    public AuthController(UserServiceImpl service){
        this.service = service;
    }

    @PostConstruct
    private void createUser() {
        String password = pwendcoder.encode("pw");
        //ApplicationUser newUser = new ApplicationUser("admin", "test.email@example.com", password, ApplicationUser.Role.ADMIN);
        //this.service.saveUser(newUser);
        String password2 = pwendcoder.encode("as");
       // ApplicationUser newUser2 = new ApplicationUser("user", "test2.email@example.com", password2, ApplicationUser.Role.DEACTIVATED);
        //this.service.saveUser(newUser2);
    }

    @GetMapping(path = "/register/view")
    public String view(Model model){
        model.addAttribute("user", new ApplicationUser());
        return "register";
    }

    @PostMapping( path = "/register/post")
    public String post(@Valid @ModelAttribute("user") ApplicationUser user, BindingResult bindingResult, Model model) throws IOException, MessagingException {
        if( bindingResult.hasErrors() ) {
            System.out.println(bindingResult);
            return "register";
        } else {
            user.setPassword(pwendcoder.encode(user.getPassword()));
            Collection<Role> roles = null;
            roles.add(new Role(0l, "Deactivated", Role.Type.DEACTIVATED));
            user.setRoles(roles);
            service.saveUser(user);
            sendEmail(user.getEmail(), user.getId());

            //model.addAttribute("user", user);

            return "confirmation";
        }
    }

    @GetMapping(path = "/register/confirm/{id}")
    public String confirm(@PathVariable("id") UUID id, Model model){
        if(service.getUserActivationByUuid(id) != null){
            ApplicationUser user = service.getUserById(service.getUserActivationByUuid(id).getUserId());
            service.confirm(id);

            return "confirm";
        }
        return "confirm_error";
    }

}
