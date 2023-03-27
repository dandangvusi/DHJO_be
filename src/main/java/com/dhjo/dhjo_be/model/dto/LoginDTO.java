package com.dhjo.dhjo_be.model.dto;

import com.dhjo.dhjo_be.constant.ErrorMessage;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    @NotBlank(message = ErrorMessage.NOT_EMPTY_ERROR)
    private String username_or_email;
    @NotBlank(message = ErrorMessage.NOT_EMPTY_ERROR)
    private String password;
}
