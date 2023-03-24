package com.dhjo.dhjo_be.constant.converter;

import com.dhjo.dhjo_be.constant.Enum;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SkillConverter extends GenericConverter<Enum.SKILL, String> {
    public SkillConverter(){
        super(Enum.SKILL.class);
    }
}
