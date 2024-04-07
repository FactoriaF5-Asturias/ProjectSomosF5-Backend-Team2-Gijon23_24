package org.teamraccoon.dreamfusion.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teamraccoon.dreamfusion.users.User;
import org.teamraccoon.dreamfusion.users.UserRepository;

@Controller
@RequestMapping(path = "${api-endpoint}")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping(path = "/login")
    public ResponseEntity<Map<String, String>> login() {

        SecurityContext contextHolder = SecurityContextHolder.getContext();
        Authentication auth = contextHolder.getAuthentication();

        Map<String, String> json = new HashMap<>();
        json.put("message", "Logged");
        json.put("username", auth.getName());
        json.put("roles", auth.getAuthorities().iterator().next().toString());
   // Obtener el ID del usuario
   String username = auth.getName();
   Long userId = userRepository.findByUsername(username)
           .map(User::getId)
           .orElse(null);

   if (userId != null) {
       json.put("userId", userId.toString());
   }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(json);

    }
}