package com.example.demo.user;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;

//    PasswordEncoder passwordEncoder; // 비밀번호 암호화

    public User join(User user) {
        return userRepository.save(user);
    }

    public String login(LoginDto loginDto) {
        User resultUser = userRepository.findByEmail(loginDto.getEmail());

        if (resultUser == null)
            return "존재하지 않은 유저입니다.";

        if (isSamePassword(loginDto, resultUser))
            return "로그인 성공!";
        else
            return "비밀번호가 일치하지 않습니다.";
    }

    private static boolean isSamePassword(LoginDto loginDto, User resultUser) {
        return loginDto.getPassword().equals(resultUser.getPassword());
    }
}
