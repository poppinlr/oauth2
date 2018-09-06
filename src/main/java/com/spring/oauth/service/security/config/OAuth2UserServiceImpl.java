package com.spring.oauth.service.security.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class OAuth2UserServiceImpl extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {

        OAuth2User user = super.loadUser(oAuth2UserRequest);
        Map<String, Object> attributes = user.getAttributes();
        Set<GrantedAuthority> authorities = new HashSet<>(user.getAuthorities());

        // At this point, you would load your data (e.g. from database) and modify the authorities as you wish
        // For the sake of testing, we'll just add the role 'ADMIN' to the user
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return new DefaultOAuth2User(authorities, attributes, "sub");
    }
}
