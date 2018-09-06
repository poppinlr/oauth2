package com.spring.oauth.jpa.entity.convert;

import com.spring.oauth.constants.CommonConstants;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SetStringToStringConvert implements AttributeConverter<Set<String>, String> {

    @Override
    public String convertToDatabaseColumn(Set<String> stringSet) {
        return String.join(CommonConstants.DATABASE_SPLIT_SYMBOL, stringSet);
    }

    @Override
    public Set<String> convertToEntityAttribute(String s) {
        return Arrays.stream(s.split(CommonConstants.DATABASE_SPLIT_SYMBOL))
                .collect(Collectors.toSet());
    }
}
