package com.wfh.mobilestorespring.repository;

import com.wfh.mobilestorespring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public User findUserByUsername(String username);
}
