package org.teamraccoon.dreamfusion.roles;

import org.springframework.stereotype.Service;
import org.teamraccoon.dreamfusion.generic.IGenericGetService;

import io.micrometer.common.lang.NonNull;

@Service
public class RoleService implements IGenericGetService<Role>{
    
    RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public Role getById(@NonNull Long id){
        Role role = repository.findById(id).orElseThrow( () -> new RoleNotFoundException("Role Not Found"));

        return role;
    }
}
