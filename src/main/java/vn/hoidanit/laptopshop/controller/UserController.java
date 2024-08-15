package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.handHello();
        model.addAttribute("eric", test);
        model.addAttribute("ngo", "I'm Ngo");
        return "hello";
    }
}

// @RestController
// public class UserController {

// @GetMapping("")
// public String getHomePage() {
// return this.userService.handHello();
// }
// }