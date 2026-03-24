package com.codewithmosh.store.auth;

import com.codewithmosh.store.users.User;
import com.codewithmosh.store.users.UserDto;
import com.codewithmosh.store.users.UserMapper;
import com.codewithmosh.store.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User getCurrentUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findById((Long) authentication.getPrincipal()).orElse(null);
    }

    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();

        var refreshToken = jwtService.generateRefreshToken(user);
        var accessToken = jwtService.generateAccessToken(user);

        return new LoginResponse(accessToken, refreshToken);
    }

    public String refresh(String refreshToken) {
        var jwt = jwtService.parseToken(refreshToken);
        if (jwt == null || jwt.isExpired()) {
            throw new InvalidTokenException();
        };

        var user = userRepository.findById(jwt.getUserId()).orElseThrow(UserNotFoundException::new);

        return jwtService.generateAccessToken(user).toString();
    }

    public UserDto me() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var user = userRepository.findById((Long) authentication.getPrincipal()).orElseThrow(UserNotFoundException::new);

        return userMapper.toDto(user);
    }
}
