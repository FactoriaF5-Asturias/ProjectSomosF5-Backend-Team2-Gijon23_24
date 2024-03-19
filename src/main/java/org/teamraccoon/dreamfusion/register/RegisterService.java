package org.teamraccoon.dreamfusion.register;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.teamraccoon.dreamfusion.facades.encryptations.EncoderFacade;
import org.teamraccoon.dreamfusion.roles.Role;
import org.teamraccoon.dreamfusion.roles.RoleService;
import org.teamraccoon.dreamfusion.users.User;
import org.teamraccoon.dreamfusion.users.UserRepository;

@Service
public class RegisterService {

    UserRepository userRepository;
    RoleService roleService;
    EncoderFacade encoder;

    public RegisterService(UserRepository userRepository, RoleService roleService, EncoderFacade encoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.encoder = encoder;
    }

    public String save(User newUser) {

        String passwordDecoded = encoder.decode("base64", newUser.getPassword());
        System.out.println(passwordDecoded);
        String passwordEncoded = encoder.encode("bcrypt", passwordDecoded);
        

        newUser.setPassword(passwordEncoded);
        assignDefaultRole(newUser);

        userRepository.save(newUser);

        return "user stored successfully :" + newUser.getUsername();

    }

    public void assignDefaultRole(User user) {

        Role defaultRole = roleService.getById(2L);
        Set<Role> roles = new HashSet<>();
        roles.add(defaultRole);

        user.setRoles(roles);
    }
}