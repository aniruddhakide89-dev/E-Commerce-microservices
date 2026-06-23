package com.ecommerce.dto;

import com.ecommerce.entity.CountryCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String firstName;

    private String middleName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Pattern(regexp = "^[0-9]{10}$")
    private String mobileNumber;

    @NotBlank
    private String address;

    @NotNull
    private Long pincode;

    @NotNull
    private CountryCode countryCode;
}
