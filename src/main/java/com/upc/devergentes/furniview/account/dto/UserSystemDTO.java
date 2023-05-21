package com.upc.devergentes.furniview.account.dto;

import com.upc.devergentes.furniview.account.model.domain.UserSystem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSystemDTO {

    private Long id;
    private String username;
    private String email;

    // Constructors, getters, and setters

    public static UserSystemDTO fromUserSystem(UserSystem userSystem) {
        UserSystemDTO userSystemDTO = new UserSystemDTO();
        userSystemDTO.setId(userSystem.getId());
        userSystemDTO.setUsername(userSystem.getUsername());
        userSystemDTO.setEmail(userSystem.getEmail());
        return userSystemDTO;
    }
    public UserSystem toUserSystem() {
        UserSystem auserSystem = new UserSystem();
        auserSystem.setId(id);
        auserSystem.setUsername(username);
        auserSystem.setEmail(email);
        return auserSystem;
    }
}
