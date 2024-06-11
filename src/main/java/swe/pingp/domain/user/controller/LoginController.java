package swe.pingp.domain.user.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swe.pingp.domain.user.dto.LoginResponse;
import swe.pingp.domain.user.service.LoginService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    /**
     * 로그인
     */
    @PostMapping("/google")
    public ResponseEntity<LoginResponse> googleLogin() {

        LoginResponse loginResponse = new LoginResponse(1L);

        return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
    }

}