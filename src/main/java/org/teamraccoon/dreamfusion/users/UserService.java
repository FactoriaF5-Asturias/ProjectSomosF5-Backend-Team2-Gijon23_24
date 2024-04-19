package org.teamraccoon.dreamfusion.users;

import java.util.List;

import org.springframework.stereotype.Service;
import org.teamraccoon.dreamfusion.facades.encryptations.EncoderFacade;
import org.teamraccoon.dreamfusion.profiles.ProfileRepository;

@Service
public class UserService {

    UserRepository repository;
    ProfileRepository profileRepository;
    EncoderFacade encoderFacade;

    public UserService(UserRepository repository, ProfileRepository profileRepository, EncoderFacade encoderFacade) {
        this.repository = repository;
        this.profileRepository = profileRepository;
        this.encoderFacade = encoderFacade;
    }

    public List<User> getAll(){
        List<User> users = repository.findAll();

        return users;
    }

    public User changePassword(UserDto userDto, Long id) throws Exception{
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

        // encoderFacade.decode("base64", userDto.getPassword());
        
        user.setPassword(userDto.getPassword());
        
        String passwordEncode = encoderFacade.encode("bcrypt", userDto.getPassword());
        user.setPassword(passwordEncode);

        return repository.save(user);
    }
    
    public User delete(Long id)throws Exception{
        User userToDelete = repository.findById(id).orElseThrow(() -> new UserNotFoundException("user not found"));
        repository.deleteById(id);

        // Profile profileToDelete = repository.findByUsername()

        return userToDelete;
    }

}
