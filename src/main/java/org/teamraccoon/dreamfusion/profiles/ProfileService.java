package org.teamraccoon.dreamfusion.profiles;

import java.util.Set;

import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.teamraccoon.dreamfusion.generic.IGenericEditService;
import org.teamraccoon.dreamfusion.generic.IGenericGetService;
import org.teamraccoon.dreamfusion.products.Product;
import org.teamraccoon.dreamfusion.products.ProductNotFoundException;
import org.teamraccoon.dreamfusion.products.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfileService implements IGenericEditService<ProfileDTO, Profile>, IGenericGetService<Profile> {

    ProfileRepository repository;
    ProductRepository productRepository;

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
       profile.setCity(profileDTO.getCity());
       profile.setProvince(profileDTO.getProvince());

       return repository.save(profile);
    }

    public Profile updateFavorites(Long productId) throws Exception {
        
        SecurityContext contextHolder = SecurityContextHolder.getContext();
        Authentication auth = contextHolder.getAuthentication();
        
        Profile updatingProfile = repository.findByEmail(auth.getName()).orElseThrow(() -> new ProfileNotFoundException("Profile not found"));

        Product newProduct = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));

        Set<Product> favoriteProducts = updatingProfile.getFavorites();

        if (favoriteProducts.contains(newProduct)) {
            favoriteProducts.remove(newProduct);
        } else {
            favoriteProducts.add(newProduct);
        }

        updatingProfile.setFavorites(favoriteProducts);

        Profile updatedProfile = repository.save(updatingProfile);
        
        return updatedProfile;
    }
    public Profile getFavoriteProfile(Long id) {
        // Retrieve the profile with the given ID from the repository
        return repository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found with ID: " + id));
    }
    
}
