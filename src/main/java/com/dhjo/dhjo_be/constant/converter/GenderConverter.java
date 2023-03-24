package com.dhjo.dhjo_be.constant.converter;

import com.dhjo.dhjo_be.constant.Enum;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter extends GenericConverter<Enum.GENDER, String> {
    public GenderConverter(){
        super(Enum.GENDER.class);
    }
}
