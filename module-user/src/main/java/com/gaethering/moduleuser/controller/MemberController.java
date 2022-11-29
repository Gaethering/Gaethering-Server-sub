package com.gaethering.moduleuser.controller;

import com.gaethering.moduleuser.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/sign-up")
    public ResponseEntity<Void> signUp(@RequestBody SignUpRequest signUpRequest) {
        memberService.signUp(signUpRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
