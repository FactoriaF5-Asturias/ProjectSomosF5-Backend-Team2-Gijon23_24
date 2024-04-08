package org.teamraccoon.dreamfusion.users;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
        List<User> users = service.getAll();
        // Aquí puedes ajustar la respuesta para incluir el ID del usuario
        // Por ejemplo, podrías mapear los usuarios a un DTO que incluya solo los campos que deseas exponer
        return users;
       
    }

}
