package com.ecommerce.service;


import com.ecommerce.dto.UserDTO;
import com.ecommerce.entity.CountryCode;
import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.utils.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    public UserRepository userRepository;

    @Mock
    public UserMapper userMapper;

    @InjectMocks
    public UserService userService;



    private User createUser() {
        return User.builder()
                .id(1)
                .username("aniruddha")
                .firstName("Aniruddha")
                .middleName("S")
                .lastName("Kide")
                .mobileNumber("9876543210")
                .address("Pune, Maharashtra")
                .pincode(411033L)
                .countryCode(CountryCode.IN)
                .build();
    }

    private UserDTO createUserDTO() {
        UserDTO dto = new UserDTO();
        dto.setUsername("aniruddha");
        dto.setFirstName("Aniruddha");
        dto.setMiddleName("S");
        dto.setLastName("Kide");
        dto.setMobileNumber("9876543210");
        dto.setAddress("Pune, Maharashtra");
        dto.setPincode(411033L);
        dto.setCountryCode(CountryCode.IN);

        return dto;
    }


    @Test
    void addUserTest(){

        User user = createUser();

        UserDTO userDTO = createUserDTO();

        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userMapper.toEntity(any(UserDTO.class))).thenReturn(user);
        when(userMapper.toDTO(any(User.class))).thenReturn(userDTO);

        assertEquals(userService.addUser(userDTO),userDTO);

    }

    @Test
    void getUserByUserName_Test(){

        User user = createUser();
        UserDTO userDTO = createUserDTO();

        when(userRepository.findByUsername(any(String.class))).thenReturn(Optional.of(user));
        when(userMapper.toDTO(any(User.class))).thenReturn(userDTO);

        assertEquals(userService.getUserByUsername("aniruddha"),userDTO);

    }

    @Test
    void getUserById_Test(){
        User user = createUser();
        UserDTO userDTO = createUserDTO();

        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(userMapper.toDTO(any(User.class))).thenReturn(userDTO);

        assertEquals(userService.getUserById(1),userDTO);
    }

    @Test
    void deleteUserBy_Id(){
        User user = createUser();
        UserDTO userDTO = createUserDTO();

        userService.deleteUserById(1);

        verify(userRepository).deleteById(1);

    }

    @Test
    void UpdateUser_Test(){
        User user = createUser();
        UserDTO userDTO = createUserDTO();

        when(userRepository.findByUsername("aniruddha")).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        userService.updateUser(userDTO);
        verify(userRepository).save(user);

    }

    @Test
    void findAllUser_Test(){

        User user = createUser();
        UserDTO userDTO = createUserDTO();

        when(userRepository.findAll()).thenReturn(List.of(user));
        when(userMapper.toDTOList(anyList())).thenReturn(List.of(userDTO));

        assertEquals(List.of(userDTO),userService.findAllUser());


    }

}
