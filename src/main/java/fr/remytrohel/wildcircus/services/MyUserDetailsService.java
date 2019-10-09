package fr.remytrohel.wildcircus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.remytrohel.wildcircus.entities.User;
import fr.remytrohel.wildcircus.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Value("${user.mail}")
    private String mail;

    @Value("${user.password}")
    private String password;

    @Value("${user.firstname}")
    private String firstname;

    @Value("${user.lastname}")
    private String lastname;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        if(userRepository.count() == 0) {
            PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            User adminDefault = new User(firstname, lastname, mail, encoder.encode(password));
            userRepository.save(adminDefault);
        }
        User user = userRepository.findByMail(mail);
        if (user == null) {
            throw new UsernameNotFoundException(mail);
        }
        return user;
	}

}
