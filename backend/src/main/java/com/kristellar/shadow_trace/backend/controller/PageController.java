package com.kristellar.shadow_trace.backend.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.kristellar.shadow_trace.backend.entities.User;
import com.kristellar.shadow_trace.backend.forms.UserForm;
import com.kristellar.shadow_trace.backend.helpers.Helper;
import com.kristellar.shadow_trace.backend.services.UserService;
import jakarta.servlet.http.HttpSession;
@Controller
public class PageController {
    @Autowired
    private UserService userService;

    private org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PageController.class);

    // handling register
    @GetMapping("/register")
    public String register(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "register";
    }

    // processing register
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm){
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setAddress(userForm.getAddress());
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        String name = Helper.getEmailOfLoggedInUser(principal);
        User user = userService.getUserByEmail(name);
        model.addAttribute("loggedInUser", user);
        return "dashboard";
    }

    @GetMapping("/call_logs")
    public String callLogs() {
        return "call_logs";
    }

    @GetMapping("/fb")
    public String fb() {
        return "fb";
    }

    @GetMapping("/insta")
    public String insta() {
        return "insta";
    }

    @GetMapping("/otp")
    public String otp() {
        return "otp";
    }

    @GetMapping("/photos")
    public String photos() {
        return "photos";
    }

    @GetMapping("/recording")
    public String recording() {
        return "recording";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @GetMapping("/snap")
    public String snap() {
        return "snap";
    }

    @GetMapping("/tele")
    public String tele() {
        return "tele";
    }

    @GetMapping("/whatsapp")
    public String whatsapp() {
        return "whatsapp";
    }

    @GetMapping("/x")
    public String x() {
        return "x";
    }
}
