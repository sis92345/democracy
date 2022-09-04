package com.democracy.web;

import com.democracy.jwt.JwtUtils;
import com.democracy.response.BasicResponse;
import com.democracy.response.TokenResponse;
import com.democracy.response.UserResponse;
import com.democracy.service.member.MemberService;
import com.democracy.service.member.dto.User;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class LoginController {


    private final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private MemberService userService;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;


    @GetMapping("/hello")
    public ResponseEntity<String> hell(){
        return ResponseEntity.ok("hello");
    };


    @PostMapping("/check")
    public ResponseEntity<?> check(@RequestBody Map<String, Object> map) {
        String accessToken = MapUtils.getString(map, "accessToken");
        String refreshToken = MapUtils.getString(map, "refreshToken");

        if (!jwtUtils.validateJwtToken(refreshToken) || !jwtUtils.checkRefreshToken(refreshToken)) {
            // refreshToken이 만료/파기면 인증실패
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
            TokenResponse tokenResponse = new TokenResponse(accessToken, refreshToken);

            if(!jwtUtils.validateJwtToken(accessToken)) {
                String userId = jwtUtils.getUserNameFromJwtToken(refreshToken);

                String newAccessToken = jwtUtils.generateAccessToken(userId);
                String newRefreshToken = jwtUtils.generateRefreshToken(userId);
                jwtUtils.deleteRefreshToken(refreshToken);

                tokenResponse.setAccessToken(newAccessToken);
                tokenResponse.setRefreshToken(newRefreshToken);
            }
            BasicResponse basicResponse = BasicResponse.builder().code(HttpStatus.OK.value()).httpStatus(HttpStatus.OK)
                    .result(Collections.singletonList(tokenResponse)).build();
            return new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());
        }
    }


    @PostMapping("/login")
    public ResponseEntity<BasicResponse> login(@RequestBody Map<String, Object> map) {
        String id = MapUtils.getString(map, "id");
        String password = MapUtils.getString(map, "password");

        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(id, password)
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        User userDetails = (User) authentication.getPrincipal();
        String accessToken = jwtUtils.generateAccessToken(userDetails.getUsername());
        String refreshToken = jwtUtils.generateRefreshToken(userDetails.getUsername());

//		List<String> roles = userDetails.getAuthorities().stream()
//				.map(item -> item.getAuthority())
//				.collect(Collectors.toList());

        UserResponse userResponse = new UserResponse(userDetails.getId(), userDetails.getName(),
                userDetails.getRole(), accessToken, refreshToken);

        BasicResponse basicResponse = BasicResponse.builder().code(HttpStatus.OK.value()).httpStatus(HttpStatus.OK)
                .result(Collections.singletonList(userResponse)).build();

        return new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());
    }


    @PostMapping("/reissue")
    public ResponseEntity<BasicResponse> reissue(@RequestBody Map<String, Object> map) {
        String oldRefreshToken = MapUtils.getString(map, "refreshToken");

        if (!jwtUtils.validateJwtToken(oldRefreshToken) || !jwtUtils.checkRefreshToken(oldRefreshToken)) {
            throw new BadCredentialsException("토큰이 만료되었습니다.");
        }

        String userId = jwtUtils.getUserNameFromJwtToken(oldRefreshToken);

        if (userService.select(userId) == null) {
            throw new RuntimeException("존재하지 않는 아이디입니다.");
        }

        String newToken = jwtUtils.generateAccessToken(userId);
        String newRefreshToken = jwtUtils.generateRefreshToken(userId);
        jwtUtils.deleteRefreshToken(oldRefreshToken);

        BasicResponse basicResponse = BasicResponse.builder().code(HttpStatus.OK.value()).httpStatus(HttpStatus.OK)
                .result(Collections.singletonList(new TokenResponse(newToken, newRefreshToken))).build();

        return new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());
    }

    @PostMapping("/join")
    public ResponseEntity<BasicResponse> join(@RequestBody Map<String, Object> map) {
        if (userService.select(MapUtils.getString(map, "id_user")) != null) {
            throw new RuntimeException("이미 존재하는 아이디입니다.");
        }

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = new User("123",
                passwordEncoder.encode("123"), "123");
        userService.insert(user);

        BasicResponse basicResponse = BasicResponse.builder().code(HttpStatus.OK.value()).httpStatus(HttpStatus.OK)
                .message("회원가입이 완료되었습니다.").result(Collections.emptyList()).build();

        return new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());
    }


}
