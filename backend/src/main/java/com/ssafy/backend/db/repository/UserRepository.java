package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.Project;
import com.ssafy.backend.db.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 아래와 같이, Query Method 인터페이스(반환값, 메소드명, 인자) 정의를 하면 자동으로 Query Method 구현됨.
    Optional<User> findByUsername(String username);

    Page<User> findAll(Pageable pageable);


    boolean existsByUsername(String username);
}
