package com.example.demo.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    UserService userService;

    @PostMapping("/join")
    public User join(@RequestBody User user) {
        return userService.join(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        if (loginDto.getEmail() == null)
            return "이메일을 입력해주세요.";

        return userService.login(loginDto);
    }
}
