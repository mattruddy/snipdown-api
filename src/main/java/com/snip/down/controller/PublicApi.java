package com.snip.down.controller;

import com.snip.down.model.dto.*;
import com.snip.down.service.AuthService;
import com.snip.down.service.SnipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/public", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class PublicApi {

    @Autowired private AuthService authService;
    @Autowired private SnipService snipService;

    @GetMapping(value = "/snips/{snipId}")
    public SnipResponse getSnip(@PathVariable("snipId") long id) {
        return snipService.getSnip(id);
    }

    // POST
    @PostMapping(value = "/signup")
    public AuthTokenResponse signup(@RequestBody SignUpRequest signUpRequest) {
        return authService.signup(signUpRequest);
    }

    @PostMapping(value = "/login")
    public AuthTokenResponse login(@RequestBody LoginRequest request) {
        return authService.login(request.getUsername(), request.getPassword());
    }

    @PostMapping(value = "/snips")
    public SnipResponse createSnip(@RequestBody SnipRequest request) {
        return snipService.createSnip(request);
    }
}
