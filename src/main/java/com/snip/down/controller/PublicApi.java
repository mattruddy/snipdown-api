package com.snip.down.controller;

import com.snip.down.model.dto.AuthTokenResponse;
import com.snip.down.model.dto.LoginRequest;
import com.snip.down.model.dto.SignUpRequest;
import com.snip.down.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/public", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class PublicApi {

    @Autowired private AuthService authService;

    // POST
    @PostMapping(value = "/signup")
    public AuthTokenResponse signup(@RequestBody SignUpRequest signUpRequest) {
        return authService.signup(signUpRequest);
    }

    @PostMapping(value = "/login")
    public AuthTokenResponse login(@RequestBody LoginRequest request) {
        return authService.login(request.getUsername(), request.getPassword());
    }
}
