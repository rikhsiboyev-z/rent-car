package com.example.rentcar.springConfig;


import com.example.rentcar.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") String name,
                           @RequestParam("password") String password) {
        userService.register(name, password);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String name,
                        @RequestParam("password") String password) {
        return "redirect:/car-ranger";
    }

}
