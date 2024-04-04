package org.teamraccoon.dreamfusion.profiles;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.teamraccoon.dreamfusion.generic.IGenericEditService;
import org.teamraccoon.dreamfusion.generic.IGenericGetService;

@Service
public class ProfileService implements IGenericEditService<ProfileDTO, Profile>, IGenericGetService<Profile> {

    ProfileRepository repository;

    public ProfileService(ProfileRepository repository) {
        this.repository = repository;
    }

    public Profile getById(@NonNull Long id)throws Exception{
        Profile profile = repository.findById(id).orElseThrow(() -> new ProfileNotFoundException("Profile not found"));

        return profile;
    }

    @Override
    public Profile update(ProfileDTO profileDTO, Long id) {
       Profile profile = repository.findById(id).orElseThrow(()-> new ProfileNotFoundException("Profile Not Found"));

       profile.setFirstName(profileDTO.getFirstName());
       profile.setLastName(profileDTO.getLastName());
       profile.setAddress(profileDTO.getAddress());
       profile.setNumberPhone(profileDTO.getNumberPhone());
       profile.setPostalCode(profileDTO.getPostalCode());

       return repository.save(profile);
    }

    @Override
    public Profile save(ProfileDTO type) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    
    
}
