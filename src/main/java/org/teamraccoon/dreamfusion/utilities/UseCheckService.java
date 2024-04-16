package org.teamraccoon.dreamfusion.utilities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.teamraccoon.dreamfusion.users.User;
import org.teamraccoon.dreamfusion.users.UserNotFoundException;
import org.teamraccoon.dreamfusion.users.UserRepository;

@Service
public class UseCheckService {
    
    UserRepository repository;
    BCryptPasswordEncoder passwordEncoder;

    public UseCheckService(UserRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isTruePassword(Long userId, String userPassword)throws Exception{

        User user = repository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found"));

        if(user != null){
            boolean check = passwordEncoder.matches(userPassword, user.getPassword());
            return check;
        }else{
            return false;
        }
    }
}
