package com.ecommerce.service;


import com.ecommerce.dto.UserDTO;
import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.utils.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO addUser(UserDTO dto){
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(dto)));
    }

    public UserDTO getUserByUsername(String username){
        return userRepository.findByUsername(username).map(userMapper::toDTO).orElseThrow(() -> new RuntimeException("User with username: " + username + " Not available"));
    }

    public UserDTO getUserById(Integer id){
        return userRepository.findById(id).map(userMapper::toDTO).orElseThrow(() -> new RuntimeException("Cannot find User by Id :" + id ));
    }

    public void deleteUserById(Integer id){
        userRepository.deleteById(id);
    }

    public void updateUser(UserDTO userDTO){
        User user = userRepository.findByUsername(userDTO.getUsername()).orElse(null);
        if (user != null){
            user.setFirstName(userDTO.getFirstName());
            user.setMiddleName(userDTO.getMiddleName());
            user.setLastName(userDTO.getLastName());
            user.setUsername(userDTO.getUsername());
            user.setMobileNumber(userDTO.getMobileNumber());
            user.setAddress(userDTO.getAddress());
            user.setPincode(userDTO.getPincode());
            user.setCountryCode(userDTO.getCountryCode());
            userRepository.save(user);
        }
        else {
            throw new RuntimeException("User Does not exist");
        }
    }

    public List<UserDTO> findAllUser(){
        return userMapper.toDTOList(userRepository.findAll());
    }






}
