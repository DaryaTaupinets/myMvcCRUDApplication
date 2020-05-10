package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUser", userService.getAllUsers());
        return "admin-page";
    }

    @PostMapping("/admin/create")
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getId() != null) {
            userService.addUser(user);
        } else {
            userService.updateUser(user);
        }
        return "redirect: /admin-page";
    }

    @RequestMapping("/admin/delete")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect: /admin-page";
    }

    @RequestMapping("/admin/update")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("listUser", userService.getAllUsers());
        return "admin-page";
    }
}
