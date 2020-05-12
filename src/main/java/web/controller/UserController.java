package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "admin")
    public String listUsers(Model model) {
        model.addAttribute("listUser", userService.getAllUsers());
        return "admin-page";
    }

    @GetMapping(value = "admin/create")
    public String formAddUser(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }


    @PostMapping(value = "admin/create")
    public String addUser(@ModelAttribute("user") User user) {
            userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/delete")
    public String deleteUser(@RequestParam("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/update")
    public String editUser(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user-form";
    }
}
