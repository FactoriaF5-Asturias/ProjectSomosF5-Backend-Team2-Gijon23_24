package org.teamraccoon.dreamfusion.users;

import java.util.List;

import org.springframework.stereotype.Service;
import org.teamraccoon.dreamfusion.facades.encryptations.EncoderFacade;
import org.teamraccoon.dreamfusion.profiles.ProfileRepository;

@Service
public class UserService {

    UserRepository repository;
    ProfileRepository profileRepository;
    EncoderFacade enconde;

    public UserService(UserRepository repository, ProfileRepository profileRepository, EncoderFacade enconde) {
        this.repository = repository;
        this.profileRepository = profileRepository;
        this.enconde = enconde;
    }

    public List<User> getAll(){
        List<User> users = repository.findAll();

        return users;
    }

    public User changePassword(Long id, String currentPassword, UserDto newPassword) throws Exception{
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException("user not found"));

        String passwordEncoded = enconde.encode("bcrypt", newPassword.password);

        if (currentPassword == passwordEncoded) {
            user.setPassword(passwordEncoded);
        }
        
        repository.save(user);
        return user;
    }
    
    public User delete(Long id)throws Exception{
        User userToDelete = repository.findById(id).orElseThrow(() -> new UserNotFoundException("user not found"));
        repository.deleteById(id);

        // Profile profileToDelete = repository.findByUsername()

        return userToDelete;
    }

}
