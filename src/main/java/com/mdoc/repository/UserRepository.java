package com.mdoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mdoc.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);

    public User findById(int id);

    @Transactional
    @Modifying
    @Query(value = "update users set active=false where user_id=?", nativeQuery = true)
    public void blockUser(int id);

    @Transactional
    @Modifying
    @Query(value = "update users set active=true where user_id=?", nativeQuery = true)
    public void unBlockUser(int id);

}
