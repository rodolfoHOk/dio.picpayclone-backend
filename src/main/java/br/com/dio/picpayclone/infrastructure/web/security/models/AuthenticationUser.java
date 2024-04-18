package br.com.dio.picpayclone.infrastructure.web.security.models;

import br.com.dio.picpayclone.domain.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class AuthenticationUser extends User implements UserDetails {

    public AuthenticationUser(User user) {
        this.setId(user.getId());
        this.setLogin(user.getLogin());
        this.setPassword(user.getPassword());
        this.setPermission(user.getPermission());
        this.setActive(user.getActive());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority(getPermission().getCode())
        );
    }

    @Override
    public String getUsername() {
        return super.getLogin();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return super.getActive();
    }

}
