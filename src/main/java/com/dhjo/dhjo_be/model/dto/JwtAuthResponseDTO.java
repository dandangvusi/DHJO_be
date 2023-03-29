package com.dhjo.dhjo_be.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthResponseDTO {
    private String accessToken;
    private String tokenType = "Bearer";
    public JwtAuthResponseDTO(String accessToken){
        this.accessToken = accessToken;
    }
}
