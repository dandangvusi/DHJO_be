package com.dhjo.dhjo_be.model.dto;


import com.dhjo.dhjo_be.constant.ErrorMessage;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDTO {
    @NotBlank(message = ErrorMessage.NOT_EMPTY_ERROR)
    private String username;
    @NotBlank(message = ErrorMessage.NOT_EMPTY_ERROR)
    @Email(message = ErrorMessage.INVALID_EMAIL_ADDRESS_ERROR)
    private String email;
    @NotBlank(message = ErrorMessage.NOT_EMPTY_ERROR)
    private String password;
}
