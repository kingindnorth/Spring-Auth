package com.smart.smartcontact.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.smartcontact.dao.UserRepo;
import com.smart.smartcontact.entites.User;
import com.smart.smartcontact.helper.Message;


@Controller
public class HomeController {
    @Autowired
	private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private UserRepo userRepo;

    // private User user;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Home---Smart Contact Manger");
        return "home";
    }
    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "About---Smart Contact Manger");
        return "about";
    }
    @RequestMapping("/signup")
    public String signup(Model model){
        model.addAttribute("title", "signup---Smart Contact Manger");
        model.addAttribute("user", new User());
        // System.out.println(user);
        return "signup";
    }
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("title", "login---Smart Contact Manger");
        return "login";
    }
    // @RequestMapping(value = "/registerd", method = HttpMethod.POST )
    // public String registered(@ModelAttribute("user") User user Model model){
    //     model.addAttribute("title", "login---Smart Contact Manger");
    //     return "login";
    // }
    @PostMapping("/registerd")
    public String registerUser(@Valid @ModelAttribute("user") User user, Errors errors,
    @RequestParam(value="confirmPassword") String confirmPassword, 
    Model model, 
    HttpSession session){
        try{
            
            String password = user.getPassword();
            // String result = password.getClass().getName();
            // String result2 = confirmPassword.getClass().getName();
            // System.out.println("confirmpassword"+((Object)confirmPassword).getClass().getName()+"password"+((Object)password).getClass().getName());
            // System.out.println(password.equals(confirmPassword)); 
            System.out.println(errors.hasErrors());
            if(errors.hasErrors()){
                System.out.println("error-------------------------------"+ errors.toString());
                return "signup";
            }

            if(!password.equals(confirmPassword)){
                throw new Exception("Password does not match");
            }
            String encoded = passwordEncoder.encode(user.getPassword());
            user.setRole("USER");

            user.setPassword(encoded);
            System.out.println(user);

            this.userRepo.save(user); //connecting to db
            session.setAttribute("message", new Message("you are now registerd!","alert-success"));
            return "login";
        }catch(Exception e){
            e.printStackTrace();
            session.setAttribute("message", 
            new Message("something went wrong " + e.getMessage(),"alert-danger"));
            return "signup";
        } 

    }
    
//@RequestParam(value = "agreement", defaultValue = "false") boolean agreement
//session.setAttribute("message", new Message("Something Went wrong !! " + e.getMessage(), "alert-danger"));
// if (result1.hasErrors()) {
//     System.out.println("ERROR " + result1.toString());
//     model.addAttribute("user", user);
//     return "signup";
// }
}
