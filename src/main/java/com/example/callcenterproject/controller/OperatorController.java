package com.example.callcenterproject.controller;

import com.example.callcenterproject.dto.OperatorRequestDto;
import com.example.callcenterproject.dto.OperatorResponseDto;
import com.example.callcenterproject.model.JwtRequest;
import com.example.callcenterproject.model.JwtResponse;
import com.example.callcenterproject.service.JwtUserDetailsService;
import com.example.callcenterproject.service.inter.OperatorService;
import com.example.callcenterproject.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/operator")
public class OperatorController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService userDetailsService;
    private final OperatorService operatorService;

    public OperatorController(AuthenticationManager authenticationManager,
                              JwtTokenUtil jwtTokenUtil, JwtUserDetailsService userDetailsService,
                              OperatorService operatorService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.operatorService = operatorService;
    }

    @PostMapping("/register")
    public ResponseEntity<OperatorResponseDto> register(@RequestBody OperatorRequestDto operatorRequestDto) {
        log.info("Operator registered successfully");
        return new ResponseEntity<>(operatorService.addAgent(operatorRequestDto), HttpStatus.CREATED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) throws Exception {
        authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(jwtRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        log.info("Operator logged in successfully");
        return new ResponseEntity<>(new JwtResponse(token), HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}