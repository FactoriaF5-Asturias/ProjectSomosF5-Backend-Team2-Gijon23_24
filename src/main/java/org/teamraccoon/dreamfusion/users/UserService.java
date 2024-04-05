package org.teamraccoon.dreamfusion.users;

import java.util.List;

import org.springframework.stereotype.Service;
import org.teamraccoon.dreamfusion.profiles.ProfileRepository;

@Service
public class UserService {

    UserRepository repository;
    ProfileRepository profileRepository;

    public UserService(UserRepository repository, ProfileRepository profileRepository) {
        this.repository = repository;
        this.profileRepository = profileRepository;
    }

    public List<User> getAll(){
        List<User> users = repository.findAll();

        return users;
    }

    public User delete(Long id)throws Exception{
        User userToDelete = repository.findById(id).orElseThrow(() -> new UserNotFoundException("user not found"));
        repository.deleteById(id);

        // Profile profileToDelete = repository.findByUsername()

        return userToDelete;
    }

}
