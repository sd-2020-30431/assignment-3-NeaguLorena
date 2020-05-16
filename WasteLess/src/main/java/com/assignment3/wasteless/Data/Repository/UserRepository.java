package com.assignment3.wasteless.Data.Repository;

import com.assignment3.wasteless.Presentation.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findUserById(Long id);
}