package com.dhjo.dhjo_be.constant.converter;

import com.dhjo.dhjo_be.constant.Enum;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class HouseTypeConverter extends GenericConverter<Enum.HOUSE_TYPE, String> {
    public HouseTypeConverter(){
        super(Enum.HOUSE_TYPE.class);
    }
}
