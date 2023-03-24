package com.dhjo.dhjo_be.constant.converter;

import com.dhjo.dhjo_be.constant.PersistableEnum;
import jakarta.persistence.AttributeConverter;

import java.util.stream.Stream;

public class GenericConverter<E extends PersistableEnum<T>, T> implements AttributeConverter<E, T> {
    private Class<E> enumType;
    public GenericConverter(Class<E> enumType){
        this.enumType = enumType;
    }
    @Override
    public T convertToDatabaseColumn(E e) {
        if (e == null){
            return null;
        }
        return e.getValue();
    }

    @Override
    public E convertToEntityAttribute(T t) {
        if (t == null){
            return null;
        }
        return Stream.of(this.enumType.getEnumConstants())
                .filter(c -> c.getValue().equals(t))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
