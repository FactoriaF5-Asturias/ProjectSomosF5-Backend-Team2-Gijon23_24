package org.teamraccoon.dreamfusion.users;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.teamraccoon.dreamfusion.facades.encryptations.EncoderFacade;
import org.teamraccoon.dreamfusion.profiles.ProfileRepository;
import org.teamraccoon.dreamfusion.utilities.UseCheckService;

@Service
public class UserService {

    UserRepository repository;
    ProfileRepository profileRepository;
    UseCheckService useCheckPassword;
    BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, ProfileRepository profileRepository,
            UseCheckService useCheckPassword) {
        this.repository = repository;
        this.profileRepository = profileRepository;
        this.useCheckPassword = useCheckPassword;
    }

    public List<User> getAll(){
        List<User> users = repository.findAll();

        return users;
    }

    public int changePassword(UserDto dto, String newPassword) throws Exception{
        Long id = dto.getId();
        String password = dto.getPassword();

        boolean checkPassword = useCheckPassword.isTruePassword(id, password);

        if (checkPassword) {
            repository.changeUserPassword(passwordEncoder.encode(newPassword));

            return 1;
        }
        return 0;
    }
    
    public User delete(Long id)throws Exception{
        User userToDelete = repository.findById(id).orElseThrow(() -> new UserNotFoundException("user not found"));
        repository.deleteById(id);

        // Profile profileToDelete = repository.findByUsername()

        return userToDelete;
    }

}
