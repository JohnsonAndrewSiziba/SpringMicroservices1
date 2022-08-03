package com.dailycodebuffer.user.repository;


import com.dailycodebuffer.user.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Long> {
    MyUser findByUserId(Long userId);
}
