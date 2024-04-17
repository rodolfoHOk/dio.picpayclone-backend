package br.com.dio.picpayclone.configuration.security;

import br.com.dio.picpayclone.domain.constants.ValidationMessages;
import br.com.dio.picpayclone.domain.models.User;
import br.com.dio.picpayclone.domain.services.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    private final IUserService userService;

    public CustomUserDetailsService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userService.findByLogin(username);
        if (!validateUser(user)) {
            throw new UsernameNotFoundException(ValidationMessages.ERROR_USER_WITHOUT_PERMISSION);
        }
        return (AuthenticationUser) user;
    }

    private boolean validateUser(User user) {
        return user != null && user.getPermission() != null && user.getActive();
    }

}
