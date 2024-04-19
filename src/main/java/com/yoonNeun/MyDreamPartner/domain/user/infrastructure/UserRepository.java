package com.yoonNeun.MyDreamPartner.domain.user.infrastructure;

import com.yoonNeun.MyDreamPartner.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}