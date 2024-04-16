package org.teamraccoon.dreamfusion.users;

import lombok.Data;

@Data
public class RequestChangePassword {
    
    Long userId;
    String currentPassword;
    String newPassword;
}
