package org.teamraccoon.dreamfusion.profiles;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long>{
    public Optional<Profile> findByEmail(String name);
}
