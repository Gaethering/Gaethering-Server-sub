package com.gaethering.moduleuser.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.gaethering.modulecommon.domain.Member;
import com.gaethering.modulecommon.repository.MemberRepository;
import com.gaethering.modulecommon.type.MemberStatus;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void saveMember_Success() {
        //given
        Member member = Member.builder()
            .email("gaethering@gmail.com")
            .nickname("개더링")
            .password("1234qwer!")
            .status(MemberStatus.ACTIVE)
            .accessDate(LocalDateTime.now())
            .isEmailAuth(true)
            .build();

        //when
        Member savedMember = memberRepository.save(member);

        //then
        assertEquals(savedMember.getStatus(), MemberStatus.ACTIVE);
        assertNotNull(savedMember.getCreatedAt());
        assertNotNull(savedMember.getUpdatedAt());
     }

}