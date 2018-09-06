package com.spring.oauth.config;

import com.spring.oauth.service.security.config.OAuth2UserServiceImpl;
import com.spring.oauth.service.security.config.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;

@EnableWebSecurity
public class OAuth2LoginSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private OAuth2UserServiceImpl auth2UserService;

    @Autowired
    private UserDetailServiceImpl  userDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .requestMatchers().anyRequest()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/*", "/resources/*", "/login","/loginPage","/loginProcessUrl").permitAll()
                .antMatchers("/admin/*").authenticated()
                .and()
                .formLogin()
                .and()
//                .userDetailsService(userDetailService)
                .oauth2Login()
                .clientRegistrationRepository(clientRegistrationRepository());
//                .authorizedClientService(oAuth2AuthorizedClientService())
//                .authorizationEndpoint()
                /*
                 * Used by the client to obtain authorization from the resource owner via user-agent redirection.
                 */
//                .authorizationRequestRepository(authorizationRequestRepository())
//                            HttpSessionOAuth2AuthorizationRequestRepository default
//                .and()
//                .tokenEndpoint()
                /*
                 * Used by the client to exchange an authorization grant for an access token,
                 * typically with client authentication.
                 */
//                .accessTokenResponseClient(null)
//                            NimbusAuthorizationCodeTokenResponseClient
//                .and()
//                .redirectionEndpoint()
                /*
                 * Used by the authorization server to return responses containing authorization credentials
                 * to the client via the resource owner user-agent.
                 */
//                .and()
//                .userInfoEndpoint()
                /*
                 * The UserInfo Endpoint is an OAuth 2.0 Protected Resource that returns claims about the authenticated end-user.
                 * To obtain the requested claims about the end-user,
                 * the client makes a request to the UserInfo Endpoint by using an access token obtained through OpenID Connect Authentication.
                 * These claims are normally represented by a JSON object that contains a collection of name-value pairs for the claims.
                 */
//                .userService(auth2UserService);

    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration clientRegistration = ClientRegistration.withRegistrationId("google")
                .clientId("google-client-id")
                .clientSecret("google-client-secret")
                .clientAuthenticationMethod(ClientAuthenticationMethod.POST)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUriTemplate("http://localhost:8080/redirect")
                .scope("通讯录","照相机","其他")
                .authorizationUri("http://localhost:8080/oauth/authorize")
                .tokenUri("http://localhost:8080/oauth/token")
//                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
                .userNameAttributeName(IdTokenClaimNames.SUB)
//                .jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
                .clientName("Google")
                .build();
        return new InMemoryClientRegistrationRepository(clientRegistration);
    }
//
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }
}
