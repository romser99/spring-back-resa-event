package fr.solutec.resaevent.services;

import fr.solutec.resaevent.entites.Client;
import fr.solutec.resaevent.repository.ClientRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private ClientRepository userRepository;

    public UserDetailsServiceImpl(ClientRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
            Client client = userRepository.findByEmail(email).orElseThrow(() ->  new UsernameNotFoundException("Could not find user"));
            UserDetails userDetails = (UserDetails) client;
            return userDetails;

    }

}
