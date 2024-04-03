package org.teamraccoon.dreamfusion.profiles;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api-endpoint}/profiles")
public class ProfileController {
    
    ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Profile> show(@NonNull @PathVariable("id") Long id) throws Exception{
        Profile profile = service.getById(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(profile);
    }

    @PostMapping(path = "")
    public ResponseEntity<Profile> store(@RequestBody ProfileDTO profileDTO) throws Exception{
        Profile profile = service.save(profileDTO);

        System.out.println(profile);
        return ResponseEntity.status(201).body(profile);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Profile> destroy(@PathVariable("id") Long id) throws Exception{
        Profile deleted = service.delete(id);
        return ResponseEntity.accepted().body(deleted);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Profile> update(@PathVariable("id") Long id, @RequestBody ProfileDTO profileDTO) throws Exception{
        Profile profile = service.update(profileDTO, id);
        return ResponseEntity.accepted().body(profile);
    }
}
