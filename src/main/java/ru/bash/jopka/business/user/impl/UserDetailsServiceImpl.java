package ru.bash.jopka.business.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.role.model.Role;
import ru.bash.jopka.business.role.usecase.GetRoleQuery;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.usecase.FindUserByEmail;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final FindUserByEmail findUserByEmail;
    private final GetRoleQuery getRoleQuery;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findUserByEmail.execute(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User with email not found: " + username)
                );

        Role role = getRoleQuery.execute(user.getRoleId());

        Set<GrantedAuthority> authorities = Set.of(new SimpleGrantedAuthority("ROLE_" + role.getName()));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }
}
