package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {


}
