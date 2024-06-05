package com.yoonNeun.MyDreamPartner.domain.user.infrastructure;

import com.yoonNeun.MyDreamPartner.domain.user.domain.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

// JPARepository<Entity, Entity PK type>
public interface UserSignUpRepository extends JpaRepository<UserProfile, Integer>  {
    // 별다른 메서드를 구현하지 않아도, 기본 CRUD 사용 가능
}
