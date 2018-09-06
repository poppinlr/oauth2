package com.spring.oauth.jpa.entity.convert;

import com.spring.oauth.constants.CommonConstants;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.AttributeConverter;
import java.util.*;
import java.util.stream.Collectors;

public class SimpleGrantedAuthorityToStringConvert implements AttributeConverter<Set<SimpleGrantedAuthority>, String> {


    @Override
    public String convertToDatabaseColumn(Set<SimpleGrantedAuthority> simpleGrantedAuthorities) {
        return simpleGrantedAuthorities.parallelStream()
                .map(SimpleGrantedAuthority::getAuthority)
                .collect(Collectors.joining(CommonConstants.DATABASE_SPLIT_SYMBOL));
    }

    @Override
    public Set<SimpleGrantedAuthority> convertToEntityAttribute(String s) {
        return Optional.ofNullable(s)
                .map(string -> Arrays.stream(string.split(CommonConstants.DATABASE_SPLIT_SYMBOL))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toSet()))
                .orElse(Collections.emptySet());
    }
}
