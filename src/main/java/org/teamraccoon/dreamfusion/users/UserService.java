package org.teamraccoon.dreamfusion.users;

import java.util.List;

import org.springframework.stereotype.Service;

import io.micrometer.common.lang.NonNull;

@Service
public class UserService {

    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll(){
        List<User> users = repository.findAll();

        return users;
    }

    public User save(@NonNull User newUser){
        User userSaved = repository.save(newUser);

        return userSaved;
    }
}
