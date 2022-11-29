package com.gaethering.moduleuser.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gaethering.modulecommon.domain.Member;
import com.gaethering.modulecommon.repository.MemberRepository;
import com.gaethering.modulecommon.type.MemberStatus;
import com.gaethering.moduleuser.domain.MemberProfile;
import com.gaethering.moduleuser.type.Gender;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class MemberProfileRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberProfileRepository memberProfileRepository;

    @Test
    void saveMemberProfile_Success() {
        //given
        Member member = Member.builder()
            .email("gaethering@gmail.com")
            .nickname("개더링")
            .password("1234qwer!")
            .status(MemberStatus.ACTIVE)
            .accessDate(LocalDateTime.now())
            .isEmailAuth(true)
            .build();

        memberRepository.save(member);

        MemberProfile memberProfile = MemberProfile.builder()
            .gender(Gender.MALE)
            .phoneNumber("010-0000-0000")
            .member(member)
            .build();

        //when
        MemberProfile savedMemberProfile = memberProfileRepository.save(memberProfile);

        //then
        assertEquals(savedMemberProfile.getMannerDegree(), 36.5f);
    }

}