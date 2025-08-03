package com.ecommerce.wyka.Model;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {

    @Getter
    private Users user;
    private AccountStatus accountStatus;


    public UserPrincipal(Users user) {
        this.user = user;
        this.accountStatus = user.getAccountStatus();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountStatus != null && accountStatus.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountStatus != null && accountStatus.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return accountStatus != null && accountStatus.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return accountStatus != null && accountStatus.isEnabled();
    }

}
