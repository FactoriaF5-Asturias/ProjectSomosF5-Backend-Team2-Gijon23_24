package org.teamraccoon.dreamfusion.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    
    Long id;
    String username;
    String password;
    String newPassword;
}
