package com.dhjo.dhjo_be.constant.converter;

import com.dhjo.dhjo_be.constant.Enum;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EducationConverter extends GenericConverter<Enum.EDUCATION, String> {
    public EducationConverter(){
        super(Enum.EDUCATION.class);
    }
}
