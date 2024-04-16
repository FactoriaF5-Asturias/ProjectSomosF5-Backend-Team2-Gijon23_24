package org.teamraccoon.dreamfusion.users;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/UpdatePassword")
    public ResponseEntity<String> changePassword(@RequestBody RequestChangePassword request)throws Exception {
        
        UserDto dto = new UserDto();
        dto.setId(request.getUserId());
        dto.setPassword(request.getCurrentPassword());

        int check = service.changePassword(dto, request.getNewPassword());

        if (check == 1) {
            return ResponseEntity.status(HttpStatus.OK).body("Contraseña actualizada");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al actualizar");
    }
}

