package com.gaethering.moduleuser.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.gaethering.modulecommon.domain.Member;
import com.gaethering.modulecommon.repository.MemberRepository;
import com.gaethering.modulecommon.type.MemberStatus;
import com.gaethering.moduleuser.domain.Pet;
import com.gaethering.moduleuser.type.Gender;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class PetRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PetRepository petRepository;

    @Test
    void savePet_Success() {
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

        Pet pet1 = Pet.builder()
            .name("뽀삐")
            .birth(LocalDate.of(2021, 3, 15))
            .gender(Gender.FEMALE)
            .breed("말티즈")
            .weight(5.5f)
            .isNeutered(true)
            .isRepresentative(true)
            .description("귀여운 뽀삐")
            .imageUrl("기본 이미지")
            .member(member)
            .build();

        Pet pet2 = Pet.builder()
            .name("뽀삐")
            .birth(LocalDate.of(2021, 3, 15))
            .gender(Gender.FEMALE)
            .breed("말티즈")
            .weight(5.5f)
            .isNeutered(true)
            .isRepresentative(true)
            .description("귀여운 뽀삐")
            .imageUrl("기본 이미지")
            .member(member)
            .build();

        //when
        petRepository.save(pet1);
        petRepository.save(pet2);

        List<Pet> pets = petRepository.findAll();

        //then
        assertEquals(pets.size(), 2);
        assertEquals(member.getEmail(), pets.get(0).getMember().getEmail());
     }

}