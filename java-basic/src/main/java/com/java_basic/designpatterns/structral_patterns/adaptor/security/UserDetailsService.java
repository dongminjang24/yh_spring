package com.java_basic.designpatterns.structral_patterns.adaptor.security;

public interface UserDetailsService {

    UserDetails loadUser(String username);

}