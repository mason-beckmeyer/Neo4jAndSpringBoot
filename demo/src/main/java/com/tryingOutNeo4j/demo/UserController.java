package com.tryingOutNeo4j.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
@RequestMapping("/users")
public class UserController{
    private final UserRepo userRepo;

    public UserController(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    @GetMapping
//    @ResponseBody
    public String findAll(Model model){

        Iterable<User> users = userRepo.findAll();

        model.addAttribute("users",users);

        return "userList.html";

    }

    @GetMapping("/{lastName}")
    @ResponseBody
    public Iterable<User> getUserByLastName(@PathVariable String lastName){
        return userRepo.getUserByLastName(lastName);
    }

    @GetMapping("/createUser")
    public String createUser(){
        return "createUser.html";
    }

    @PostMapping("/createUser")
    public String handleUserCreation(
            @RequestParam String fname,
            @RequestParam String lname
    ){
        User newUser = new User();
        newUser.setFirstName(fname);
        newUser.setLastName(lname);

        userRepo.save(newUser);
        return "redirect:/users";
    }



}
