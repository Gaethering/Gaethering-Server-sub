package com.gaethering.moduleuser.repository;

import com.gaethering.moduleuser.domain.MemberProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberProfileRepository extends JpaRepository<MemberProfile, Long> {

}
