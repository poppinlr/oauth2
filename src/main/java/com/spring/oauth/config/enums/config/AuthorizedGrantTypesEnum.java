package com.spring.oauth.config.enums.config;

public enum AuthorizedGrantTypesEnum {
    implicit,//client_id+ client_secret + redirect_uri
    refresh_token,
    password,//username+password
    authorization_code,//client_id+ client_secret + redirect_uri
    client_credentials;//client_id+ client_secret
}
