package controller;

import model.Login;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

@Controller
@RequestMapping("/login")
public class UserController {
    private UserService userService = new UserService();

    @GetMapping("")
    public ModelAndView showLogin() {
        return new ModelAndView("home", "login", new Login());
    }

    @PostMapping("")
    public ModelAndView login(@ModelAttribute("login") Login login) {
        User user = userService.checkLogin(login);
        if (user == null) {
            return new ModelAndView("error");
        } else {
            ModelAndView modelAndView = new ModelAndView("user");
            modelAndView.addObject("user", user);
            return modelAndView;
        }

    }

}
