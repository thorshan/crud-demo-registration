package com.project.crud.controller;


import com.project.crud.entity.User;
import com.project.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("user", userService.getAllUsers());
        model.addAttribute("userCount", userService.userCount());
        return "index";
    }

    @GetMapping("/index")
    public String homePage(Model model){
        model.addAttribute("user", userService.getAllUsers());
        model.addAttribute("userCount", userService.userCount());
        return "index";
    }

    @GetMapping("/add")
    public String addPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "add";
    }

    @PostMapping("/add")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/index";
    }

    @GetMapping("/user/edit/{id}")
    public String viewUser(@PathVariable("id") Integer id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PostMapping("/user/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, @ModelAttribute("user") User user){
        User exitedUser = userService.getUserById(id);
        exitedUser.setId(user.getId());
        exitedUser.setName(user.getName());
        exitedUser.setEmail(user.getEmail());
        exitedUser.setPhone(user.getPhone());
        exitedUser.setGender(user.getGender());
        exitedUser.setCity(user.getCity());

        userService.updateUser(exitedUser);
        return "redirect:/index";
    }

    @GetMapping("/index/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return "redirect:/index";
    }

}
