package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userServiceImpl")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUser", this.userService.getAllUsers());
        return "admin-page";
    }

    @PostMapping("/admin/create")
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getId() != null) {
            this.userService.addUser(user);
        }else {
            this.userService.updateUser(user);
        }
        return "redirect: /admin-page";
    }
}
