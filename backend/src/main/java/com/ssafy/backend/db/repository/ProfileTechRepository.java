package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.ProfileTech;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileTechRepository extends JpaRepository<ProfileTech, Long> {

    @Override
    List<ProfileTech> findAll();
}
