package com.gaethering.moduleuser.dto;

import com.gaethering.moduleuser.type.Gender;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class SignUpRequest {

    private String email;

    private String nickname;

    private String password;

    private String passwordCheck;

    private String name;

    private String phone;

    private LocalDate birth;

    private Gender gender;

}
