package com.App.netflix.Mapper;

import com.App.netflix.Dto.UserDTO;
import com.App.netflix.Entity.UserModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    public UserDTO toDto (UserModel user){
    UserDTO dto = new UserDTO();
    dto.setId(user.getId());
    dto.setName(user.getName());
    dto.setEmail(user.getEmail());
    dto.setLevel(user.getLevel());
    return dto;
    }

    public UserModel toUserModel (UserDTO dto){
        UserModel user = new UserModel();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setLevel(dto.getLevel());
        return user;
    }

    public List<UserDTO> toUserModelList (List<UserModel> UserList){
        List<UserDTO> ListUsersDto = new ArrayList<>();
        for (UserModel user : UserList) {
            UserDTO userDTOcasteado = toDto(user);
            ListUsersDto.add(userDTOcasteado);
        }
        return ListUsersDto;
    }
}
