package org.teamraccoon.dreamfusion.register;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teamraccoon.dreamfusion.users.User;

@RestController
@RequestMapping(path = "${api-endpoint}")
public class RegisterController {
    
    RegisterService service;

    public RegisterController(RegisterService service) {
        this.service = service;
    }

    @PostMapping(path = "/users/register")
    public String register(@RequestBody User newUser){
        return service.save(newUser);
    
    }
}
