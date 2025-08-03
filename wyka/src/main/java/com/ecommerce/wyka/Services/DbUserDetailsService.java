package com.ecommerce.wyka.Services;

import com.ecommerce.wyka.Config.SecurityConfig;
import com.ecommerce.wyka.Model.AccountStatus;
import com.ecommerce.wyka.Model.UserPrincipal;
import com.ecommerce.wyka.Model.Users;
import com.ecommerce.wyka.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;





    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(user);
    }


    public Users createAccount(Users users) {
        AccountStatus accountStatus = new AccountStatus();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        accountStatus.setEnabled(true);
        accountStatus.setAccountNonExpired(true);
        accountStatus.setAccountNonLocked(true);
        accountStatus.setCredentialsNonExpired(true);
        String hashedPassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(hashedPassword);
        users.setAccountStatus(accountStatus);
        return userRepo.save(users);


    }
}
