package com.restapi.airlines.model;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class User {
    private int idUser;

    private String nameUser;

    @Size(min=2, message = "Last name must not be less than 2 characters")
    private String firstNameUser;

//    @NotBlank(message = "Last name must be filled")
    @Size(min=2, message = "Last name must not be less than 2 characters")
    private String lastNameUser;

//    @NotBlank(message = "First  must be filled")
    private String phoneNumUser;

//    @NotBlank(message = "Email name must be filled")
    @Email(message = "Email format is wrong")
    private String emailUser;

//    @NotBlank(message = "Password must be filled")
    @Size(min=8, max=16, message = "Password must be equal or greater than 8 and less than 16 character")
    private String passwordUser;
}
