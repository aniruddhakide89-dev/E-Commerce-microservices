package com.ecommerce.utils;

import com.ecommerce.dto.UserDTO;
import com.ecommerce.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-29T23:39:48+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( dto.getUsername() );
        user.firstName( dto.getFirstName() );
        user.middleName( dto.getMiddleName() );
        user.lastName( dto.getLastName() );
        user.mobileNumber( dto.getMobileNumber() );
        user.address( dto.getAddress() );
        user.pincode( dto.getPincode() );
        user.countryCode( dto.getCountryCode() );
        user.role( dto.getRole() );

        return user.build();
    }

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUsername( user.getUsername() );
        userDTO.setFirstName( user.getFirstName() );
        userDTO.setMiddleName( user.getMiddleName() );
        userDTO.setLastName( user.getLastName() );
        userDTO.setMobileNumber( user.getMobileNumber() );
        userDTO.setAddress( user.getAddress() );
        userDTO.setPincode( user.getPincode() );
        userDTO.setCountryCode( user.getCountryCode() );
        userDTO.setRole( user.getRole() );

        return userDTO;
    }

    @Override
    public List<UserDTO> toDTOList(List<User> list) {
        if ( list == null ) {
            return null;
        }

        List<UserDTO> list1 = new ArrayList<UserDTO>( list.size() );
        for ( User user : list ) {
            list1.add( toDTO( user ) );
        }

        return list1;
    }
}
