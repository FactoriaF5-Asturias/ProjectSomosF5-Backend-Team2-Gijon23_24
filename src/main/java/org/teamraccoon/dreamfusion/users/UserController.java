package org.teamraccoon.dreamfusion.users;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api-endpoint}/users")
public class UserController {
    
    UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<User> index(){
        return service.getAll();
    }

    @PutMapping("/updatePassword/{id}")
    public ResponseEntity<User> changePassword(@PathVariable("id") Long id, @RequestBody UserDto userDto)throws Exception {
        User user = service.changePassword(userDto, id);
        
        return ResponseEntity.accepted().body(user);
    }
}

