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

    public Profile save(ProfileDTO profileDTO) throws Exception {
        
        try{
            Profile newProfile = Profile.builder()
                .email(profileDTO.getEmail())
                .firstName(profileDTO.getFirstName())
                .lastName(profileDTO.getLastName())
                .address(profileDTO.getAddress())
                .postalCode(profileDTO.getPostalCode())
                .numberPhone(profileDTO.getNumberPhone())
                .build();

            repository.save(newProfile);
            System.out.println(newProfile);

            Long profileTableQuantity = (long) repository.findAll().size();
            Profile profile = repository.findById(profileTableQuantity).orElseThrow(() -> new ProfileNotFoundException("Not Found"));

            return profile;

        }catch(Exception e){
            throw new Exception("Error al guardar" + e.getMessage());
        }
    }

    public Profile delete(Long id){
        Profile profileToDelete = repository.findById(id).orElseThrow(()-> new ProfileNotFoundException("Profile Not Found"));
        repository.deleteById(id);

        return profileToDelete;
    }

    @Override
    public Profile update(ProfileDTO profileDTO, Long id) {
       Profile profile = repository.findById(id).orElseThrow(()-> new ProfileNotFoundException("Profile Not Found"));

       profile.setAddress(profileDTO.getAddress());
       profile.setNumberPhone(profileDTO.getNumberPhone());
       profile.setPostalCode(profileDTO.getPostalCode());

       return repository.save(profile);
    }

    
    
}
