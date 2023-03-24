package com.dhjo.dhjo_be.constant.converter;

import com.dhjo.dhjo_be.constant.Enum;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter extends GenericConverter<Enum.ROLE, String> {
    public RoleConverter(){
        super(Enum.ROLE.class);
    }
}
