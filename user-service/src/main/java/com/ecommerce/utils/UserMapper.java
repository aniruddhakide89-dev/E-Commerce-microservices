package com.ecommerce.utils;

import com.ecommerce.dto.UserDTO;
import com.ecommerce.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDTO dto);
    UserDTO toDTO(User user);
    List<UserDTO> toDTOList(List<User> list);

}
