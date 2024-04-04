package org.teamraccoon.dreamfusion.profiles;

import org.teamraccoon.dreamfusion.users.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {
    
    private User user;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String province;
    private String postalCode;
    private String numberPhone;
}
