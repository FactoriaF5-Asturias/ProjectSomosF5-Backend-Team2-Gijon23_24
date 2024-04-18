package org.teamraccoon.dreamfusion.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    public Optional<User> findByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user set password = :password", nativeQuery = true)
    void changeUserPassword(@Param("password")String password);

}
