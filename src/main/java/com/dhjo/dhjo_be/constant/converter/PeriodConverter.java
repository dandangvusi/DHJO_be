package com.dhjo.dhjo_be.constant.converter;

import com.dhjo.dhjo_be.constant.Enum;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PeriodConverter extends GenericConverter<Enum.PERIOD, String> {
    public PeriodConverter(){
        super(Enum.PERIOD.class);
    }
}
